package com.biswo.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties("com.biswo")
public class Employee {
	//Simple properties
	private Integer empId;
	//
	private String empName;
	//provide the array properties
	private String []favColors;
	//List collection properties
	private List<String> nickNames;
	//List set integer
	private Set<Integer> mobileNo;
	private Map<String,Object> idDetails;
	//Hash-A mapping
	private Company company;
	
}
