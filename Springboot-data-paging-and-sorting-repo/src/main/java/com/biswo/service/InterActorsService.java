package com.biswo.service;

import org.springframework.data.domain.Page;

import com.biswo.entity.Actors;

public interface InterActorsService {
	public Iterable<Actors> getAllActorsBySorting(boolean ase,String ...prperties);
	public Page<Actors> showPageRecord(int pageNo,int pageSize);
	public void showActorsByPages(int pageSize);
	
}
