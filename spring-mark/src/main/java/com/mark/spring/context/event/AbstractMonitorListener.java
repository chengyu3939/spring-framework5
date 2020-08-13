package com.mark.spring.context.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public abstract class AbstractMonitorListener implements ApplicationListener<MonitorEvent> {

	protected List<MonitorEnums> supportType = new ArrayList<>();

	public AbstractMonitorListener() {
		initSupport();
	}

	protected abstract void initSupport();

	@Override
	public void onApplicationEvent(MonitorEvent event) {
		System.out.println("接收到了时间：" + event.getSource() + "当前执行线程：" + Thread.currentThread().getName());
		if (supportType.contains(event.getMonitorEnums())) {
			callBack(event);
		}
	}

	/**
	 * 回掉业务处理
	 *
	 * @param event 事件。
	 */
	protected abstract void callBack(MonitorEvent event);
}

