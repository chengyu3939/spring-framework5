package com.mark.spring.context.threadPool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		//构建一个线程池
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(1);
		threadPoolTaskExecutor.setMaxPoolSize(5);
		threadPoolTaskExecutor.setQueueCapacity(1000);
		threadPoolTaskExecutor.setRejectedExecutionHandler((r, executor) -> {
			System.out.println("log discard this event! by full!");
		});
		threadPoolTaskExecutor.setKeepAliveSeconds(5);
		threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
		threadPoolTaskExecutor.initialize();

		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("xxxxx");
			}
		});
		Thread.sleep(10000);

		System.out.println("threadPoolTaskExecutor.getActiveCount() = " + threadPoolTaskExecutor.getActiveCount());
		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("xxxxx3");
			}
		});
		System.out.println("threadPoolTaskExecutor.getActiveCount() = " + threadPoolTaskExecutor.getActiveCount());

	}
}
