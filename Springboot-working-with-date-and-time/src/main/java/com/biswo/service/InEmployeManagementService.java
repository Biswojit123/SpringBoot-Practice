package com.biswo.service;

import java.util.List;

import com.biswo.entity.Person;

public interface InEmployeManagementService {
	public String registerPerson(Person person);
	public List<Person> fetchAllPerson();
}
