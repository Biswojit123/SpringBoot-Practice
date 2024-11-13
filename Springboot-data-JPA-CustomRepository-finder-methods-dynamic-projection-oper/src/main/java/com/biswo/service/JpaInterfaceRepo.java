package com.biswo.service;

import java.util.List;

import com.biswo.view.View;

public interface JpaInterfaceRepo {
	public <T extends View> List<T> getByActorCategoryContainingIgnoreCase(String latters,Class<T> clazz);
}
