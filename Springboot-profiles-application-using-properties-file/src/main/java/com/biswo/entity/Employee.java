package com.biswo.entity;

import lombok.Data;

//Data Transfer Class
//@Data Annotation is used to import the all method of a simple java class
@Data
public class Employee {
	private Integer eNo;
	private String eName;
	private String job;
	private Float salary;
	private Integer deptNo;
}
