package com.biswo.service.inter;

import java.util.List;

import com.biswo.entity.Employee;

//Employee Services
public interface IEmployeeService {
	//Service logics
	public List<Employee> fetchEmployeeDetails(String desg1,String desg2,String desg3);
}
