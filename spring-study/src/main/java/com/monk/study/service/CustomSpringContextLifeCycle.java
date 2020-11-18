package com.monk.study.service;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringContextLifeCycle implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("spring is start....");
	}

	@Override
	public void stop() {
		System.out.println("spring is stop....");
	}

	@Override
	public boolean isRunning() {
		return false;
	}

	/**
	 * 这个方法的返回必须返回true,当前这个类中的重写的方法才会被执行
	 * @return
	 */
	@Override
	public boolean isAutoStartup() {
		return true;
	}
}
