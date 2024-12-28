package com.biswo.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="person")
@Setter
@Getter
@ToString
//Association mapping
public class Person34 implements Serializable {
	@Id
	@SequenceGenerator(name="gen1",initialValue=1000,allocationSize=5,sequenceName="AD_ID_SEQ")
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer adharId;
	@Column(length=35)
	private String name;
	@Column(length=35)
	private String address;
	//parent to child
	@OneToMany(targetEntity=PhoneNumbers.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="person")
	//@JoinColumn(name="personId",referencedColumnName="adharId")
	private Set<PhoneNumbers> phones;
	public Person34() {
		super();
		System.out.println("Person34 object created successfully");
	}
	
}
