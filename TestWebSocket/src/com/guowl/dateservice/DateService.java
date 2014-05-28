package com.guowl.dateservice;

public class DateService implements Runnable {
	private static long	currentTime;
	static {
		new Thread(new DateService()).start();
	}

	public static long getTime() {
		return currentTime;
	}
	
	@Override
	public void run() {
		while (true) {
			currentTime = System.currentTimeMillis();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}

	}
}
