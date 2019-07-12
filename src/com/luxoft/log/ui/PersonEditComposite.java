package com.luxoft.log.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PersonEditComposite extends Composite {
	
	private static final String NAME_PERSON_LABLE_NAME = "Name";
	private static final String GROUP_PERSON_LABLE_NAME = "Group";
	private static final String TASK_DONE_LABLE_NAME = "SWT task done";
	
	private static final String[] BUTTON_NAME = {"New", "Save", "Delete", "Cancel"};
	
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
	
	public PersonEditComposite(Composite parent, int style) {
		super(parent, style);
		init();
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
//		newButton.setToolTipText(TOOLTIP_BUTTON_CALCULATE_NAME);
        newButton.setLayoutData(gridData);
        
        saveButton = new Button(this, SWT.NONE);
        saveButton.setText(BUTTON_NAME[1]);
        saveButton.setLayoutData(gridData);

        
        deleteButton = new Button(this, SWT.NONE);
        deleteButton.setText(BUTTON_NAME[2]);
        deleteButton.setLayoutData(gridData);

        
        cancelButton = new Button(this, SWT.NONE);
        cancelButton.setText(BUTTON_NAME[3]);
        cancelButton.setLayoutData(gridData);

	}
	
	private void init() {
		GridData gridDataLabel, gridDataText;
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 8;
		gridLayout.marginRight = 20;
		gridLayout.marginBottom = 20;
		//gridLayout.makeColumnsEqualWidth = true;
		setLayout(gridLayout);
		
		gridDataLabel = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
        gridDataLabel.horizontalSpan = 2;
//        gridDataLabel.horizontalIndent = 10;
//        gridDataLabel.verticalIndent = 10;
        gridDataLabel.grabExcessHorizontalSpace = true;
		
        
        gridDataText = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridDataText.horizontalSpan = 6;
//        gridData.horizontalIndent = 10;
//        gridDataText.verticalIndent = 10;
        gridDataText.grabExcessHorizontalSpace = true;
		
		nameLabel = new Label(this, SWT.NULL);
		nameLabel.setText(NAME_PERSON_LABLE_NAME);
        nameLabel.setLayoutData(gridDataLabel);
        
        nameText = new Text(this, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
        nameText.setLayoutData(gridDataText);
		
        groupLabel = new Label(this, SWT.NULL);
        groupLabel.setText(GROUP_PERSON_LABLE_NAME);
        groupLabel.setLayoutData(gridDataLabel);
        
        groupText = new Text(this, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
        groupText.setLayoutData(gridDataText);
        
        
        taskDoneLabel = new Label(this, SWT.NULL);
        taskDoneLabel.setText(TASK_DONE_LABLE_NAME);
        taskDoneLabel.setLayoutData(gridDataLabel);
        
        taskDoneCheckBox = new Button(this, SWT.CHECK | SWT.RIGHT_TO_LEFT);
        taskDoneCheckBox.setLayoutData(gridDataText);
        
        initButtons();
        
//        pack();
        
	}

}