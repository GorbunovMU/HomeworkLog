package com.luxoft.log.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.luxoft.log.listener.CancelItemSelectionListener;
import com.luxoft.log.listener.DeleteItemSelectionListener;
import com.luxoft.log.listener.HomeWorkLogDataChangeListener;
import com.luxoft.log.listener.NewItemSelectionListener;
import com.luxoft.log.listener.SaveItemSelectionListener;
import com.luxoft.log.listener.TypeOfEvent;
import com.luxoft.log.model.Person;
import com.luxoft.log.util.HomeWorkLogObserver;
import com.luxoft.log.util.HomeworkLogUtil;

public class PersonEditComposite extends Composite implements HomeWorkLogDataChangeListener {
	
	private static final String NAME_PERSON_LABLE_NAME = "Name";
	private static final String GROUP_PERSON_LABLE_NAME = "Group";
	private static final String TASK_DONE_LABLE_NAME = "SWT task done";
	
	private static final String[] BUTTON_NAME = {"New", "Save", "Delete", "Cancel"};
	
	private static final int NUMBER_TEXT_LIMIT = 20;
	
	private Label nameLabel;
	private Text nameText;
	
	private Label groupLabel;
	private Text groupText;
	
	private Label taskDoneLabel;
	private Button taskDoneCheckBox;
	
	private Button newButton;
	private Button saveButton;
	private Button deleteButton;
	private Button cancelButton;
	
	private Person previosPersonData;
	
	public PersonEditComposite(Composite parent, int style) {
		super(parent, style);
		HomeWorkLogObserver.getInstance().registerListener(this);
	}
	
	private void initButtons() {
		GridData gridData;
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_END);
        gridData.horizontalSpan = 2;
//        gridData.horizontalIndent = 0;
        gridData.verticalIndent = 10;
        gridData.grabExcessHorizontalSpace = true;
		
		newButton = new Button(this, SWT.NONE);
		newButton.setText(BUTTON_NAME[0]);
//		newButton.setEnabled(false);
//		newButton.setToolTipText(TOOLTIP_BUTTON_CALCULATE_NAME);
        newButton.setLayoutData(gridData);
        
        saveButton = new Button(this, SWT.NONE);
        saveButton.setText(BUTTON_NAME[1]);
        saveButton.setLayoutData(gridData);
//        saveButton.setEnabled(false);
        
