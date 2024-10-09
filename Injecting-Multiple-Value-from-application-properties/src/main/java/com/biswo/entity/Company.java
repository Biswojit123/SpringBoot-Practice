package com.biswo.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("company")
@Data
public class Company {
	private Integer companyId;
	private String companyName;
	private String companyAddress;
	private Integer companySize;
}
