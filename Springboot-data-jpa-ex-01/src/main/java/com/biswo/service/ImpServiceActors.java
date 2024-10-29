package com.biswo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Actors;
import com.biswo.repo.IActorsRepository;

@Service("serviceActors")
public class ImpServiceActors implements InterActorsService {
	//We have to inject the repository class
	@Autowired  //automatically create the iNmemory proxy-class
	private IActorsRepository repository;
	@Override
	public String registerActor(Actors actor) {
		System.out.println("In-Memory Proxy class name:"+repository.getClass()+".....List of implemented interface:"+Arrays.toString(repository.getClass().getInterfaces()));
		Actors actors = repository.save(actor);
		return "actors Register successfully and id value is::"+actors.getActorId();
	}
	@Override
	public String updateActor(int id) {
		Actors actors = repository.findById(id).get();
		actors.setActorCategory("Heroine");
		actors.setActorName("Barsha");
		actors.setMobileNum(125364895l);
		Actors actor = repository.save(actors);
		return "Update Successfully of actor id:"+actor.getActorId();
	}
	@Override
	public String registerActorsGroup(List<Actors> list) {
		//store the list of Actors into database table
		//Here type cast happen because the return type is iterable
		List<Actors> listActors = (List<Actors>) repository.saveAll(list);
		//get the all id from the all actors
		List<Integer> id = listActors.stream().map(actors -> actors.getActorId()).collect(Collectors.toList());
		return listActors.size()+" Objects are saved having id :"+id;
	}
	@Override
	public Long countNumOfRecord() {
		Long numRecord = repository.count();
		return numRecord;
	}
	@Override
	public Iterable<Actors> fetchAllActors() {
		Iterable<Actors> allActors = repository.findAll();
		return allActors;
	}
	@Override
	public boolean isIdExist(int id) {
		boolean isExits = repository.existsById(id);
		return isExits;
	}
	@Override
	public Iterable<Actors> fetchActorsById(Iterable<Integer> ids) {
		Iterable<Actors> actors = repository.findAllById(ids);
		return actors;
	}
	@Override
	public Optional<Actors> fetchActorById(int id) {
		Optional<Actors> actor = repository.findById(id);
		return actor;
	}
	@Override
	public Actors fetchsActorById(int id) {
		Optional<Actors> actors = repository.findById(id);
		Actors actor = actors.orElse(new Actors());
		//Actors actor = actors.orElseThrow(() -> new IllegalArgumentException("Actors not found"));
		return actor;
	}
}
