package com.luxoft.log.ui;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;

public class HomeworkLogView extends ApplicationWindow {
	
	private static final String MAIN_WINDOW_NAME = "JFace homework log"; 


	public HomeworkLogView() {
		super(null);
	}
	
	@Override
	protected Control createContents(Composite parent) {
		getShell().setText(MAIN_WINDOW_NAME);
        SashForm sashForm = new SashForm(getShell(), SWT.HORIZONTAL);
        TableViewer tableViewer = new TableViewer(sashForm, SWT.BORDER | SWT.FULL_SELECTION);
        new TableViewerColumn(tableViewer, SWT.LEFT).getColumn().setText("Name");
        Button button2 = new Button(sashForm, SWT.NONE);
        button2.setText("Button 2");
 
        Button button3 = new Button(sashForm, SWT.NONE);
        button3.setText("Button 3");
        sashForm.setWeights(new int[] { 2, 3, 1 });
        
        sashForm.setSashWidth(10);
		
		parent.pack();
		return parent;
	}
	
	
	public void openView() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

}
