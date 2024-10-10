package com.biswo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("cust")
@ConfigurationProperties("com.biswo")
@Data
public class Customer {
	private Integer custNo;
	private String custName;
	private String custAdd;
	private Double billAmt;
}
