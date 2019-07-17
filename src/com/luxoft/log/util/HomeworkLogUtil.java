package com.luxoft.log.util;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class HomeworkLogUtil {
	
	static public int display(Shell shell, int style, String title, String msg) {
		MessageBox messageBox = new MessageBox(shell, style);
		messageBox.setText(title);
		messageBox.setMessage(msg);
		return messageBox.open();
	}
	
}
