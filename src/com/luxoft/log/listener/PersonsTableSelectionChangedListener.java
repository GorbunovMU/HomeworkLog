package com.luxoft.log.listener;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import com.luxoft.log.model.Person;
import com.luxoft.log.util.HomeWorkLogNotifier;

public class PersonsTableSelectionChangedListener implements ISelectionChangedListener {

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		
//		IStructuredSelection selection = event.getStructuredSelection();
		if (event.getSelection() instanceof StructuredSelection) {
	  	    IStructuredSelection selection = (StructuredSelection) event.getSelection();
//	  	    System.err.println("### event: " + event);
	  	    Object firstElement = selection.getFirstElement();
	  	    if ((firstElement instanceof Person) && firstElement != null) {
	  	    	HomeWorkLogNotifier.getInstance().notifyListeners(TypeOfEvent.SELECT, (Person) firstElement ); 
	  	    }
		}
	}

}
