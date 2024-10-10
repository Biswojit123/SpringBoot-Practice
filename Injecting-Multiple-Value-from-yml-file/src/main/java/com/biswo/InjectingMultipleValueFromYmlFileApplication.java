package com.biswo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.biswo.entity.Customer;

@SpringBootApplication
public class InjectingMultipleValueFromYmlFileApplication {

	public static void main(String[] args) {
		//Create the IOC Container
		ApplicationContext container = SpringApplication.run(InjectingMultipleValueFromYmlFileApplication.class, args);
		//Get the Customer object from the IOC container
		Customer cust = container.getBean("cust",Customer.class);
		//print the customer
		System.out.println(cust);
	}

}
