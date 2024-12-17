package com.biswo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="person")
@Data
public class Person {
	@Id
	@GeneratedValue
	private Integer adharId;
	@Column(length=35)
	private String name;
	@Column(length=35)
	private String address;
	private LocalDate dob;
	private LocalTime tob;
	private LocalDateTime doj;
}
