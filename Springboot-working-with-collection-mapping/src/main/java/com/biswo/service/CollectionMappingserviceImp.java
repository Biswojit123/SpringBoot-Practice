package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Employee;
import com.biswo.repo.CollectionMappingRepo;

@Service
public class CollectionMappingserviceImp implements CollectionMappingServiceInter {
	@Autowired
	private CollectionMappingRepo repo;
	@Override
	public String registerEmployeeInfo(Employee employee) {
		return "Id number "+repo.save(employee).getEmployeeId()+" employee information saved successfully..";
	}

	@Override
	public List<Employee> fetchAllEmployeeInfo() {
		return repo.findAll();
	}

}
