package com.biswo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.Actors;
import com.biswo.entity.ResultView;

public interface JPARepositoryInter extends JpaRepository<Actors, Integer> {
	
	List<ResultView> findByActorCategoryEqualsIgnoreCase(String Category);
	ResultView findByMobileNum(Long mobileNum);

}
