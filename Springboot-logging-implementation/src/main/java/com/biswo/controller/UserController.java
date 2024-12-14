package com.biswo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
	// Here we specify the logger class
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	// Create welcome method
	@GetMapping("/welcome")
	public String welcomMsg() {
		// to print the logger message of this method in console logger class provided
		// the Different level of method
		logger.info("Welcome() method execution started.....");
		logger.warn("Waring is zero divided by 20..........");
		String welcome = "Welcome to India.......";
		try {
			int num = 20/10;
		}catch(Exception e) {
			logger.error("Arithmetic Exception occure:"+e.getMessage());
		}
		logger.info("Welcome() method execution ended.........");
		return welcome;
	}

	// Create the Greeting method
	@GetMapping("/greeting")
	public String greetingMsg() {
		logger.info("greeting() method execution started........");
		logger.warn("Waring is we can't perfrom the any operation on null value........");
		String greeting = null;
		try {
			String  str = "Biswojit";
			int length = str.length();
			greeting = "Good morning"+str;
			System.out.println(length);
		}catch(Exception e) {
			logger.error("We can't perform any operation with null value:"+e.getMessage());
		}
		logger.info("Greeting() method execution ended...........");
		return greeting;
	}

}
