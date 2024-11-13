package com.biswo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.ResultView;
import com.biswo.service.ImpleServiceRepo;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ImpleServiceRepo service;

	@Override
	public void run(String... args) throws Exception {
		try {
			// Provide the Actors Category and we want only the Actors id and their name
			service.getByActorCategoryEqualsIgnoreCase("Heroine")
					.forEach(resultView -> System.out.println("Actors id:" + resultView.getActorId() + ", Aactor Name:"
							+ resultView.getActorName() + ", Class Imp:" + resultView.getClass()));
			System.out.println(
					"------------------------------------------------------------------------------------------");
			// Provide the Actor Mobile number and get the Actor id and their name(Here it
			// store only unique return actor not for multiple)
			ResultView resultView = service.getByMobileNumber(8260293404l);
			System.out.println("Actors id:" + resultView.getActorId() + ", Aactor Name:" + resultView.getActorName()
					+ ", Class Imp:" + resultView.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
