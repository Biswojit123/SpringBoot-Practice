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
//			Actors actor = service.searchActorById(102);
//			System.out.println("102 Actors detalis:"+actor.getClass());
//			System.out.println("102 Actors detalis:"+actor.getActorId());
//			System.out.println("102 Actors details:"+actor.getActorName());
//			System.out.println("102 Actors details:"+actor.getMobileNum());
			Actors actor = new Actors("Anuska","Heroine",7077018081l);
			List<Actors> actors = service.searchActorsByActor(actor, true,"actorCategory","actorName");
			actors.forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
