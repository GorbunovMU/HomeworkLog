package com.luxoft.log.provider;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;

import com.luxoft.log.model.Person;

public class PersonsTableContentProvider implements IStructuredContentProvider{

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object inputElement) {
		
		List<Person> list = (List<Person>) inputElement;
		
		return list.toArray();
	}

}
