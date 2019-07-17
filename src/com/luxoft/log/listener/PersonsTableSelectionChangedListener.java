package com.luxoft.log.listener;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import com.luxoft.log.model.Person;
import com.luxoft.log.util.HomeWorkLogObserver;

public class PersonsTableSelectionChangedListener implements ISelectionChangedListener {

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		IStructuredSelection selection = event.getStructuredSelection();
	    Object firstElement = selection.getFirstElement();
	    if ((firstElement instanceof Person) && firstElement != null) {
	    	HomeWorkLogObserver.getInstance().notifyListeners(TypeOfEvent.SELECT, (Person) firstElement ); 
	    }
//		System.out.println(firstElement);
	}

}
