package com.biswo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.biswo.entity.Employee;
import com.biswo.service.imple.ImpEmployeeService;

@Controller
public class EmpController {
	//Auto-wired the Service layer
	@Autowired
	private ImpEmployeeService employeeService;
	public EmpController() {
		System.out.println("EmpController 0-param constructor");
	}
	//call the employee service method
	public List<Employee> showsAllEmployeeDetails(String desg1,String desg2,String desg3)throws Exception {
		//call the service method
		List<Employee> list = employeeService.fetchEmployeeDetails(desg1, desg2, desg3);
		return list;
	}
}