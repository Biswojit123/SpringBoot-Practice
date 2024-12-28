package com.biswo.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.Person34;
import com.biswo.entity.PhoneNumbers;
import com.biswo.service.PersonMangementServiceInter;

//@Component
public class TestRunner implements ApplicationRunner {
	@Autowired
	private PersonMangementServiceInter service;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			//Parent to child save object
			Person34 person = new Person34();
			person.setName("Biswojit Jena"); person.setAddress("Hyderbad");
			//Create the Phone object
			PhoneNumbers number1 = new PhoneNumbers();
			number1.setNumberType("Residence"); number1.setPhoneNumber(7077018081l); number1.setProvider("Airtel");
			PhoneNumbers number2 = new PhoneNumbers();
			number2.setNumberType("Residence"); number2.setPhoneNumber(8260293404l); number2.setProvider("Jio");
			PhoneNumbers number3 = new PhoneNumbers();
			number3.setNumberType("private"); number3.setPhoneNumber(9348572442l); number3.setProvider("Vi");
			
			//Create a Set object
			Set<PhoneNumbers> numbers = Set.of(number1,number2,number3);
			//set the Number 
			person.setPhones(numbers);
			//Save object
			String message = service.saveDataUsingPerson(person);
			System.out.println(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public TestRunner() {
		super();
		System.out.println("Test runner class object created successfully..");
	}

}
