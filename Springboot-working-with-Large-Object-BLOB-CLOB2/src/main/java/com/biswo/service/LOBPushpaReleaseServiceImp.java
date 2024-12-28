package com.biswo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Pushpa;
import com.biswo.repo.LOBRepository;

@Service
public class LOBPushpaReleaseServiceImp implements LOBPushpaReleaseServiceInter {
	@Autowired
	private LOBRepository repo;
	@Override
	public String registerFilmTrailer(Pushpa pushpa) {
		return "Id "+repo.save(pushpa).getFilmId()+" Pusha film trailer save successfully";
	}

}
