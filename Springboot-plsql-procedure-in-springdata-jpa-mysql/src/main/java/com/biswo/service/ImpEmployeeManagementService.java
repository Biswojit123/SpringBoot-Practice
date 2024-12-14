package com.biswo.service;

import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Employee;

import jakarta.persistence.EntityManager;

@Service
public class ImpEmployeeManagementService implements InEmployeManagementService {

	// Auto-wired the EntityManagement object
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> fetchEmployeeByJob(String role1, String role2) {
		// get the session object
		Session session = entityManager.unwrap(Session.class);
		// use the callback interface that get the connection object to write the jdbc
		// logic to call the plsql function
		session.doWork(con -> {
			//Create the CallableStatement object
			CallableStatement statement = con.prepareCall("?=call F_GET_EMPLOYEE_BY_DEPTNO(?,?)");
			//Create the 
			
		});
		return null;
	}

}
