package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biswo.entity.Person;
import com.biswo.repo.RepoInterface;

@Service
public class ImpEmployeeManagementService implements InEmployeManagementService {
	@Autowired
	private RepoInterface repo;
	
	@Override
	//@Transactional
	public String registerPerson(Person person) {
		Person p = repo.save(person);
		System.out.println(p);
		return p.getAdharId()+" saved successfully";
	}

	@Override
	//@Transactional(readOnly=true)
	public List<Person> fetchAllPerson() {
		return repo.findAll();
	}

}
