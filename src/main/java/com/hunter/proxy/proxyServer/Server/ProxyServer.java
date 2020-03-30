package com.hunter.proxy.proxyServer.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hunter.proxy.proxyServer.ClientSocketHandler;
import com.hunter.proxy.proxyServer.Client.ProxyClient;
import com.hunter.proxy.proxyServer.Server.RequestHandle;
import com.hunter.proxy.proxyServer.Encryption.EncryptUtil;

public class ProxyServer extends Thread{

	private Socket socket = null;
	
	public ProxyServer(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		InputStream clientInput = null;
		OutputStream clientOutput = null;
		
		Socket targetSocket = null;
        InputStream targetInput = null;
        OutputStream targetOutput = null;
        
        String host = "";
        int port = 80;
        String type = "";
        
        try{
        	clientOutput = socket.getOutputStream();
        	clientInput = socket.getInputStream();
        	
        	byte[] resource = new byte[4096];
        	String headStr = "";
        	int count = clientInput.read(resource);
        	if(count != -1){
        		resource = EncryptUtil.decrypt(resource);
        		headStr = new String(resource, 0, count);
        		
        		String[] result = EncryptUtil.getTypeAndHostAndPort(headStr);
        		type = result[0];
        		host = result[1];
        		port = Integer.valueOf(result[2]);
        	}
        	//System.out.println(Thread.currentThread().getName()+"============================>"+type+" "+host+":"+port);
        	//System.out.println(headStr);
        	
        	//连接到目标服务器
        	targetSocket = new Socket();
        	targetSocket.connect(new InetSocketAddress(host, port), 5000);
        	targetSocket.setSoTimeout(5000);
        	targetInput = targetSocket.getInputStream();
        	targetOutput = targetSocket.getOutputStream();
            //根据HTTP method来判断是https还是http请求
            if ("CONNECT".equalsIgnoreCase(type)) {//https先建立隧道
            	clientOutput.write(EncryptUtil.encrypt("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes()));
            	clientOutput.flush();       	  
            } else {//http直接将请求头转发
          	    targetOutput.write(headStr.getBytes());
          	    targetOutput.flush();
            }
          
            //新开线程转发客户端请求至目标服务器
            new RequestHandle(clientInput, targetOutput, type, host, port).start();
        	
            //转发目标服务器响应至客户端
            byte[] content = new byte[4096];            
            while((count = targetInput.read(content)) != -1){
            	//System.out.print(new String(content, 0, count));
            	content = EncryptUtil.encrypt(content);           	
            	clientOutput.write(content, 0, count);
            	clientOutput.flush();
            }
            targetSocket.close();
            clientOutput.flush();
        }catch(Exception ex){
        	//ex.printStackTrace();
        	//System.out.println(Thread.currentThread().getName()+"============================>"+ex.getMessage());
        }finally{
			if (targetInput != null) {
                try {
                	targetInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (targetOutput != null) {
                try {
                	targetOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (targetSocket != null) {
                try {
                	targetSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientInput != null) {
                try {
                	clientInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientOutput != null) {
                try {
                	clientOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
	}
	
	public static void main( String[] args )
    { 	
    	try{
    		ExecutorService es = Executors.newCachedThreadPool();    		
    		ServerSocket server  = new ServerSocket(9999);
    		while(true){
    			Socket socket = server.accept();
    			ProxyServer ps = new ProxyServer(socket);
    			es.execute(ps);
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
}
