package com.mark.spring.context.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher implements ApplicationContextAware {

	//获取并注入spring的bean
	private static ApplicationContext applicationContext;


	public static void publisher(MonitorEnums enums, String msg) {
		applicationContext.publishEvent(new MonitorEvent(enums, msg));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		EventPublisher.applicationContext = applicationContext;
	}
}
