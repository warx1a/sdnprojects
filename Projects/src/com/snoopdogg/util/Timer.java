package com.snoopdogg.util;

public class Timer {
	private long timeout;
	private long starttime;
	
	public Timer(final long timeout) {
		this.timeout = timeout + System.currentTimeMillis();
		this.starttime = System.currentTimeMillis();
	}
	public long getRemaining() {
		return timeout - starttime;
	}
	
	public void extend(final long time) {
		this.timeout += time;
	}
	
	public long getStartTime() {
		return starttime;
	}
	
	public long getEnd() {
		return timeout;
	}
	
	public boolean isRunning() {
		return timeout > System.currentTimeMillis();
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Timer t = new Timer(1000);
		while(t.isRunning()) {
			Thread.sleep(500);
		}
		System.out.println("yeah");
	}
}
