package com.luxoft.log.util;

import java.util.ArrayList;
import java.util.List;

import com.luxoft.log.listener.HomeWorkLogDataChangeListener;
import com.luxoft.log.listener.TypeOfEvent;
import com.luxoft.log.model.Person;


public class HomeWorkLogObserver {
	private static HomeWorkLogObserver instance = null;
	private List<HomeWorkLogDataChangeListener> observers;
	
	private HomeWorkLogObserver() {
		observers = new ArrayList<>();
	}
	
	public static HomeWorkLogObserver getInstance() {
		
		if (instance == null) {
			instance = new HomeWorkLogObserver();
		}
		
		return instance;
	}

	public void registerListener(HomeWorkLogDataChangeListener o) {
		observers.add(o);
		
	}

	public void removeListener(HomeWorkLogDataChangeListener o) {
		observers.remove(o);
		
	}

	public void notifyListeners(TypeOfEvent typeOfEvent, Person person) {
		
		for (HomeWorkLogDataChangeListener observer : observers) {
			observer.change(typeOfEvent, person);
		}
	}
	
	public void beforeNotifyListeners(TypeOfEvent event) {
		for (HomeWorkLogDataChangeListener observer : observers) {
			observer.beforeChange(event);
		}
	}

	
}
