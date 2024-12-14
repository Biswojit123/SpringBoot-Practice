package com.biswo.service;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
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
	public List<Employee> fetchEmployeeByJob(int role1, int role2) {
		// Create the Session object
		Session session = entityManager.unwrap(Session.class);
		List<Employee> employees = new ArrayList<Employee>();
		// Use the Hibernate callback function to create the connection object and write
		// the jdbc logic to call the plsql function
		session.doWork(con -> {
			//get the CallableStatement object
			CallableStatement statement  = con.prepareCall("{?=call F_GET_EMPLOYEE_BY_DEPT(?,?)}");
			//Register the Return type
			statement.registerOutParameter(1, java.sql.Types.VARCHAR);
			statement.setInt(2, role1);
			statement.setInt(3, role2);
			//Execute the PlSql Function
			statement.execute();
			//get the Json object 
			String getResult = statement.getNString(1);
			JSONArray jsonArray = new JSONArray(getResult);
			for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Employee employee = new Employee(
                    jsonObject.getInt("emp_id"),
                    jsonObject.getString("emp_name"),
                    jsonObject.getString("emp_job"),
                    jsonObject.getDouble("emp_salary"),
                    jsonObject.getInt("dept_no")
                );
                employees.add(employee);
            }
		});
		return employees;
	}

}
