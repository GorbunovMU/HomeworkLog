package com.luxoft.log.sorter;

import java.util.Optional;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

import com.luxoft.log.model.Person;

public class PersonsTableComparator extends ViewerComparator {
	private int columnNumber;
	private boolean byAscending;
	
	private static PersonsTableComparator instance = null;
	
	private PersonsTableComparator() {
		this.columnNumber = 0;
		this.byAscending = true;
	}

	public static PersonsTableComparator getInstance() {
		if (instance == null) {
			instance = new PersonsTableComparator();
		}
		
		return instance;
	}
	
	public int getDirection() {
		if (byAscending) {
			return SWT.UP;
		} else {
			return SWT.DOWN;
		}
	}

	public void setColumn(int columnNumber) {
		if (columnNumber == this.columnNumber) {
			byAscending = !byAscending;
		} else {
			this.columnNumber = columnNumber;
			byAscending = true;
		}
	}	
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		int res = 0;
		Optional<Person> personOne = Optional.empty();
		Optional<Person> personTwo = Optional.empty();
		
		if ((e1 instanceof Person)) {
			personOne = Optional.of((Person) e1);
		}
		
		if ((e2 instanceof Person)) {
			personTwo = Optional.of((Person) e2);
		}
		
		if (personOne.isPresent() && personTwo.isPresent()) {
			switch (columnNumber) {
			case 0:
				res = personOne.get().getPersonName().compareTo(personTwo.get().getPersonName());
				break;

			case 1:
				res = personOne.get().getGroupName().compareTo(personTwo.get().getGroupName());
				break;
			
			case 2:
				if (personOne.get().isTaskDone() == personTwo.get().isTaskDone()) {
					res = 0;
				} else {
					res = personOne.get().isTaskDone() ? 1 : -1;
				}
				break;

			default:
				res = 0;
			}
		}
		
		if (!byAscending) {
			res = -res;
		}
		
		return res;
	}
	
}
