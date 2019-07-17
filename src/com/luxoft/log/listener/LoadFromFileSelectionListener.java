package com.luxoft.log.listener;


import java.nio.file.Paths;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import com.luxoft.log.dao.PersonDAO;
import com.luxoft.log.util.HomeWorkLogObserver;

public class LoadFromFileSelectionListener extends SelectionAdapter {

	@Override
	public void widgetSelected(SelectionEvent e) {
		FileDialog fd = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
        fd.setText("Open");
        fd.setFilterPath(Paths.get("").toAbsolutePath().toString());
        String[] filterExt = { "*.dat", "*.*" };
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        PersonDAO.getInstance().loadFromFile(selected);
        HomeWorkLogObserver.getInstance().beforeNotifyListeners(TypeOfEvent.REFRESH);
	}
	
}
