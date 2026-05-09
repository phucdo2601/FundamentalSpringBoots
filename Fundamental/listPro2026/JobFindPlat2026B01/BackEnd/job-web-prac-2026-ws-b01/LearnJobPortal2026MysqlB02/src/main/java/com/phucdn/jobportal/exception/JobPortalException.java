package com.phucdn.jobportal.exception;

import java.io.Serializable;

public class JobPortalException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public JobPortalException(String message) {
		super(message);
	}
	

}
