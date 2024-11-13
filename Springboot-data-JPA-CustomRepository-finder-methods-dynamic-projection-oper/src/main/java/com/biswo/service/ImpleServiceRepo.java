package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.repository.JPARepositoryInter;
import com.biswo.view.View;

@Service
public class ImpleServiceRepo implements JpaInterfaceRepo {
	
	//Auto-wired the Repository
	@Autowired
	private JPARepositoryInter repo;

	@Override
	public <T extends View> List<T> getByActorCategoryContainingIgnoreCase(String latters, Class<T> clazz) {
		//Here we find the data dynamically
		return repo.findByActorCategoryContainingIgnoreCase(latters, clazz);
	}

	
}
