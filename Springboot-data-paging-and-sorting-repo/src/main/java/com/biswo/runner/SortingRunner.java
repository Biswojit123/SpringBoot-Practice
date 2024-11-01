package com.biswo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.biswo.entity.Actors;
import com.biswo.service.ImpServiceActors;

@Component
public class SortingRunner implements ApplicationRunner {

	@Autowired
	private ImpServiceActors service;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// Pass the properties to the service layer
		System.out.println("--------------Find the all Record in sorting order according to the ActorId-----------");
		service.getAllActorsBySorting(true, "actorId").forEach(System.out::println);
		System.out.println("--------------Find the all Record in sorting order according to the ActorId And Name-----------");
		service.getAllActorsBySorting(false, "actorId","actorName").forEach(System.out::println);
		System.out.println("--------------Find the Specific page record--------------------------------------------");
		Page<Actors> page = service.showPageRecord(2, 3);
		List<Actors> actors = page.getContent();
		actors.forEach(System.out::println);
		System.out.println("--------------Print the all pages and Their records and extra information----------------");
		service.showActorsByPages(3);
	}

}
