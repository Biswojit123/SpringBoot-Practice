package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Storeroom;
import com.biswo.repo.StoreRoomRepository;

@Service
public class StoreroomServiceImple implements StoreroomServiceInter {
	
	@Autowired
	private StoreRoomRepository repo;

	@Override
	public String storeItems(Storeroom storeRoom) {
		return "Items save in storeRoom successfully with id "+repo.save(storeRoom).getStoreRoomNo();
	}

	@Override
	public List<Storeroom> fetchStoreRoomDetails() {
		return null;
	}

}
