package com.cursomc.resources.exeptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {


	private static final long serialVersionUID = 1L;
	
	List<FieldMessage> list = new ArrayList<FieldMessage>();

	public ValidationError(Integer status, String msg, long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return list;
	}

	public void addError(String fieldName, String message) {
	
		list.add(new FieldMessage(fieldName, message));
	}

}
