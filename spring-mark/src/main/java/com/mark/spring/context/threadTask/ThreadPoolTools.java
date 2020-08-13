package com.mark.spring.context.threadTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ThreadPoolTools {

	@Autowired
	TaskHandler taskHandler;

	public void execute() {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

//		executorService.execute(() -> taskHandler.getTask().execute());



		/*
		两种方式

		1。创建一个新的业务实现的实例，该实例集成runnable

		2。new 一个runnable 。获取springbean的实现类。将其作为匿名方法使用传入。
		 */
	}
}
