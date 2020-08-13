package com.mark.spring.context.lifecycle;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class  LifecycleDemo implements SmartLifecycle {


	public void test(){

	}
	@Override
	public void start() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>start");
	}

	@Override
	public void stop() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>stop");

	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
