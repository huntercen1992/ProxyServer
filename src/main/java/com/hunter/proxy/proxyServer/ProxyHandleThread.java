package com.hunter.proxy.proxyServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProxyHandleThread extends Thread{
	private InputStream input;
    private OutputStream output;

    public ProxyHandleThread(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        try {
            while (true) {
                output.write(input.read());
            }
        } catch (IOException e) {
            System.out.println(Thread.currentThread().getName()+"============================>:proxyStream has been closed");
        }
    }
}
