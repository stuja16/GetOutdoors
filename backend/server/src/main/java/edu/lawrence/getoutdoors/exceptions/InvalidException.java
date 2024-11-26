package edu.lawrence.getoutdoors.exceptions;

public class InvalidException extends FFAPIException{
	
	public static final long serialVersionUID = 1L;
	
	public InvalidException() {
		super("Attempt to insert invalid element");
	}
	
	public InvalidException(String... messages) {
		super(messages);
	}
	
}