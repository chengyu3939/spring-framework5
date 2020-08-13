package com.mark.spring.context.bean;

import com.mark.spring.context.Student2Service;
import com.mark.spring.context.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {


	@Bean("student1")
	public StudentService init1(){
		return new StudentService(2);
	}

	@Bean
	public Student2Service init2(StudentService studentService){
		System.out.println("----------"+studentService.getCount());
		return new Student2Service();
	}
}
