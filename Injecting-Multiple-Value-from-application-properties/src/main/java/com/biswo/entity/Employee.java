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
	//simple properties
	private Integer empId;
	private String empName;
	//Array properties
	private String [] favColors;
	//Collection type
	private List<String> nickNames;
	private Set<Integer> mobileNums;
	private Map<String,Object> idDetails;
	//Has-A-Property
	private Company company;
}
