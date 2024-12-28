package com.biswo.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.Person34;
import com.biswo.entity.PhoneNumbers;
import com.biswo.service.PersonMangementServiceInter;

@Component
public class TestRunner2 implements ApplicationRunner {

	@Autowired
	private PersonMangementServiceInter service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			// Child to parent save object
			Person34 person = new Person34();
			person.setName("Rasmita Jena");
			person.setAddress("Bhubaneswar");
			// Create the Phone object
			PhoneNumbers number1 = new PhoneNumbers();
			number1.setNumberType("Residence");
			number1.setPhoneNumber(7077043661l);
			number1.setProvider("Airtel");
			PhoneNumbers number2 = new PhoneNumbers();
			number2.setNumberType("Residence");
			number2.setPhoneNumber(3659865314l);
			number2.setProvider("Jio");
			PhoneNumbers number3 = new PhoneNumbers();
			number3.setNumberType("private");
			number3.setPhoneNumber(4564562222l);
			number3.setProvider("Vi");
			
			//Many to one Association mapping
			number1.setPerson(person);
			number2.setPerson(person);
			number3.setPerson(person);
			//set the all number into Set collection
			Set<PhoneNumbers> numbers = Set.of(number1,number2,number3);

			String message = service.saveDataUsingPhoneNumbers(numbers);
			System.out.println(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public TestRunner2() {
		super();
		System.out.println("Test runner class object created successfully..");
	}

}
