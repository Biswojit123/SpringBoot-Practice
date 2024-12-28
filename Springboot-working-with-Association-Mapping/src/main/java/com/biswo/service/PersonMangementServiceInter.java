package com.biswo.service;

import java.util.Set;

import com.biswo.entity.Person34;
import com.biswo.entity.PhoneNumbers;

public interface PersonMangementServiceInter {
	public String saveDataUsingPerson(Person34 person);
	public String saveDataUsingPhoneNumbers(Set<PhoneNumbers> phones);
}
