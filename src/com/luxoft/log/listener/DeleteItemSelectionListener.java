package com.luxoft.log.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import com.luxoft.log.util.HomeWorkLogObserver;

public class DeleteItemSelectionListener extends SelectionAdapter {

	@Override
	public void widgetSelected(SelectionEvent e) {
		MessageBox messageBox = new MessageBox(Display.getCurrent().getActiveShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		messageBox.setMessage("Wanna delete this row?");
    	messageBox.setText("Deleting row");
    	int response = messageBox.open();
    	if (response == SWT.YES) {
    		HomeWorkLogObserver.getInstance().beforeNotifyListeners(TypeOfEvent.DELETE);
    	}
	}
	
}
