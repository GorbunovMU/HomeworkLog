package com.luxoft.log.model;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6234839772206875598L;
	
	private String personName;
	private String groupName;
	private boolean taskDone;
	

	public Person() {
		personName = "";
		groupName = "";
		taskDone = false;
	}
	
	public Person(String personName, String groupName, boolean taskDone) {
		this.personName = personName;
		this.groupName = groupName;
		this.taskDone = taskDone;
	}

	
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean isTaskDone() {
		return taskDone;
	}

	public void setTaskDone(boolean taskDone) {
		this.taskDone = taskDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
		result = prime * result + (taskDone ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		if (taskDone != other.taskDone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name = " + personName + ", group = " + groupName + ", task done = " + taskDone + "]";
	}
	
	

}
