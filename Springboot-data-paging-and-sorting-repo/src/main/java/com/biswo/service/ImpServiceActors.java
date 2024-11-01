package com.biswo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.biswo.entity.Actors;
import com.biswo.repo.IActorsRepository;

@Service("serviceActors")
public class ImpServiceActors implements InterActorsService {
	@Autowired
	private IActorsRepository repository;

	@Override
	public Iterable<Actors> getAllActorsBySorting(boolean ase, String... prperties) {
		//Create the first the Sort Object
		//according the properties value it can sort and also it depend on the value of ASE value if it true it sort ASEN Or DESEN
		Sort sort = Sort.by(ase?Direction.ASC:Direction.DESC, prperties);
		//pass the sort value to the findAll method
		Iterable<Actors> actors = repository.findAll(sort);
		return actors;
	}
	@Override
	public Page<Actors> showPageRecord(int pageNo, int pageSize) {
		//Create the PageAble object
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Actors> page = repository.findAll(pageable);
		return page;
	}
	@Override
	public void showActorsByPages(int pageSize) {
		//Get the Number of record
		Long numRecord = repository.count();
		//Get the number of page created by this operation
		Long numPage = numRecord % pageSize;
		//Here if the number of record is even then it is fine other wise it increase by one
		numPage = (numRecord % pageSize == 0)?numPage:++numPage;
		//print the all page record 
		for(int i = 0 ; i < numPage; i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Actors> page = repository.findAll(pageable);
			System.out.println((i+1)+" Page records:");
			page.getContent().forEach(System.out::println);
			System.out.println("Current Page number:"+page.getNumber());
			System.out.println("Number Of pages:"+page.getTotalPages());
			System.out.println("Total Records:"+page.getNumberOfElements());
			System.out.println("Is is fast record:"+page.isFirst());
			System.out.println("Is last records:"+page.isLast());
		}	
	}
	
}
