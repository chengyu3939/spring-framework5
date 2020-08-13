package com.mark.spring.context.threadPool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadDeaomTest {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("自线程执行中---");
					Thread.sleep(10000);
					System.out.println("自线程执行完毕---");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		System.out.println("主线程结束");
	}
}
