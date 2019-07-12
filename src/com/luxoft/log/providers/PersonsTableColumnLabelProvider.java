package com.luxoft.log.providers;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;

import com.luxoft.log.model.Person;

public class PersonsTableColumnLabelProvider {
	
	private static final String [] COLUMN_NAMES = {"Name", "Group",  "SWT done"};
	private static final int [] COLUMN_WIDTH = {100, 100, 100};
//	private static final int COLUMN_COUNT = 3;

	public void createColumns (TableViewer viewer) {
		
		// Column 0: Name
		int i = 0;
		TableViewerColumn column = new TableViewerColumn(viewer, SWT.LEFT);
		column.getColumn().setWidth(COLUMN_WIDTH[i]);
		column.getColumn().setText(COLUMN_NAMES[i]);
		column.getColumn().setMoveable(true);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Person) {
					return ((Person) element).getNamePerson();
				}
				return super.getText(element);
			}
		});
		
		
		// Column 1: Group
		i = 1;
		column = new TableViewerColumn(viewer, SWT.RIGHT);
		column.getColumn().setWidth(COLUMN_WIDTH[i]);
		column.getColumn().setText(COLUMN_NAMES[i]);
		column.getColumn().setMoveable(true);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Person) {
					return ((Person) element).getGroupNumber();
				}
				return super.getText(element);
				
		}
		});
		
		
		
		// Column 2: SWT done
		i = 2;
		column = new TableViewerColumn(viewer, SWT.CENTER);
		column.getColumn().setWidth(COLUMN_WIDTH[i]);
		column.getColumn().setText(COLUMN_NAMES[i]);
		column.getColumn().setMoveable(true);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Person) {
//					return Boolean.toString(((Person) element).isTaskDone());
					return "";
/*					if (((Person) element).isTaskDone()) {
						return Character.toString((char)0x2611);
					} else {
						return Character.toString((char)0x2610);
					}
*/				}
				return super.getText(element);
		}
		});
		
//		column.setLabelProvider(new PersonsTableCheckBoxLabelProvider(viewer));
	}
	
}
