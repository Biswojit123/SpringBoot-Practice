package com.biswo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.Actor;

public interface PlSqlInterface extends JpaRepository<Actor, Integer> {
	
}
