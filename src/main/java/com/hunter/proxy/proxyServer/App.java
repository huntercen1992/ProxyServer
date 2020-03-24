package com.hunter.proxy.proxyServer;

import java.net.ServerSocket;
import java.net.Socket;

import com.hunter.proxy.proxyServer.Client.ProxyClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { 	
    	try{
    		ServerSocket server  = new ServerSocket(8888);
    		while(true){
    			Socket socket = server.accept();
    			ClientSocketHandler pc = new ClientSocketHandler(socket);
    			pc.start();
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
}
