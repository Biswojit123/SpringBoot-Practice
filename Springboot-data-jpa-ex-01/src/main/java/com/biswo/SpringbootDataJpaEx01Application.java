package com.biswo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	// Runner concept used here
	// @Bean
	public CommandLineRunner createRunner() {
		CommandLineRunner clr = (String... args) -> {
			try {
				String category = args[1];
				String name = args[2];
				String mobnum = args[3];
				System.out.println("category:" + category + "name:" + name + "mob:" + mobnum);
				Actors actors = new Actors();
				actors.setActorCategory(category);
				actors.setActorName(name);
				actors.setMobileNum(Long.valueOf(mobnum));
				String resultMessage = service.registerActor(actors);
				System.out.println(resultMessage);
			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		return clr;
	}

	// Here also used the runner concept to insert the object
	// @Bean
	public ApplicationRunner createRunner1() {
		ApplicationRunner clr2 = (ApplicationArguments args) -> {
			try {
				String category = args.getOptionValues("value1").get(0);
				String name = args.getOptionValues("value2").get(0);
				String mobnum = args.getOptionValues("value3").get(0);
				System.out.println("category:" + category + "name:" + name + "mob:" + mobnum);
				Actors actors = new Actors();
				actors.setActorId(2);
				actors.setActorCategory(category);
				actors.setActorName(name);
				actors.setMobileNum(Long.valueOf(mobnum));
				String resultMessage = service.registerActor(actors);
				System.out.println(resultMessage);
			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		return clr2;
	}

	// @Bean
	public ApplicationRunner createUpdateRunner() {
		ApplicationRunner clr3 = (ApplicationArguments args) -> {
			int id = Integer.parseInt(args.getOptionValues("value").get(0));
			String resultMesg = service.updateActor(id);
			System.out.println(resultMesg);
		};
		return clr3;
	}

	// @Bean
	public ApplicationRunner createBatchInsert() {
		ApplicationRunner clr4 = (ApplicationArguments args) -> {
			List<Actors> listActors = List.of(new Actors("Ali-Arjun", "Hero", 253478945l),
					new Actors("Ram-Charan", "Hero", 895642756l), new Actors("Tamana Vatiya", "Heroine", 8261342564l));
			String message = service.registerActorsGroup(listActors);
			System.out.println(message);
		};
		return clr4;
	}

	// How many number of record in Database
	// @Bean
	public ApplicationRunner countNumberOfRecord() {
		ApplicationRunner clr5 = (ApplicationArguments args) -> {
			Long numberOfRecord = service.countNumOfRecord();
			System.out.println(numberOfRecord + " number of record available in database..");
		};
		return clr5;
	}

	// Fetch the all details of all actors
	//@Bean
	public ApplicationRunner fetchAllActorsDetails() {
		ApplicationRunner clr6 = (ApplicationArguments args) -> {
			System.out.println("-----------------------------------" + "---------------------------------------------"
					+ "-----------------------------------------------"
					+ "---------------------------------------------------------------------");
			Iterable<Actors> allRecords = service.fetchAllActors();
			allRecords.forEach(System.out::println);
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			// print the value using the stream API concept
			// Type cast to the List object
			List<Actors> actors = (List<Actors>) allRecords;
			// Process the all actors
			actors.stream().forEach(System.out::println);
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			// Count number record in the list
			System.out.println("Number of record present in the list is:" + actors.stream().count());
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			// Sort the all record according to the id value
			actors.stream().sorted(Comparator.comparing(actor -> actor.getActorId())).forEach(System.out::println);
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			// Sorted according to the name in default natural sorting order
			actors.stream().sorted((actor1, actor2) -> actor1.getActorName().compareTo(actor2.getActorName()))
					.forEach(System.out::println);
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			// Custom natural sorting order
			actors.stream().sorted((a1, a2) -> a2.getActorName().compareTo(a1.getActorName()))
					.map(actor -> actor.getActorName()).forEach(System.out::println);
			// Get the information those are hero actors
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			actors.stream().filter(actor -> actor.getActorCategory().equalsIgnoreCase("hero"))
					.collect(Collectors.toList()).forEach(System.out::println);
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			actors.stream().filter(actor -> actor.getUpdationCount() == 1).collect(Collectors.toList())
					.forEach(System.out::println);
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			actors.stream().filter(actor -> actor.getActorCategory().equalsIgnoreCase("heroine"))
					.map(actor -> actor.getActorName()+"--->"+actor.getActorCategory())
					.collect(Collectors.toList()).forEach(System.out::println);
			System.out.println("------------------------------" + "---------------------------------------------------"
							+ "-----------------------------------------------------"
							+ "----------------------------------------------------------");
			boolean isExits = service.isIdExist(Integer.parseInt(args.getOptionValues("value1").get(0)));
			System.out.println("Is ID Exits:"+isExits);
		};
		return clr6;
	}
	
	//@Bean 
	public ApplicationRunner getRunner() {
		ApplicationRunner clr7 = (ApplicationArguments args)-> {
			Iterable<Actors> actors = service.fetchActorsById(List.of(1,2,302,202,352));
			actors.forEach(System.out::println);
			System.out.println("------------------------------" + "Get actor By id()-----------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			Optional<Actors> actor = service.fetchActorById(2);
			if(actor.isPresent()) {
				System.out.println(actor.get());
			}else {
				System.out.println("Actor is not present");
			}
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			Optional<Actors> actor1 = service.fetchActorById(2);
			Actors actor2 = actor1.orElseThrow(()-> new IllegalArgumentException("Record not found"));
			System.out.println(actor2);
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			Optional<Actors> actor3 = service.fetchActorById(1);
			Actors actor4 = actor3.orElse(new Actors());
			System.out.println(actor4);
			System.out.println("------------------------------" + "---------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "----------------------------------------------------------");
			Actors actor03 = service.fetchsActorById(1);
			System.out.println(actor03);
			
		};
		return clr7;
	}
	//Update Operation perform i.e partial update
	//@Bean
	public ApplicationRunner getRunner1() {
		ApplicationRunner clr7 = (ApplicationArguments args)-> {
			String mesg = service.updateActorMobileNo(102, 82602934l);
			System.out.println(mesg);
		};
		return clr7;
	}
	//Fully Update 
	//@Bean
	public ApplicationRunner getRunner2() {
		ApplicationRunner clr7 = (ApplicationArguments args)-> {
			Actors actor = new Actors("Anuska","Heroine",7077018081l);
			actor.setActorId(102);
			String mesg = service.updateActor(actor);
			System.out.println(mesg);
		};
		return clr7;
	}
	//if Actor exist simple update other wise insert
	//@Bean
	public ApplicationRunner getRunner3() {
		ApplicationRunner clr7 = (ApplicationArguments args)-> {
			Actors actor = new Actors("Sarukhan","Hero",925635895l);
			actor.setActorId(111);
			String mesg = service.UpdateOrInsertIfExist(actor);
			System.out.println(mesg);
		};
		return clr7;
	}
	//We want to delete the object
	//@Bean
	public ApplicationRunner getRunner4() {
		ApplicationRunner clr8 = (ApplicationArguments args) -> {
			String delMsg = service.deleteActorById(252);
			System.out.println(delMsg);
		};
		return clr8;
	}
	//@Bean
	public ApplicationRunner getRunner5() {
		ApplicationRunner clr8 = (ApplicationArguments args) -> {
			//create the Actors object
			Actors actor = new Actors();
			actor.setActorId(202);
			String delMsg = service.deleteActor(actor);
			System.out.println(delMsg);
		};
		return clr8;
	}
	//@Bean
	public ApplicationRunner getRunner6() {
		ApplicationRunner clr8 = (ApplicationArguments args) -> {
			String delMsg = service.removeActorById(152);
			System.out.println(delMsg);
		};
		return clr8;
	}
	@Bean
	public ApplicationRunner getRunner7() {
		ApplicationRunner clr8 = (ApplicationArguments args) -> {
			String delMsg = service.removeAllActors(List.of(352,353,52));
			System.out.println(delMsg);
		};
		return clr8;
	}
	public static void main(String[] args) {
		// IOC container
		SpringApplication.run(SpringbootDataJpaEx01Application.class, args);
	}

}
