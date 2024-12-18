package com.biswo.service;

import java.util.List;

import com.biswo.entity.Employee;

public interface CollectionMappingServiceInter {
	public String registerEmployeeInfo(Employee employee);
	public List<Employee> fetchAllEmployeeInfo();
}
