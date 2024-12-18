package com.biswo.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Employee_Info")
@Data
public class Employee {
	@Id
	@GeneratedValue
	private Integer employeeId;
	@Column(length = 30)
	private String employeeName;
	@ElementCollection // enable the Collection mapping it's means it take the all value from the
						// collection property value and store into the child table as a column value
	@CollectionTable(name = "Emp_Friends_Info", // It create the child table in the data base
			joinColumns = @JoinColumn(name = "emp_Id", referencedColumnName = "employeeId")/*
																							 * Here specify the Join
																							 * columns name that refer
																							 * to the parent database PK
																							 * column
																							 */ )
	@Column(name = "firends_name", length = 30) // specify the column name for storing the friends name
	@OrderColumn(name = "numberOfFriends") // specify the index
	@ListIndexBase(1) // specify the base index
	private List<String> friends;
	@ElementCollection // Enable the Collection mapping it take the all value from the collection
						// property and store in to the child table as column value
	@CollectionTable(name = "Emp_Phone_Info",
			joinColumns = @JoinColumn(name = "emp_Id", referencedColumnName = "employeeId"))
	@Column(name="emp_numbers")//to store the Number of phones number
	private Set<Long> phonesNumber;
	@ElementCollection
	@CollectionTable(name="Emp_IdDetails_Info", joinColumns=@JoinColumn(name="emp_Id",referencedColumnName="employeeId"))
	@Column(name="id_number")//to store the map element values
	@MapKeyColumn(name="id_type",length=30)//to store the map key
	private Map<String,Long> idDetails;

}
