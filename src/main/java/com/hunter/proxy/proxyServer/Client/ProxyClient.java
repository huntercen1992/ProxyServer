package com.hunter.proxy.proxyServer.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hunter.proxy.proxyServer.Encryption.EncryptUtil;
import com.hunter.proxy.proxyServer.Server.ProxyServer;

public class ProxyClient extends Thread{
	
	private static String proxyServerHost = "ec2-54-255-236-129.ap-southeast-1.compute.amazonaws.com";
	private static int proxyServerPort = 9999;

	private Socket socket = null;
	
	public ProxyClient(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		InputStream browserInput = null;
		OutputStream browserOutput = null;
		
		Socket proxySocket = null;
        InputStream proxyInput = null;
        OutputStream proxyOutput = null;
		
		String host = "";
        int port = 80;
        String type = "";
		
		try{
			browserOutput = socket.getOutputStream();
			browserInput = socket.getInputStream();
			String line;
			BufferedReader lineBuffer = new BufferedReader(new InputStreamReader(browserInput));
            StringBuilder headStr = new StringBuilder();
            int lineCount = 1;
            //读取HTTP请求头，并拿到HOST请求头和method
            while (null != (line = lineBuffer.readLine())) {
                //System.out.println(line);
                headStr.append(line + "\r\n");
                if (line.length() == 0) {
                    break;
                }
            }
            String[] result = EncryptUtil.getTypeAndHostAndPort(headStr.toString());
    		type = result[0];
    		host = result[1];
    		port = Integer.valueOf(result[2]);
            
            //if(host.indexOf("www.baidu.com")==-1)return;
            //if(host.indexOf("tool.chinaz.com")==-1)return;           
            //System.out.println(Thread.currentThread().getName()+"============================>"+type+" "+host+":"+port);
            //System.out.println(headStr);
            
            //连接到代理服务器
            //proxySocket = new Socket(ProxyClient.proxyServerHost, ProxyClient.proxyServerPort);
            proxySocket = new Socket();
            proxySocket.connect(new InetSocketAddress(ProxyClient.proxyServerHost, ProxyClient.proxyServerPort), 10000);
            //proxySocket.connect(new InetSocketAddress(host,port), 5000);
            proxySocket.setSoTimeout(5000);
            proxyInput = proxySocket.getInputStream();
            proxyOutput = proxySocket.getOutputStream();
            
            byte[] encryptByte =  EncryptUtil.encrypt(headStr.toString().getBytes());
            proxyOutput.write(encryptByte);
            proxyOutput.flush();
            
            //新开线程转发客户端请求至代理服务器
            new RequestHandle(browserInput, proxyOutput, type, host, port).start();         
            
            //转发目标服务器响应至客户端
            int count;
            byte[] content = new byte[4096];            
            while((count = proxyInput.read(content)) != -1){
            	content = EncryptUtil.decrypt(content);
            	browserOutput.write(content, 0, count);
            	browserOutput.flush();
            }
            browserOutput.flush();
            proxySocket.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if (proxyInput != null) {
                try {
                	proxyInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (proxyOutput != null) {
                try {
                    proxyOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (proxySocket != null) {
                try {
                    proxySocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (browserInput != null) {
                try {
                	browserInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (browserOutput != null) {
                try {
                	browserOutput.close();
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
    		ServerSocket server  = new ServerSocket(8888);
    		while(true){
    			Socket socket = server.accept();
    			ProxyClient pc = new ProxyClient(socket);
    			pc.start();
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
		//http://127.0.0.1:8090/proxy.pac
//		try{
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1",9999));
//			URL url = new URL("http://www.hottoys.com.hk/");
//			
//			URLConnection conn = url.openConnection(proxy);
//			conn.connect();
//			//OutputStream output = conn.getOutputStream();
//			//output.write(1);
//			
//			while(true){
//				
//			}
//			
//		}catch(Exception ex){
//    		ex.printStackTrace();
//    	}
    }
}
