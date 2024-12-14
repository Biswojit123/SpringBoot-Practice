package com.biswo.service;

import java.util.List;

import com.biswo.entity.Employee;

public interface InEmployeManagementService {
	public List<Employee> fetchEmployeeByJob(String role1,String role2);
}
