package com.biswo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.biswo.service.StoreroomServiceInter;

//@Component
public class TestRunner2 implements ApplicationRunner {
	@Autowired
	private StoreroomServiceInter service;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	}

}
