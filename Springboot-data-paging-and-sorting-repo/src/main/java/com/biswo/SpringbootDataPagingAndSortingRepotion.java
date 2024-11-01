package com.biswo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.biswo.service.ImpServiceActors;

@SpringBootApplication
public class SpringbootDataPagingAndSortingRepotion {
	@Autowired
	private ImpServiceActors service;

	public static void main(String[] args) {
		// IOC container
		SpringApplication.run(SpringbootDataPagingAndSortingRepotion.class, args);
	}

}
