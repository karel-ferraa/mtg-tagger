package org.tagger.entities.exceptions;

public class NonExistentTagException extends Exception { 
	public NonExistentTagException(String errorMessage) {
		super(errorMessage);
	}
	public NonExistentTagException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
