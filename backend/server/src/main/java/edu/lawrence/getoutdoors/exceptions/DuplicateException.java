package edu.lawrence.getoutdoors.exceptions;

public class DuplicateException extends FFAPIException {
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateException() {
		super("Attempt to insert duplicate element");
	}
	
	public DuplicateException(String... messages) {
		super(messages);
	}
	
}