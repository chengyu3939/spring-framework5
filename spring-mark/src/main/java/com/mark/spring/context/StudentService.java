package com.mark.spring.context;

import org.springframework.stereotype.Component;

@Component
public class StudentService {
	private Integer count;


	public StudentService() {

		System.out.println("studentservice null args be call!");
	}

	public StudentService(Integer count) {
		System.out.println("studentservice 1 args be call!");

		this.count = count;
	}

	public void say(){
		System.out.println("student say!");
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
