package com.as.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForExcelException extends InvalidFilePathException {

	public InvalidPathForExcelException(String message) {
		super(message);
		
	}

	public InvalidPathForExcelException(String message, Throwable cause) {
		super(message, cause);
		
	}

}
