package com.luxoft.log.listener;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;

import com.luxoft.log.sorter.PersonsTableComparator;

public class PersonsTableColumnSelectionListener extends SelectionAdapter {
	private TableViewer viewer;
	private TableColumn column;
	private int columnNumber;
	
	
	
	
	public PersonsTableColumnSelectionListener(TableViewer viewer, TableColumn column, int columnNumber) {
		super();
		this.viewer = viewer;
		this.column = column;
		this.columnNumber = columnNumber;
	}




	@Override
	public void widgetSelected(SelectionEvent e) {
		PersonsTableComparator.getInstance().setColumn(columnNumber);
		int direction = PersonsTableComparator.getInstance().getDirection();
		viewer.getTable().setSortDirection(direction);
		viewer.getTable().setSortColumn(column);
		viewer.refresh();
	}

	
}
