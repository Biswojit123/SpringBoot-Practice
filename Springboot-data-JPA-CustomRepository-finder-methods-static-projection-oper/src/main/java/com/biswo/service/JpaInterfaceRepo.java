package com.biswo.service;

import java.util.List;

import com.biswo.entity.ResultView;

public interface JpaInterfaceRepo {
	public List<ResultView> getByActorCategoryEqualsIgnoreCase(String category);
	public ResultView getByMobileNumber(Long mobileNum);
}
