package com.biswo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.Person;

public interface RepoInterface extends JpaRepository<Person,Integer> {

}
