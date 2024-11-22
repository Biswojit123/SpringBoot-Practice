package com.biswo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biswo.entity.Actors;
import com.biswo.view.View;

public interface JPARepositoryInter extends JpaRepository<Actors, Integer> {
	//write the custom query for getting the 
	@Query("From Actors where actorName=?1")
	public Iterable<Actors> findByActorName(String actorName);
	@Query("Select a From Actors a")
	public Iterable<Actors> findAllActors();
	@Query("SELECT a.actorCategory AS actorCategory, a.mobileNum AS mobileNum FROM Actors a WHERE a.actorName = ?1 AND a.actorCategory = ?2")
	public <T extends View> List<T> findActorsByNameAndCategory(String actorName,String actorCategory,Class<T> clazz);
	@Query("From Actors a Where a.actorCategory=:role")
	public Iterable<Actors> findAllActors2(@Param("role")String category);
	@Query("From com.biswo.entity.Actors Where actorCategory=:role")
	public Iterable<Actors> findAllActors3(String role);
	
}
