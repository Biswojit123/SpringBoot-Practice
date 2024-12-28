package com.biswo.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.Storeroom;
import com.biswo.service.StoreroomServiceInter;

@Component
public class TestRunnerClass implements CommandLineRunner {
	@Autowired
	private StoreroomServiceInter service;
	@Override
	public void run(String... args) throws Exception {
		
		try {
			Storeroom storeRoom = new Storeroom();
			storeRoom.setNameOfStore("Metro-Mart Store");
			storeRoom.setCategoryOfItems(List.of("Electronics","Grocery","Body-Ware","Buty-Items","Jagan"));
			storeRoom.setItemsNumber(Set.of(2563456l,458997665l,7077018081l,9348572442l,7684024271l));
			storeRoom.setItemsPrice(Map.of("Electronics",25000.0,"Grocery",26000.0,"Body-Ware",23000.0,"Buty-items",28000.0));
			//save the Object
			String message = service.storeItems(storeRoom);
			System.out.println(message);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
