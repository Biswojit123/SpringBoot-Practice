package com.biswo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.view.ResultView;
import com.biswo.view.ResultView1;
import com.biswo.view.ResultView2;
import com.biswo.service.ImpleServiceRepo;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ImpleServiceRepo service;

	@Override
	public void run(String... args) throws Exception {
		try {
			//I want the only id and their name according to the category
			List<ResultView> resultView = service.getByActorCategoryContainingIgnoreCase("Hero",ResultView.class);
			resultView.forEach(view -> System.out.println("Name is"+view.getActorName()+", Actor id:"+view.getActorId()));
			System.out.println("------------------------------------------------------------------------------------------");
			//I want to select only the their category and mobile number according to the category
			List<ResultView1> resultView1 = service.getByActorCategoryContainingIgnoreCase("Hero", ResultView1.class);
			resultView1.forEach(view -> System.out.println("Category:"+view.getActorCategory()+", Mobile:"+view.getMobileNum()));
			System.out.println("-------------------------------------------------------------------------------------------");
			//I want to the select the Id, name and mobile number 
			List<ResultView2> resultView2 = service.getByActorCategoryContainingIgnoreCase("Heroine", ResultView2.class);
			resultView2.forEach(view -> System.out.println("Name:"+view.getActorName()+", Id:"+view.getActorId()+", Mobile Number:"+view.getMobileNum()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
