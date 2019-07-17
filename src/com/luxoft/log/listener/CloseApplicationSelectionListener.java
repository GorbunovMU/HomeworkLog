package com.luxoft.log.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;

import com.luxoft.log.util.HomeworkLogUtil;

public class CloseApplicationSelectionListener extends SelectionAdapter {

	@Override
	public void widgetSelected(SelectionEvent e) {
	        
	        int response = HomeworkLogUtil.display(Display.getCurrent().getActiveShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO,
	        		"Exiting Application", "Do you really want to exit?");
	        
	        if (response == SWT.YES) {
	        	Display.getCurrent().getActiveShell().close();
	        }
	}
	
}
