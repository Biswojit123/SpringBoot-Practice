package com.biswo.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.biswo.dao.inter.IMEmployeeDao;
import com.biswo.entity.Employee;

@Repository
//If we not specify the any profile then by default the This class object will created
//So we have to declare the "Default" in profile level
@Profile({"dev","test","default"})
public class MySqlImpEmployeeDao implements IMEmployeeDao {
	// Auto wired the DataSources object it contain the all database information
	// using that we can get the connection object
	@Autowired
	private DataSource dataSource;
	// Private means no any one access,final means that value not be changed by
	// other static means we can access that value in static area of that class
	private static final String GET_EMP_DESIG = "SELECT emp_id, emp_name, job, emp_sal, dept_no FROM employee WHERE job IN (?,?,?) ORDER BY job";

	@Override
	public List<Employee> getEmployeesByDesignation(String desg1, String desg2, String desg3) {
		System.out.println("Data-source object in used in MySqlImpEmployeeDao:"+dataSource.getClass());
		//Create the list
		List<Employee> list = null;
		// This is the Try with resources
		try (Connection con = dataSource.getConnection();
				// Here pass the sql query
				PreparedStatement pst = con.prepareStatement(GET_EMP_DESIG);) {
			
			//SET the all designation to the Prepared Statement
			pst.setString(1, desg1);
			pst.setString(2, desg2);
			pst.setString(3, desg3);
			
			//nested try with resource block
			try(ResultSet rs = pst.executeQuery();) {
				
				//get the all record from the result set object
				list = new ArrayList<Employee>();
				while(rs.next()) {
					//Employee object create for Data transfer
					Employee emp = new Employee();
					emp.setENo(rs.getInt(1));
					emp.setEName(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getFloat(4));
					emp.setDeptNo(rs.getInt(5));
					
					//add to the list one record
					list.add(emp);
				}//End of while loop
				
			}catch(SQLException s) {
				s.printStackTrace();
			}//end of try catch block

		} catch (SQLException e) {
			e.printStackTrace();
		}//end of try
		return list;//return statement
	}//end of method

}//end of class
