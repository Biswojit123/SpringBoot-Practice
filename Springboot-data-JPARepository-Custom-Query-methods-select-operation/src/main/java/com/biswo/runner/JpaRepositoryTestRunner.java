package com.biswo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.service.ImpleServiceRepo;
import com.biswo.view.ViewResult1;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ImpleServiceRepo service;

	@Override
	public void run(String... args) throws Exception {
		try {
			// get the Specific Actors Details
			service.findByActorName("Anuska").forEach(System.out::println);
			// Get the all Actors details
			service.findAllActors().forEach(System.out::println);
			// Specific column i want for given condition'
			service.findActorsByNameAndCategory("Anuska", "Heroine", ViewResult1.class)
					.forEach(viewResult1 -> System.out
							.println("Actor Category:" + viewResult1.getActorCategory() + ", Actor number:"
									+ viewResult1.getMobileNum() + ", proxy class:" + viewResult1.getClass()));
			// Get the all record from the table
			service.findAllActors2("Heroine").forEach(System.out::println);
			// Get the all record by Category
			service.findAllActors3("Hero").forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
