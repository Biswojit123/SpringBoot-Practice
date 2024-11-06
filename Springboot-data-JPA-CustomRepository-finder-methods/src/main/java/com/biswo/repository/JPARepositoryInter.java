package com.biswo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.Actors;

public interface JPARepositoryInter extends JpaRepository<Actors, Integer> {
	//------------------This is One section in this section doing same task in three ways---------------------
	//custom method of JPARepositoryInter Interface all are implement by InMemory ProxyClass Object.
	List<Actors> findByActorNameEquals(String name);
	//Instead of using above we can do this task also like given below
	List<Actors> findByActorNameIs(String str);
	//Also do above task like given below
	List<Actors> findByActorName(String str);
	//------------------This is the Another Section it perform the another task -----------------
	List<Actors> findByActorIdBetween(Integer start, Integer end);
	//-------------------This is the another section to perform the different task 
	Iterable<Actors> findByActorCategoryEqualsIgnoreCase(String category);
	//-------------------This is the another section here we can get the all details using the single character-------------
	//Select * from data_jpa where actorName = ? (%S)
	Iterable<Actors> findByActorNameLike(String lastChar);
	//Select * from data_jpa where actorName = ? (S%)
	Iterable<Actors> findByActorNameStartingWith(String startChar);
	//Select * from data_jpa where actorName = ? (%S%)
	Iterable<Actors> findByActorNameContainingIgnoreCase(String midChar);

}
