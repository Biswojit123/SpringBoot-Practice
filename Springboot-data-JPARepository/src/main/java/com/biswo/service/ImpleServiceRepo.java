package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.biswo.entity.Actors;
import com.biswo.repository.JPARepositoryInter;

@Service
public class ImpleServiceRepo implements JpaInterfaceRepo {
	
	@Autowired
	private JPARepositoryInter repository;

	@Override
	public String removeActorsByIdInBatch(List<Integer> ids) {
		//Get the all Records by id
		List<Actors> listactor = repository.findAllById(ids);
		//We have to find how many record is available 
		int record = listactor.size();
		//delete all record from the database
		repository.deleteAllByIdInBatch(ids);
		return record+" no. of record deleted successfully.......";
	}

	@Override
	public Actors searchActorById(int id) {
		Actors actor = repository.getReferenceById(id);
		return actor;
	}

	@Override
	public List<Actors> searchActorsByActor(Actors actor, boolean order, String... properties) {
		//Get the Example object
		Example<Actors> example = Example.of(actor);
		//get the Sort object
		Sort sort = Sort.by(order?Direction.ASC:Direction.DESC, properties);
		//pass that example and sort object to the below method
		List<Actors> actors = repository.findAll(example, sort);
		return actors;
	}

}
