package com.luxoft.log.listener;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.luxoft.log.util.HomeWorkLogObserver;

public class NewItemSelectionListener extends SelectionAdapter {

	@Override
	public void widgetSelected(SelectionEvent e) {
		HomeWorkLogObserver.getInstance().beforeNotifyListeners(TypeOfEvent.NEW);
	}
	
}
