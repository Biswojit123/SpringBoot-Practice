package com.biswo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.biswo.entity.Employee;

@SpringBootApplication
public class InjectingVerityTypeValueFromYmlFileApplication {

	public static void main(String[] args) {
		//Get the IOC container
		ApplicationContext container = SpringApplication.run(InjectingVerityTypeValueFromYmlFileApplication.class, args);
		
		//get the employee object
		Employee emp = container.getBean("emp",Employee.class);
		System.out.println(emp);
	}

}
