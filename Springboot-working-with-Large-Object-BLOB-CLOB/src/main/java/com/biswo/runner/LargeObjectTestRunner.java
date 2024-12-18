package com.biswo.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.PersonInfo;
import com.biswo.service.PersonInformationServiceIn;

@Component
public class LargeObjectTestRunner implements CommandLineRunner {
	
	@Autowired
	private PersonInformationServiceIn personInfomation;
	
	@Override
	public void run(String... args) throws Exception {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Person name:");
			String name = sc.next();
			System.out.println("Enter the Date of birth:(yyyy-MM-ddThh:mm:ss)");
			String dob = sc.next();
			System.out.println("Is person married:");
			boolean isMarried = sc.nextBoolean();
			System.out.println("Enter the Photo file path:");
			String photoPath = sc.next().trim();
			System.out.println("Enter the Resume file path:");
			String resumePath = sc.next().trim();
			//Convert the String dob to the LocalDateTime
			LocalDateTime dob1 = LocalDateTime.parse(dob);
			//Add the Photo File path to the database
			File file = new File(photoPath);
			FileInputStream fis = new FileInputStream(file);
			byte[] photoContent = new byte[(int) file.length()];
			fis.read(photoContent);
			//add the Resume file path to the database
			File file1 = new File(resumePath);
			FileReader fr = new FileReader(file1);
			char[] resumeContent = new char[(int) file1.length()];
			fr.read(resumeContent);
			//Create the PersonInfo Object
			PersonInfo personInfo = new PersonInfo();
			personInfo.setPersonName(name);
			personInfo.setDob(dob1);
			personInfo.setMarried(isMarried);
			personInfo.setPhoto(photoContent);
			personInfo.setResume(resumeContent);
			//Register the person information
			String message =personInfomation.registerPersonInfo(personInfo);
			System.out.println(message);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
