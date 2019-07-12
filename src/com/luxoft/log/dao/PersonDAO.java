package com.luxoft.log.dao;

import java.util.ArrayList;
import java.util.List;

import com.luxoft.log.model.Person;

public class PersonDAO {
	
	public List<Person> getAll() {
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Вася", "1", true));
		persons.add(new Person("Петя", "1", true));
		persons.add(new Person("Толик", "2", true));
		
		return persons;
	}

}
