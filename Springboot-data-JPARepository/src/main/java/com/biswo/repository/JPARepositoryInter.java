package com.biswo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.Actors;

public interface JPARepositoryInter extends JpaRepository<Actors, Integer> {

}
