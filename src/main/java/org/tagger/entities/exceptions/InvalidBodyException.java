package org.tagger.entities.exceptions;

public class InvalidBodyException extends Exception { 
	public InvalidBodyException(String errorMessage) {
		super(errorMessage);
	}
	public InvalidBodyException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
