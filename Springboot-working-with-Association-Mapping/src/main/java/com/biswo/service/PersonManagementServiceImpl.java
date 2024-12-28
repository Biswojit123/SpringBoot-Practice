package com.biswo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Person34;
import com.biswo.entity.PhoneNumbers;
import com.biswo.repo.MobileNumberRepo;
import com.biswo.repo.Person34Repo;

@Service
public class PersonManagementServiceImpl implements PersonMangementServiceInter {
	
	@Autowired
	private MobileNumberRepo repo1;
	@Autowired
	private Person34Repo repo2;
	
	public PersonManagementServiceImpl() {
		super();
		System.out.println("PersonManagementServiceImpl object created....");
	}

	@Override
	public String saveDataUsingPerson(Person34 person) {
		return repo2.save(person).getAdharId()+" adharId person record stored successfully....";
	}

	@Override
	public String saveDataUsingPhoneNumbers(Set<PhoneNumbers> phones) {
		int count = repo1.saveAll(phones).size();
		return count+" no. of phone number object mapped to Person object save";
	}

}
