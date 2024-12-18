package com.biswo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.Employee;

public interface CollectionMappingRepo extends JpaRepository<Employee, Integer> {

}
