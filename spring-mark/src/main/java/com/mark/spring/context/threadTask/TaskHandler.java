package com.mark.spring.context.threadTask;

import org.springframework.stereotype.Component;

@Component
public class TaskHandler {



	public ITask getTask() {
		return new DownloadTask();
	}
}