        deleteButton = new Button(this, SWT.NONE);
        deleteButton.setText(BUTTON_NAME[2]);
//        deleteButton.setEnabled(false);
        deleteButton.setLayoutData(gridData);
        
        
        cancelButton = new Button(this, SWT.NONE);
        cancelButton.setText(BUTTON_NAME[3]);
//        cancelButton.setEnabled(false);
        cancelButton.setLayoutData(gridData);

	}
	
	private void setEnabledAllButtons(boolean enable) {
		newButton.setEnabled(enable);
		saveButton.setEnabled(enable);
		deleteButton.setEnabled(enable);
		cancelButton.setEnabled(enable);
	}
	
	private void initButtonListeners() {
		newButton.addSelectionListener(new NewItemSelectionListener());
		saveButton.addSelectionListener(new SaveItemSelectionListener());
		deleteButton.addSelectionListener(new DeleteItemSelectionListener());
		cancelButton.addSelectionListener(new CancelItemSelectionListener());
		
	}
	
	private void checkForEnableButtonsNewAndCancel() {
		boolean enableButtons = validateTextData();
				
		newButton.setEnabled(enableButtons);
		cancelButton.setEnabled(enableButtons);

	}
	
	private void initTextListeners() {
		nameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				checkForEnableButtonsNewAndCancel();
			}
		});
		
		
		groupText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				checkForEnableButtonsNewAndCancel();
			}
		});
		
	}
	
	public void init() {
		GridData gridDataLabel, gridDataText;
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 8;
		gridLayout.marginRight = 20;
		gridLayout.marginBottom = 20;
		//gridLayout.makeColumnsEqualWidth = true;
		setLayout(gridLayout);
		
		gridDataLabel = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
        gridDataLabel.horizontalSpan = 2;
        gridDataLabel.grabExcessHorizontalSpace = true;
		
        
        gridDataText = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridDataText.horizontalSpan = 6;
        gridDataText.grabExcessHorizontalSpace = true;
		
		nameLabel = new Label(this, SWT.NULL);
		nameLabel.setText(NAME_PERSON_LABLE_NAME);
        nameLabel.setLayoutData(gridDataLabel);
        
        nameText = new Text(this, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
        nameText.setTextLimit(NUMBER_TEXT_LIMIT);
        nameText.setLayoutData(gridDataText);
		
        groupLabel = new Label(this, SWT.NULL);
        groupLabel.setText(GROUP_PERSON_LABLE_NAME);
        groupLabel.setLayoutData(gridDataLabel);
        
        groupText = new Text(this, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
        groupText.setTextLimit(NUMBER_TEXT_LIMIT);
        groupText.setLayoutData(gridDataText);
        
        
        taskDoneLabel = new Label(this, SWT.NULL);
        taskDoneLabel.setText(TASK_DONE_LABLE_NAME);
        taskDoneLabel.setLayoutData(gridDataLabel);
        
        taskDoneCheckBox = new Button(this, SWT.CHECK | SWT.RIGHT_TO_LEFT);
        taskDoneCheckBox.setLayoutData(gridDataText);
        
        initButtons();
        initButtonListeners();
        setEnabledAllButtons(false);
        initTextListeners();
        
        
	}

	
	private void convertToWidgets(Person person) {
		if (person != null) {
			nameText.setText(person.getPersonName());
			groupText.setText(person.getGroupName());
			taskDoneCheckBox.setSelection(person.isTaskDone());
		}
	}
	
	private Person convertToModel() {
		Person person = new Person();
		
		person.setPersonName(nameText.getText().trim());
		person.setGroupName(groupText.getText().trim());
		person.setTaskDone(taskDoneCheckBox.getSelection());
		
		return person;
	}
	
	private void selectionChanged(Person newPersonData) {
		previosPersonData = newPersonData;
		if (newPersonData != null) {
			convertToWidgets(previosPersonData);
		}
		
	}
	
	
	private void beforeUpdatePerson(Person updatedPerson) {
		Person newPerson = convertToModel();
		
		updatedPerson.setGroupName(newPerson.getGroupName());
		updatedPerson.setPersonName(newPerson.getPersonName());
		updatedPerson.setTaskDone(newPerson.isTaskDone());
		
		HomeWorkLogObserver.getInstance().notifyListeners(TypeOfEvent.UPDATE, previosPersonData);
	}
	

	
	private boolean validateTextData() {
		boolean isvalid = true;
		
		if (nameText.getText().trim().isEmpty()) {
			isvalid = false;
		}
		
		if(groupText.getText().trim().isEmpty()) {
			isvalid = false;
		}
		
		
		return isvalid;
	}
	
	private void beforeNewPerson() {
		
		if (validateTextData()) {
			Person newPerson = convertToModel();
			HomeWorkLogObserver.getInstance().notifyListeners(TypeOfEvent.NEW, newPerson);
		} else {
			HomeworkLogUtil.display(Display.getCurrent().getActiveShell(), SWT.ICON_WARNING | SWT.OK, "Warning", "One of the field is empty!");
		}
	}
	
	
	@Override
	public void change(TypeOfEvent typeOfEvent, Person person) {
		
		setEnabledAllButtons(false);
		
		switch (typeOfEvent) {
		case SELECT:
		case UPDATE:
			setEnabledAllButtons(true);
			selectionChanged(person);
			break;
		case CANCEL:
			break;
		case DELETE:
			break;
		case NEW:
			break;
		case REFRESH:
			break;
		}
		
	}

	@Override
	public void beforeChange(TypeOfEvent typeOfEvent) {
		switch (typeOfEvent) {
		case CANCEL:
			convertToWidgets(previosPersonData);
			break;
		case DELETE:
			convertToWidgets(new Person());
    		HomeWorkLogObserver.getInstance().notifyListeners(TypeOfEvent.DELETE, previosPersonData);
			break;
		case NEW:
			beforeNewPerson();
			break;
		case SELECT:
			break;
		case UPDATE:
			beforeUpdatePerson(previosPersonData);
			break;
		case REFRESH:
			break;
		}
		
	}
	
	

}
