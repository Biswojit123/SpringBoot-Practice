package com.biswo.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.Person;
import com.biswo.service.InEmployeManagementService;

@Component
public class TestRunner implements CommandLineRunner {
	@Autowired
	private InEmployeManagementService service;
	@Override
	public void run(String... args) throws Exception {
		
		//Create the Person object 
		Person person = new Person();
		person.setName("Biswojit Jena");
		person.setAddress("Tichhini");
		person.setDob(LocalDate.of(2002, 1, 24));
		person.setTob(LocalTime.of(2, 20, 35));
		person.setDoj(LocalDateTime.of(LocalDate.of(2024, 9, 15), LocalTime.of(9, 30, 30)));
		//Save the object
		String message = service.registerPerson(person);
		System.out.println(message);

	}

}
