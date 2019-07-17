package com.luxoft.log.listener;

import com.luxoft.log.model.Person;

public interface HomeWorkLogDataChangeListener {
	void change(TypeOfEvent typeOfEvent, Person person);
	void beforeChange(TypeOfEvent typeOfEvent);
}
