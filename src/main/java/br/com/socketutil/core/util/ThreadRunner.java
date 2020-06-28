package br.com.socketutil.core.util;

public class ThreadRunner {
	
	public static void run(Runnable... runnables) {
		for (Runnable runnable : runnables) {
			new Thread(runnable).start();
		}
	}
	
}
