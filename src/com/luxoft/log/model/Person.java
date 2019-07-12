package com.luxoft.log.model;

public class Person {
	private String namePerson;
	private String groupNumber;
	private boolean taskDone;
	

	public Person() {
		namePerson = "";
		groupNumber = "";
		taskDone = false;
	}
	
	public Person(String name, String group, boolean taskDone) {
		this.namePerson = name;
		this.groupNumber = group;
		this.taskDone = taskDone;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
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
		result = prime * result + ((groupNumber == null) ? 0 : groupNumber.hashCode());
		result = prime * result + ((namePerson == null) ? 0 : namePerson.hashCode());
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
		if (groupNumber == null) {
			if (other.groupNumber != null)
				return false;
		} else if (!groupNumber.equals(other.groupNumber))
			return false;
		if (namePerson == null) {
			if (other.namePerson != null)
				return false;
		} else if (!namePerson.equals(other.namePerson))
			return false;
		if (taskDone != other.taskDone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name = " + namePerson + ", group = " + groupNumber + ", task done = " + taskDone + "]";
	}
	
	

}
