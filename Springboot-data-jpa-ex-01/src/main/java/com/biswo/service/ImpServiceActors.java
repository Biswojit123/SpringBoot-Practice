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
	//Partial update of actor
	@Override
	public String updateActorMobileNo(int id, Long mobileNum) {
		//load object by id
		Actors actor = repository.findById(id).orElse(new Actors());
		if(actor.getActorId() == id) {
			actor.setMobileNum(mobileNum);
			repository.save(actor);
			return actor.getActorId()+" Actor mobile number update successfully";
		}else
		 return id+" Actor is not found..";
	}
	//Fully Actor Update 
	@Override
	public String updateActor(Actors actor) {
		Actors actors = repository.findById(actor.getActorId()).orElse(new Actors());
		if(actors.getActorId() == actor.getActorId()) {
			//set the all value to the actors
			actors.setActorName(actor.getActorName());
			actors.setActorCategory(actor.getActorCategory());
			actors.setMobileNum(actor.getMobileNum());
			repository.save(actors);
			return actor.getActorId()+" Actor Update Successfully...";
		}else
		 return actor.getActorId()+" Actor not found.....";
	}
	@Override
	public String UpdateOrInsertIfExist(Actors actor) {
		Actors actors = repository.findById(actor.getActorId()).orElse(new Actors());
		if(actors.getActorId() == actor.getActorId()) {
			//set the all value to the actors
			actors.setActorName(actor.getActorName());
			actors.setActorCategory(actor.getActorCategory());
			actors.setMobileNum(actor.getMobileNum());
			repository.save(actors);
			return actor.getActorId()+" Actor Update or Created Successfully...";
		}else
			//It perform the both update and insert operation when i comment the generated id annotation in Actors level
			repository.save(actor);
		return actor.getActorId()+" Actor Update Or Created Successfully....";
	}
	@Override
	public String deleteActorById(int id) {
		//get the Record actually present or not
		boolean isPresent = repository.existsById(id);
		if(isPresent) {
			repository.deleteById(id);
			return id+" Actor is deleted successfully.....";
		}else
			return id+" Actor is not present....";
	}
	@Override
	public String deleteActor(Actors actor) {
		//check the Actor is available or not
		Actors actors = repository.findById(actor.getActorId()).orElse(new Actors());
		if(actor.getActorId().equals(actors.getActorId())) {
			repository.delete(actors);
			return actors.getActorId()+" Actor deleted successfullly...";
		}else {
			return actor.getActorId()+" Actor is not found......";
		}
	}
	@Override
	public String removeActorById(int id) {
		repository.deleteById(id);
		return id+" Actor Deleted Successfully...";
	}
	@Override
	public String removeAllActors(List<Integer> ids) {
		//Get the 
		repository.deleteAllById(ids);
		return ids.size()+" no fo record deleted successfully....";
	}
}
