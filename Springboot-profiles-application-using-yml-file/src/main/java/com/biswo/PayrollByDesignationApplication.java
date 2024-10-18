package com.biswo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.biswo.controller.EmpController;
import com.biswo.entity.Employee;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//Stand alone presentation layer
@SpringBootApplication
public class PayrollByDesignationApplication {
	//Auto-wired the Environment
	@Autowired
	private Environment env;

    //Create the Combo Pool Data Sources object
    @Bean(name = "combo")
    @Profile({"test"})
    ComboPooledDataSource createC3P0DS() throws Exception {
		System.out.println("Create the C3P0DS Object...");
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//set the all properties to the data sources object
		cpds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cpds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		cpds.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.minsize")));
		cpds.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.maxsize")));
		return cpds;
	}

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(PayrollByDesignationApplication.class, args);
		
		//Get the Controller bean object from container
		EmpController controller = container.getBean(EmpController.class);
		
		//invoke the designation
		try {
			//List<Employee> emps = controller.showsAllEmployeeDetails("Data Analyst","Project Manager","QA Tester");
			List<Employee> emps = controller.showsAllEmployeeDetails("ANALYST","MANAGER","SALEMAN");
			//Stream concept use for get one one employee and print them
			System.out.println("All employee details are given below::");
			System.out.println("=======================================");
			emps.stream().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//close the container
		((ConfigurableApplicationContext) container).close();
	}

}
