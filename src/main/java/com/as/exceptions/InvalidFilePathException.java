package com.as.exceptions;

@SuppressWarnings("serial")
public class InvalidFilePathException extends FrameworkExceptions{

	public InvalidFilePathException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidFilePathException(String message) {
		super(message);
		
	}

}
