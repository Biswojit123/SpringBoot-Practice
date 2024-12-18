package com.biswo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.service.CollectionMappingServiceInter;
//This Test Class for Read the Information
@Component
public class TestRunnerCollectionMapping2 implements CommandLineRunner {
	@Autowired
	private CollectionMappingServiceInter service;
	@Override
	public void run(String... args) throws Exception {
		try {
			//Read the All Employee Information
			service.fetchAllEmployeeInfo().forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
