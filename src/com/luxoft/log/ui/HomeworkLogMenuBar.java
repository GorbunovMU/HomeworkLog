package com.luxoft.log.ui;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.luxoft.log.listener.CancelItemSelectionListener;
import com.luxoft.log.listener.CloseApplicationSelectionListener;
import com.luxoft.log.listener.DeleteItemSelectionListener;
import com.luxoft.log.listener.LoadFromFileSelectionListener;
import com.luxoft.log.listener.NewItemSelectionListener;
import com.luxoft.log.listener.SaveItemSelectionListener;
import com.luxoft.log.listener.SaveToFileSelectionListener;


public class HomeworkLogMenuBar {
	
	private Menu menuBar, fileMenu, editMenu, helpMenu;

	private MenuItem fileMenuHeader, editMenuHeader, helpMenuHeader;

	private MenuItem fileExitItem, fileSaveItem, fileLoadItem;
	private MenuItem editSaveItem, editDeleteItem, editNewItem, editCancelItem;
	private MenuItem helpGetHelpItem;

	public HomeworkLogMenuBar(Shell shell) {
		init(shell);
		initListeners();
		
	}
	
	private void initFileMenu(Shell shell ) {
	    fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    fileMenuHeader.setText("&File");

	    fileMenu = new Menu(shell, SWT.DROP_DOWN);
	    fileMenuHeader.setMenu(fileMenu);
	    
	    fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileSaveItem.setText("&Save to file");

	    fileLoadItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileLoadItem.setText("&Load from file");
	    
	    fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileExitItem.setText("E&xit");
		
	}
	
	private void initEditMenu(Shell shell) {
	    editMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    editMenuHeader.setText("&Edit");
	    
	    editMenu = new Menu(shell, SWT.DROP_DOWN);
	    editMenuHeader.setMenu(editMenu);
	    
	    editNewItem = new MenuItem(editMenu, SWT.PUSH);
	    editNewItem.setText("&New");
	    
	    editSaveItem = new MenuItem(editMenu, SWT.PUSH);
	    editSaveItem.setText("&Save");

	    editDeleteItem = new MenuItem(editMenu, SWT.PUSH);
	    editDeleteItem.setText("&Delete");
	    
	    editCancelItem = new MenuItem(editMenu, SWT.PUSH);
	    editCancelItem.setText("&Cancel");
		
	}

	private void initHelpMenu(Shell shell) {
	    helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    helpMenuHeader.setText("&Help");

	    helpMenu = new Menu(shell, SWT.DROP_DOWN);
	    helpMenuHeader.setMenu(helpMenu);

	    helpGetHelpItem = new MenuItem(helpMenu, SWT.PUSH);
	    helpGetHelpItem.setText("&Get Help");
		
	}
	
	
	private void init (Shell shell) {
		menuBar = new Menu(shell, SWT.BAR);
		
		initFileMenu(shell);
		initEditMenu(shell);
		initHelpMenu(shell);
	}
	
	private void initListeners() {
		editNewItem.addSelectionListener(new NewItemSelectionListener());
		editSaveItem.addSelectionListener(new SaveItemSelectionListener());
		editDeleteItem.addSelectionListener(new DeleteItemSelectionListener());
		editCancelItem.addSelectionListener(new CancelItemSelectionListener());
		
		fileSaveItem.addSelectionListener(new SaveToFileSelectionListener());
		fileLoadItem.addSelectionListener(new LoadFromFileSelectionListener());
		fileExitItem.addSelectionListener(new CloseApplicationSelectionListener());
	}


	public Menu getMenuBar() {
		return menuBar;
	}
	
	
}
