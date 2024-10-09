package com.biswo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.biswo.entity.Employee;

@SpringBootApplication
public class InjectingMultipleValueFromApplicationPropertiesApplication {

	public static void main(String[] args) {
		// Create the IOC container
		ApplicationContext container = SpringApplication
				.run(InjectingMultipleValueFromApplicationPropertiesApplication.class, args);
		//Get the Employee object
		Employee employees = container.getBean("emp",Employee.class);
		System.out.println(employees);
	}

}
