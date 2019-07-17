package com.luxoft.log.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import com.luxoft.log.model.Person;
import com.luxoft.log.util.HomeworkLogUtil;

public class PersonDAO {
	private static PersonDAO instance = null;
	private List<Person> persons;
	
	private Logger logger = Logger.getLogger(PersonDAO.class.getName());
	
	private PersonDAO() {
		persons = new ArrayList<>();
/*
  		persons.add(new Person("Вася", "1", true));
		persons.add(new Person("Петя", "1", false));
		persons.add(new Person("Толик", "2", true));
*/
	}

	public static PersonDAO getInstance() {
		if (instance == null) {
			instance = new PersonDAO();
		}
		
		return instance;
	}
	
	public List<Person> getAll() {

		return persons;
	}
	
	public void saveToFile(String fileName) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(persons);
		} catch (Exception e) {
			logger.log(Level.WARNING, "An error occured during input/output persons list in/from file", e);
			HomeworkLogUtil.display(Display.getCurrent().getActiveShell(), SWT.ICON_ERROR | SWT.OK, "Warning", "An error occured during input/output persons list in/from file");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadFromFile(String fileName) {
		
		 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			persons.clear();
			persons = (ArrayList<Person>) ois.readObject();
			 
		  } catch (Exception e) {
			  logger.log(Level.WARNING, "An error occured during input/output persons list in/from file", e);
			  HomeworkLogUtil.display(Display.getCurrent().getActiveShell(), SWT.ICON_ERROR | SWT.OK, "Warning", "An error occured during input/output persons list in/from file");
		  }
	}

}
