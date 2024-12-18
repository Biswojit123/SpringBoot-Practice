package com.biswo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.PersonInfo;
import com.biswo.repo.LargeObjectRepo;

@Service
public class PersonInformationImp implements PersonInformationServiceIn {
	
	@Autowired
	private LargeObjectRepo repo;
	@Override
	public String registerPersonInfo(PersonInfo personInfo) {
		return repo.save(personInfo).getPersonId()+" id personInformation saved successfully.....";
	}


}
