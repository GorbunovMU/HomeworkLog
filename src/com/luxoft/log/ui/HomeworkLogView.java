package com.luxoft.log.ui;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class HomeworkLogView extends ApplicationWindow {
	
	private static final String MAIN_WINDOW_NAME = "JFace homework log"; 
	private static final int SASH_WIDTH = 10;

	public HomeworkLogView() {
		super(null);
	}
	
	@Override
	protected Control createContents(Composite parent) {
		
		getShell().setText(MAIN_WINDOW_NAME);
		
		HomeworkLogMenuBar menuBar = new HomeworkLogMenuBar(getShell());
		getShell().setMenuBar(menuBar.getMenuBar());
		
        SashForm sashForm = new SashForm(getShell(), SWT.HORIZONTAL);
        sashForm.setSashWidth(SASH_WIDTH);
        
        PersonsTableUI personsTableUI = new PersonsTableUI();
		personsTableUI.initTableView(sashForm);
		
		PersonEditComposite personEditComposite = new PersonEditComposite(sashForm, SWT.NONE);
		personEditComposite.init();
		
		personsTableUI.setSelectedFirstRow();
		parent.pack();
		
		return parent;
	}
	
	
	public void openView() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

}
