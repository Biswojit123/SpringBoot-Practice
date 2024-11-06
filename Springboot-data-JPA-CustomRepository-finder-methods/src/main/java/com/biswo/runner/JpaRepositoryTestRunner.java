package com.biswo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.Actors;
import com.biswo.service.ImpleServiceRepo;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {
	
	@Autowired
	private ImpleServiceRepo service;
	
	@Override
	public void run(String... args) throws Exception {
		//provide the all Ids to delete the all specified ids records
		//System.out.println(service.removeActorsByIdInBatch(List.of(1,2,336,458,659)));
		
		try {
			//List<Actors> actors = service.getActorByNameEqual("Anuska");
			//actors.forEach(System.out::println);
			//List<Actors> actors = service.getActorByIdBetween(1, 302);
			//Iterable<Actors> actors = service.getActorByCategoryEqualsIgnoreCase("Heroine");
//			Iterable<Actors> actors = service.getActorsByActorNameLike("%A");
//			actors.forEach(System.out::println);
//			service.getActorsByActorNameLike("%S").forEach(System.out::println);
//			service.getActorsByActorNameLike("%S%").forEach(System.out::println);
			service.getActorsByActorNameLike("H").forEach(System.out::println);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
