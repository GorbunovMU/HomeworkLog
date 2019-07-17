package com.luxoft.log.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

public class CloseApplicationSelectionListener extends SelectionAdapter {

	@Override
	public void widgetSelected(SelectionEvent e) {
	        MessageBox messageBox = new MessageBox(Display.getCurrent().getActiveShell(), 
	        		SWT.ICON_QUESTION | SWT.YES | SWT.NO);
	        
	        messageBox.setMessage("Do you really want to exit?");
	        messageBox.setText("Exiting Application");
	        int response = messageBox.open();
	        if (response == SWT.YES) {
	        	Display.getCurrent().getActiveShell().close();
	        }
	}
	
}
