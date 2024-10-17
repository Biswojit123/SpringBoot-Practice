package com.biswo.dao.inter;

import java.util.List;

import com.biswo.entity.Employee;

//For achieve the loose coupling
public interface IMEmployeeDao {
	
	//take a method
	public List<Employee> getEmployeesByDesignation(String desg1,String desg2,String desg3);
}
