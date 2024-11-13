package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Actors;
import com.biswo.entity.ResultView;
import com.biswo.repository.JPARepositoryInter;

@Service
public class ImpleServiceRepo implements JpaInterfaceRepo {
	
	//Auto-wired the Repository
	@Autowired
	private JPARepositoryInter repo;

	@Override
	public List<ResultView> getByActorCategoryEqualsIgnoreCase(String category) {
		List<ResultView> actors = repo.findByActorCategoryEqualsIgnoreCase(category);
		return actors;
	}

	@Override
	public ResultView getByMobileNumber(Long mobileNum) {
		ResultView actors = repo.findByMobileNum(mobileNum);
		return actors;
	}
	
}
