package com.biswo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.Actors;
import com.biswo.view.View;

public interface JPARepositoryInter extends JpaRepository<Actors, Integer> {
	//find the User record dynamically it depends on your requirement how many field you want
	public <T extends View> List<T> findByActorCategoryContainingIgnoreCase(String category,Class<T> clazz);

}
