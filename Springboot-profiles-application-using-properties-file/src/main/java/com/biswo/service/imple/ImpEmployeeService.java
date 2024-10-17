package com.biswo.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.dao.inter.IMEmployeeDao;
import com.biswo.entity.Employee;
import com.biswo.service.inter.IEmployeeService;
@Service
public class ImpEmployeeService implements IEmployeeService {
	//Auto-wired the Dao layer
	@Autowired
	private IMEmployeeDao impEmployeeDao;
	
	public ImpEmployeeService() {
		System.out.println("ImpEmployeeService 0-param constructor");
	}

	@Override
	public List<Employee> fetchEmployeeDetails(String desg1, String desg2, String desg3){
		//call the Dao-Implementation method
		List<Employee> emp = impEmployeeDao.getEmployeesByDesignation(desg1, desg2, desg3);
		return emp;
	}

}
