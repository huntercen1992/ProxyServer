package com.hunter.proxy.proxyServer.Util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {

	private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	
	
	public static void execute(Runnable command){
		executor.execute(command);
	}
}
