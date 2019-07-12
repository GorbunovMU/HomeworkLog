package com.luxoft.log.ui;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.luxoft.log.dao.PersonDAO;
import com.luxoft.log.model.Person;
import com.luxoft.log.providers.PersonsTableColumnLabelProvider;
import com.luxoft.log.providers.PersonsTableContentProvider;

public class PersonsTableUI {

	private void displayCheckBoxInCell(Table table) {
		TableItem [] items = table.getItems();
        for (int i = 0; i < items.length; i++) {
			TableEditor editor = new TableEditor(table);
			Button button = new Button(table, SWT.CHECK);
			button.setEnabled(false);
			if ((items[i].getData() instanceof Person) && (items[i].getData() != null)) {
				button.setSelection(((Person) items[i].getData()).isTaskDone());
			}
			
		    button.pack();
		    editor.minimumWidth = button.getSize().x;
		    editor.horizontalAlignment = SWT.CENTER;
		    editor.setEditor(button, items[i], 2);
		}
	}
	
	public void init(Composite composite) {
		PersonsTableColumnLabelProvider columnLabels = new PersonsTableColumnLabelProvider();
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		
        tableViewer.setContentProvider(new PersonsTableContentProvider());
        columnLabels.createColumns(tableViewer);
//        tableViewer.setLabelProvider(new PersonsTableLableProvider());
        
        tableViewer.getTable().setLinesVisible(true);
        tableViewer.getTable().setHeaderVisible(true);
        tableViewer.setInput(PersonDAO.getInstance().getAll());
        displayCheckBoxInCell(tableViewer.getTable());
        
        
	}

}
