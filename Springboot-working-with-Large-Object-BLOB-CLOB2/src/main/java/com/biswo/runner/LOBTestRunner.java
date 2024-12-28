package com.biswo.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.Pushpa;
import com.biswo.service.LOBPushpaReleaseServiceInter;
@Component
public class LOBTestRunner implements CommandLineRunner {
	@Autowired
	private LOBPushpaReleaseServiceInter service;
	@Override
	public void run(String... args) throws Exception {
		try(Scanner sc = new Scanner(System.in)) {
			//Create the PUSHPA Object
			Pushpa pushpa = new Pushpa();
			//Get the hero name
			System.out.println("Enter the Pushpa film Hero name:");
			String hero = sc.next();
			sc.nextLine();
			//Get the heroine 
			System.out.println("Enter the Pushpa Heroine name:");
			String heroine = sc.next();
			System.out.println("Enter the Pushpa film release date(yyyy-MM-ddThh:mm:ss):");
			String dateRelease = sc.next();
			System.out.println("Provide the pushpa trailer video:");
			String videoPath = sc.next();
			sc.nextLine();
			System.out.println("Provide the Pushpa film related Document file:");
			String docPath = sc.next();
			//Convert the String to Date type
			LocalDateTime releaseDate = LocalDateTime.parse(dateRelease);
			//Get the file
			File file = new File(videoPath);
			FileInputStream fis = new FileInputStream(file);
			byte[] videoContent = new byte[(int) file.length()];
			fis.read(videoContent);
			//Get the file
			File file1 = new File(docPath);
			FileReader fr = new FileReader(file1);
			char[] docContent = new char[(int) file1.length()];
			fr.read(docContent);
			//set the value to the PUSHPA film
			pushpa.setHeroName(hero);
			pushpa.setHeroineName(heroine);
			pushpa.setReleaseDate(releaseDate);
			pushpa.setFilmTrailer(videoContent);
			pushpa.setFilmDocument(docContent);
			//call the service register method
			String message = service.registerFilmTrailer(pushpa);
			System.out.println(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
