package com.biswo.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.Employee;
import com.biswo.service.CollectionMappingServiceInter;
//This test Class is to insert the record
//@Component
public class TestRunnerCollectionMapping implements CommandLineRunner {
	@Autowired
	private CollectionMappingServiceInter service;
	@Override
	public void run(String... args) throws Exception {
		try {
			//Create the Employee Object
			Employee emp = new Employee();
			//Set the Employee Name
			emp.setEmployeeName("Jagan Palei");
			//Set the Employee Friends
			emp.setFriends(List.of("Susa","Manas","Biswojit","Ajit"));
			//Set the Alternative Mobile Numbers of Employee
			emp.setPhonesNumber(Set.of(12564556454l,8260293405l,896534245l));
			//Set the Employee All ID's
			emp.setIdDetails(Map.of("Adhar",7662574785l,"PAN",568123563l,"Voter",25644847863l));
			//save the Object
			String message = service.registerEmployeeInfo(emp);
			//Print the Success Message
			System.out.println(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
