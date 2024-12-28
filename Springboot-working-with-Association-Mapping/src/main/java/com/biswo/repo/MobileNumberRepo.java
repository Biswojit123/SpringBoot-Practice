package com.biswo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.PhoneNumbers;

public interface MobileNumberRepo extends JpaRepository<PhoneNumbers, Integer> {

}
