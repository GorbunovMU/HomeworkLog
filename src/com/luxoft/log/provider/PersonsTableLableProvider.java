package com.luxoft.log.provider;

import java.util.Optional;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.luxoft.log.model.Person;

public class PersonsTableLableProvider extends ColumnLabelProvider {
	
	private static final String CHECKED_KEY = "CHECKED";
	private static final String UNCHECK_KEY = "UNCHECKED";

	private int columnIndex;
	
	public PersonsTableLableProvider(ColumnViewer viewer, int columnIndex) {
		super();
		this.columnIndex = columnIndex;
		if (columnIndex == 2) {
			if (JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY) == null) {
				JFaceResources.getImageRegistry().put(CHECKED_KEY, makeShot(viewer.getControl().getShell(), true));
			}
			if (JFaceResources.getImageRegistry().getDescriptor(UNCHECK_KEY) == null) {
				JFaceResources.getImageRegistry().put(UNCHECK_KEY, makeShot(viewer.getControl().getShell(), false));
			}
		}
	}

	
	private Image makeShot(Shell shell, boolean type) {
		Shell s = new Shell(Display.getCurrent().getActiveShell(), SWT.NO_TRIM);
		Button b = new Button(s, SWT.CHECK);
		b.setSelection(type);
		Point bsize = b.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		b.setSize(bsize);
		b.setLocation(0, 0);
		s.setSize(bsize);
		s.open();
		GC gc = new GC(b);
		Image image = new Image(shell.getDisplay(), bsize.x, bsize.y);
		gc.copyArea(image, 0, 0);
		gc.dispose();
		s.close();
		return image;
	}
	
	
	private Optional<Person> convertToPerson (Object element) {
		if (element instanceof Person) {
			return Optional.ofNullable((Person) element);
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public String getText(Object element) {
		Optional<Person> person = convertToPerson(element);
		
		if (person.isPresent()) {
			switch (columnIndex) {
			case 0:
				return person.get().getPersonName();
			case 1:
				return person.get().getGroupName();
			case 2:
				return "";
	//			return Boolean.toString(person.isTaskDone());
			default:
				return "";
			}
		} else {
			return "";
		}
	}

	@Override
	public Image getImage(Object element) {
		Optional<Person> person = convertToPerson(element);
		
		if (person.isPresent() && (columnIndex == 2)) {
			if (person.get().isTaskDone()) {
				return JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY).createImage();
			} else {
				return JFaceResources.getImageRegistry().getDescriptor(UNCHECK_KEY).createImage();
			}
			
		} else {
			return null;
		}
	}

}
