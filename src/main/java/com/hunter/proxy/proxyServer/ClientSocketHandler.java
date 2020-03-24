package com.hunter.proxy.proxyServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientSocketHandler extends Thread{

	private Socket socket = null;
	
	public ClientSocketHandler(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+"============================>"+"Clinet port:"+socket.getPort());
		
		InputStream clientInput = null;
		OutputStream clientOutput = null;
		
		Socket proxySocket = null;
        InputStream proxyInput = null;
        OutputStream proxyOutput = null;
            
        String host = "";
        int port = 80;
        String type = "";
        
		try{
			clientInput = socket.getInputStream();
			clientOutput = socket.getOutputStream();
			String line;
            
            BufferedReader lineBuffer = new BufferedReader(new InputStreamReader(clientInput));
            StringBuilder headStr = new StringBuilder();
            //读取HTTP请求头，并拿到HOST请求头和method
            while (null != (line = lineBuffer.readLine())) {
                //System.out.println(line);
                headStr.append(line + "\r\n");
                if (line.length() == 0) {
                    break;
                } else {
                    String[] temp = line.split(" ");
                    if (temp[0].contains("Host")) {
                        host = temp[1];
                    }
                }
            }
            type = headStr.substring(0, headStr.indexOf(" "));
            //根据host头解析出目标服务器的host和port
            String[] hostTemp = host.split(":");
            host = hostTemp[0];            
            if (hostTemp.length > 1) {
                port = Integer.valueOf(hostTemp[1]);
            }
            System.out.println(Thread.currentThread().getName()+"============================>"+type+" "+host+":"+port);
            
            //连接到目标服务器
            proxySocket = new Socket();
            proxySocket.connect(new InetSocketAddress(host,port), 5000);
            proxyInput = proxySocket.getInputStream();
            proxyOutput = proxySocket.getOutputStream();
            //根据HTTP method来判断是https还是http请求
            if ("CONNECT".equalsIgnoreCase(type)) {//https先建立隧道
                clientOutput.write("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes());
                clientOutput.flush();
            } else {//http直接将请求头转发
                proxyOutput.write(headStr.toString().getBytes());
            }
            //新开线程转发客户端请求至目标服务器
            new ProxyHandleThread(clientInput, proxyOutput).start();
            //转发目标服务器响应至客户端          
            byte[] result = new byte[4096];
            int count;
            while((count = proxyInput.read(result)) != -1){
            	clientOutput.write(result, 0, count);
            }
            clientOutput.flush();
		}catch(ConnectException ce){
			System.out.println("ConnectException---------->"+type+" "+host+":"+port);
			ce.printStackTrace();
		}catch(SocketTimeoutException ste){
			System.out.println(Thread.currentThread().getName()+"============================>connect timed out:"+type+" "+host+":"+port);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
		
			if (proxyInput != null) {
                try {
                    proxyOutput.close();
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
}
