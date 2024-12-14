package com.biswo.runner;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;

@Component
public class TestRunner implements ApplicationRunner {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// unwrap the session object
		Session session = entityManager.unwrap(Session.class);
		// use the callable interface Work(i) to get the jdbc vonnection object to write
		// the callableStatement object based logic and call plsql function
		session.doWork(con -> {
			//CREATE THE CALLABLESTATEMENT OBJECT CALL THE PLSQL FUNCTION
			CallableStatement cs = con.prepareCall("{?=call F_GET_ACTOR_BY_CATEGORY(?,?)}");
			//REGISTER OUT,RETURN PARAM WITH JDBC TYPE(IN PARAM NEED NOT TO BE REGISTER)
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			//SET THE VALUE TO IN PARAM
			cs.setString(2, "Hero");
			cs.setString(3, "Heroine");
			//call the PLSQL function
			cs.execute();
			//gather result
			ResultSet object = (ResultSet) cs.getObject(1);
			//Print the object
			while(object.next()) {
				System.out.println(object.getInt(1)+"....."+object.getString(2)+"....."+object.getString(3)+"....."+object.getLong(4));
			}
		});
	}

}
