package com.biswo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue
	private Integer emp_id;
	@Column(length=45)
	private String emp_name;
	@Column(length=45)
	private String job;
	private Double emp_sal;
	private Integer dept_no;
}
