package com.hunter.proxy.proxyServer.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.hunter.proxy.proxyServer.Encryption.EncryptUtil;

public class RequestHandle extends Thread{
	
	private InputStream browserInput;
	private OutputStream targetOutput;
	
	private String type;
	private String host;
	private int port;
	
	public RequestHandle(InputStream browserInput,OutputStream targetOutput,String type,String host,int port){
		this.browserInput = browserInput;
		this.targetOutput = targetOutput;
		this.type = type;
		this.host = host;
		this.port = port;
	}
	
	public void run(){		
		try {
			int count;
            while (true) {          	
            	byte[] content = new byte[4096];
            	if((count = browserInput.read(content)) != -1){
            		content = EncryptUtil.decrypt(content);
            		//System.out.print(new String(content, 0, count));
            		targetOutput.write(content, 0, count);
            		targetOutput.flush();
            	}       	
            }
        } catch (IOException e) {
        	//System.out.println(Thread.currentThread().getName()+"============================>"+type + " " + host + ":" + port+"============================>:proxyStream has been closed");
        }
	}
}
