package com.luxoft.log.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;

import com.luxoft.log.util.HomeWorkLogNotifier;
import com.luxoft.log.util.HomeworkLogUtil;

public class SaveItemSelectionListener extends SelectionAdapter {

	@Override
	public void widgetSelected(SelectionEvent e) {
		    	
    	int response = HomeworkLogUtil.display(Display.getCurrent().getActiveShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO,
        		"Saving changes", "Wanna save your changes?");
    	
    	if (response == SWT.YES) {
    		HomeWorkLogNotifier.getInstance().beforeNotifyListeners(TypeOfEvent.UPDATE);
    	}
	}
	
}
