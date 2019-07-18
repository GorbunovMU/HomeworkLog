package com.luxoft.log.util;

import java.util.ArrayList;
import java.util.List;

import com.luxoft.log.listener.HomeWorkLogDataChangeListener;
import com.luxoft.log.listener.TypeOfEvent;
import com.luxoft.log.model.Person;


public class HomeWorkLogNotifier {
	private static HomeWorkLogNotifier instance = null;
	private List<HomeWorkLogDataChangeListener> observers;
	
	private HomeWorkLogNotifier() {
		observers = new ArrayList<>();
	}
	
	public static HomeWorkLogNotifier getInstance() {
		
		if (instance == null) {
			instance = new HomeWorkLogNotifier();
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
