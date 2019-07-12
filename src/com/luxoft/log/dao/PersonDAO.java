package com.luxoft.log.dao;

import java.util.ArrayList;
import java.util.List;

import com.luxoft.log.model.Person;

public class PersonDAO {
	private static PersonDAO instance = null;
	
	private PersonDAO() {
	}

	public static PersonDAO getInstance() {
		if (instance == null) {
			instance = new PersonDAO();
		}
		
		return instance;
	}
	
	public List<Person> getAll() {
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Вася", "1", true));
		persons.add(new Person("Петя", "1", false));
		persons.add(new Person("Толик", "2", true));
		
		return persons;
	}

}
