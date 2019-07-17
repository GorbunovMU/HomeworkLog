package com.luxoft.log.listener;


import java.nio.file.Paths;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import com.luxoft.log.dao.PersonDAO;

public class SaveToFileSelectionListener extends SelectionAdapter {

	@Override
	public void widgetSelected(SelectionEvent e) {
		FileDialog fd = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
        fd.setText("Save");
        fd.setFilterPath(Paths.get("").toAbsolutePath().toString());
        String[] filterExt = { "*.dat", "*.*" };
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        if (selected != null) { 
        	PersonDAO.getInstance().saveToFile(selected);
        }
	}
	
}
