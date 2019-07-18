package com.luxoft.log.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;

import com.luxoft.log.util.HomeWorkLogObserver;
import com.luxoft.log.util.HomeworkLogUtil;

public class DeleteItemSelectionListener extends SelectionAdapter {

	@Override
	public void widgetSelected(SelectionEvent e) {
    	int response = HomeworkLogUtil.display(Display.getCurrent().getActiveShell(), 
    			SWT.ICON_QUESTION | SWT.YES | SWT.NO, "Deleting row", "Wanna delete this row?");
    	
    	if (response == SWT.YES) {
    		HomeWorkLogObserver.getInstance().beforeNotifyListeners(TypeOfEvent.DELETE);
    	}
	}
	
}
