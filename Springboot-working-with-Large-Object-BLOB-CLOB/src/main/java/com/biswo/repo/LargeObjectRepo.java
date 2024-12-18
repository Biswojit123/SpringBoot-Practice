package com.biswo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.PersonInfo;

public interface LargeObjectRepo extends JpaRepository<PersonInfo, Integer> {

}
