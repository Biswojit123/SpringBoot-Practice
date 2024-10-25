package com.biswo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;

import com.biswo.entity.Actors;
import com.biswo.service.ImpServiceActors;

@SpringBootApplication
public class SpringbootDataJpaEx01Application {
	@Autowired
	private ImpServiceActors service;
	
	//Runner concept used here
	//@Bean
	public CommandLineRunner createRunner() {
		CommandLineRunner clr = (String ...args) -> {
			try {
				String category = args[1];
				String name = args[2];
				String mobnum = args[3];
				System.out.println("category:"+category+"name:"+name+"mob:"+mobnum);
				Actors actors = new Actors();
				actors.setActorCategory(category);
				actors.setActorName(name);
				actors.setMobileNum(Long.valueOf(mobnum));
				String resultMessage = service.registerActor(actors);
				System.out.println(resultMessage);
			}catch(DataAccessException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		};
		return clr;
	}
	
	//Here also used the runner concept to insert the object
	//@Bean
	public ApplicationRunner createRunner1() {
		ApplicationRunner clr2 = (ApplicationArguments args) -> {
			try {
				String category = args.getOptionValues("value1").get(0);
				String name = args.getOptionValues("value2").get(0);
				String mobnum = args.getOptionValues("value3").get(0);
				System.out.println("category:"+category+"name:"+name+"mob:"+mobnum);
				Actors actors = new Actors();
				actors.setActorId(2);
				actors.setActorCategory(category);
				actors.setActorName(name);
				actors.setMobileNum(Long.valueOf(mobnum));
				String resultMessage = service.registerActor(actors);
				System.out.println(resultMessage);
			}catch(DataAccessException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		};
		return clr2;
	}
	
	//@Bean
	public ApplicationRunner createUpdateRunner() {
		ApplicationRunner clr3 = (ApplicationArguments args) -> {
			int id = Integer.parseInt(args.getOptionValues("value").get(0));
			String resultMesg = service.updateActor(id);
			System.out.println(resultMesg);
		};
		return clr3 ;
	}
	
	@Bean
	public ApplicationRunner createBatchInsert() {
		ApplicationRunner clr4 = (ApplicationArguments args) -> {
			List<Actors> listActors = List.of(new Actors("Ali-Arjun","Hero",253478945l),
											  new Actors("Ram-Charan","Hero",895642756l),
											  new Actors("Tamana Vatiya","Heroine",8261342564l));
			String message = service.registerActorsGroup(listActors);
			System.out.println(message);
		};
		return clr4;
	}
	
	public static void main(String[] args) {
		//IOC container
		SpringApplication.run(SpringbootDataJpaEx01Application.class, args);
		
	}
	

}
