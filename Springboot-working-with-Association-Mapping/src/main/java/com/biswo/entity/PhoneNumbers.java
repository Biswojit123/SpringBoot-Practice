package com.biswo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Phone_Numbers")
@Getter
@Setter
@ToString
//Association mapping
public class PhoneNumbers {
	@Id
	@GeneratedValue
	private Integer regoNo;
	private Long phoneNumber;
	@Column(length = 20)
	private String numberType;
	@Column(length = 20)
	private String provider;
	//child to parent 
	@ManyToOne(targetEntity = Person34.class, cascade = CascadeType.ALL// When non select operation perform on the child
																		// object it also perform on the associated
																		// object through the cascade
			, fetch = FetchType.LAZY)
	@JoinColumn(name = "personId", referencedColumnName = "adharId")
	private Person34 person;// Multiple phone object pointing to the Single person object And also it is the
							// special property of that Phone class and it is also Has-A property.
	public PhoneNumbers() {
		super();
		System.out.println("Phone Object created Successfully..");
	}
	
}
