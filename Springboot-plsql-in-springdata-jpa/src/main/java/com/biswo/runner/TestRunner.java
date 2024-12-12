package com.biswo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.Actor;
import com.biswo.repo.PlSqlInterface;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Component
public class TestRunner implements ApplicationRunner {

	@Autowired
	private PlSqlInterface repo;
	@Autowired
	private EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Before insert the record first delete the all record
		repo.deleteAll();
		// Insert the number of records
		List<Actor> listActors = List.of(new Actor("Jagan Palei", "Comedian", 9348572442l),
				new Actor("Biswojit Jena", "Hero", 8260293404l), new Actor("Ritesh Sethi", "Singer", 7856894563l),
				new Actor("Ajit Das", "Hero", 7683863795l), new Actor("Sriya", "Heroine", 7077018081l),
				new Actor("Rasmi", "Heroine", 7077044185l));
		// Save objects
		repo.saveAll(listActors);

		// Get the Data from the table according to the Actor category By calling the
		// stored procedure
		//Create the Stored procedure query object having storedProcedure name and result type 
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("P_Get_Actors_By_Category",Actor.class);
		//Register both IN, OUT params to the PLSQL procedure
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR);
		//Set the Values to parameter
		query.setParameter(1, "Hero");
		query.setParameter(2, "Comedian");
		//call the PLSQl procedure
		List<Actor> list = query.getResultList();
		list.forEach(System.out::println);
	}

}
