package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Actors;
import com.biswo.repository.JPARepositoryInter;
import com.biswo.view.View;

@Service
public class ImpleServiceRepo implements JpaInterfaceRepo {
	
	//Auto-wired the Repository
	@Autowired
	private JPARepositoryInter repo;

	@Override
	public Iterable<Actors> findByActorName(String actorName) {
		return repo.findByActorName(actorName);
	}

	@Override
	public Iterable<Actors> findAllActors() {
		return repo.findAllActors();
	}

	@Override
	public <T extends View> List<T> findActorsByNameAndCategory(String actorName, String actorCategory,
			Class<T> clazz) {
		
		return repo.findActorsByNameAndCategory(actorName, actorCategory, clazz);
	}

	@Override
	public Iterable<Actors> findAllActors2(String category) {
		return repo.findAllActors2(category);
	}

	@Override
	public Iterable<Actors> findAllActors3(String role) {
		return repo.findAllActors3(role);
	}
	
}
