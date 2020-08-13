package com.mark.spring.context.event.listener;

import com.mark.spring.context.event.AbstractMonitorListener;
import com.mark.spring.context.event.MonitorEnums;
import com.mark.spring.context.event.MonitorEvent;
import org.springframework.stereotype.Component;

@Component
public class FeatureCodeLoadingErrorMonitor extends AbstractMonitorListener {


	@Override
	protected void initSupport() {
		supportType.add(MonitorEnums.POOL_FAIL);
		supportType.add(MonitorEnums.THREAD_POOL_FAIL);
	}

	@Override
	protected void callBack(MonitorEvent event) {
		System.out.println("FeatureCodeLoadingErrorMonitor:event.toString() = " + event.toString());
	}
}
