package com.as.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForPropertyFileException extends InvalidFilePathException {

	public InvalidPathForPropertyFileException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidPathForPropertyFileException(String message) {
		super(message);
		
	}

}
