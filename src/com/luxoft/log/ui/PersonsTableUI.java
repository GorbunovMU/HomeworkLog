package com.luxoft.log.ui;

import java.util.List;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TableColumn;

import com.luxoft.log.dao.PersonDAO;
import com.luxoft.log.listener.HomeWorkLogDataChangeListener;
import com.luxoft.log.listener.PersonsTableSelectionChangedListener;
import com.luxoft.log.listener.TypeOfEvent;
import com.luxoft.log.model.Person;
import com.luxoft.log.provider.PersonsTableContentProvider;
import com.luxoft.log.provider.PersonsTableLableProvider;
import com.luxoft.log.sorter.PersonsTableComparator;
import com.luxoft.log.util.HomeWorkLogObserver;

public class PersonsTableUI implements HomeWorkLogDataChangeListener {
	
	private static final int COLUMN_COUNT = 3;
	private static final String [] COLUMN_NAMES = {"Name", "Group",  "SWT done"};
	private static final int [] COLUMN_WIDTH = {100, 100, 100};
	
	private TableViewer tableViewer;
	private List<Person> persons;
	
	private Menu headerMenu;
	
	public PersonsTableUI() {
		HomeWorkLogObserver.getInstance().registerListener(this);
		persons = PersonDAO.getInstance().getAll();
	}
	
	private void createTableViewColumns () {
		
		for (int i = 0; i < COLUMN_COUNT; i++) {
			final int columnNumber = i;
			
			TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.LEFT);
			column.getColumn().setWidth(COLUMN_WIDTH[i]);
			column.getColumn().setText(COLUMN_NAMES[i]);
			column.getColumn().setMoveable(true);
			column.getColumn().setResizable(true);
			column.setLabelProvider(new PersonsTableLableProvider(tableViewer, i));
			column.getColumn().addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					PersonsTableComparator.getInstance().setColumn(columnNumber);
					int direction = PersonsTableComparator.getInstance().getDirection();
					tableViewer.getTable().setSortDirection(direction);
					tableViewer.getTable().setSortColumn(column.getColumn());
					tableViewer.refresh();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			
			createMenuItem(headerMenu, column.getColumn());
		}
		
	}
	
	private void initListeners() {
		tableViewer.addSelectionChangedListener(new PersonsTableSelectionChangedListener());
	}
	
	
	public void setSelectedFirstRow() {
				
		if (!persons.isEmpty()) {
        	tableViewer.setSelection(new StructuredSelection(persons.get(0)));
        }
	}
	
	public void initTableView(Composite composite) {

		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		
		headerMenu = new Menu(tableViewer.getTable());
		tableViewer.getTable().setMenu(headerMenu);
		
        tableViewer.setContentProvider(new PersonsTableContentProvider());
        createTableViewColumns();
        tableViewer.getTable().setLinesVisible(true);
        tableViewer.getTable().setHeaderVisible(true);
        tableViewer.setInput(persons);
        
        tableViewer.setComparator(PersonsTableComparator.getInstance());
        
        initListeners();
        
	}
	
	private void createMenuItem(Menu parent, final TableColumn column) {
		final MenuItem itemName = new MenuItem(parent, SWT.CHECK);
		itemName.setText(column.getText());
		itemName.setSelection(column.getResizable());
		itemName.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				if (itemName.getSelection()) {
					column.setWidth(COLUMN_WIDTH[0]);
					column.setResizable(true);
				} else {
					column.setWidth(0);
					column.setResizable(false);
				}
			}
		});

	}
	

	private void updateSelectedRow(Person newPerson) {
	    tableViewer.refresh();
	}
	
	
	private void addNewPerson(Person newPerson) {
		persons.add(newPerson);
		tableViewer.refresh();
		tableViewer.getTable().setFocus();
		tableViewer.setSelection(new StructuredSelection(newPerson));
		
	}
	
	
	private void deletePerson(Person deletedPerson) {
		persons.remove(deletedPerson);
		tableViewer.refresh();
		setSelectedFirstRow();
	}
	
	private void refreshAllData() {
		persons = PersonDAO.getInstance().getAll();
		tableViewer.setInput(persons);
		tableViewer.refresh();
		setSelectedFirstRow();
	}
	
	@Override
	public void change(TypeOfEvent typeOfEvent, Person person) {
		switch (typeOfEvent) {
		case UPDATE:
			updateSelectedRow(person);
			break;
		case NEW:
			addNewPerson(person);
			break;
		case DELETE:
			deletePerson(person);
			break;
		case CANCEL:
			break;
		case SELECT:
			break;
		case REFRESH:
			break;
		}
	}

	@Override
	public void beforeChange(TypeOfEvent typeOfEvent) {
		switch (typeOfEvent) {
		case CANCEL:
			break;
		case DELETE:
			break;
		case NEW:
			break;
		case REFRESH:
			refreshAllData();
			break;
		case SELECT:
			break;
		case UPDATE:
			break;
		}
		
	}
	

}
