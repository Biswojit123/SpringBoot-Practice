package com.biswo.service;

import java.util.List;

import com.biswo.entity.Storeroom;

public interface StoreroomServiceInter {
	public String storeItems(Storeroom storeRoom);
	public List<Storeroom> fetchStoreRoomDetails();
}
