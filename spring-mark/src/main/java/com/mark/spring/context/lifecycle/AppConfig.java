package com.mark.spring.context.lifecycle;

import com.mark.spring.context.StudentService;
import com.mark.spring.context.bean.DemoConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.ErrorHandler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@ComponentScan(basePackages = "com.mark.spring.context")
@EnableAsync
@Import(DemoConfig.class)
public class AppConfig implements ApplicationContextAware {
	ApplicationContext applicationContext;

	//给系统初始化一个线程池

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

		taskExecutor.initialize();
		//不做参数处理
		return taskExecutor;
	}


	@Bean("applicationEventMulticaster")
	public ApplicationEventMulticaster initMulticaster() {
		SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster(applicationContext);

		//构建一个线程池
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(1);
		threadPoolTaskExecutor.setMaxPoolSize(5);
		threadPoolTaskExecutor.setQueueCapacity(1000);
		threadPoolTaskExecutor.setRejectedExecutionHandler((r, executor) -> {
			System.out.println("log discard this event! by full!");
		});
		threadPoolTaskExecutor.setKeepAliveSeconds(10);
		threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
		threadPoolTaskExecutor.initialize();
		multicaster.setTaskExecutor(threadPoolTaskExecutor);


		multicaster.setErrorHandler(t -> System.out.println("日志打印！！！"+t.getMessage()));
		return multicaster;

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
