package edu.lawrence.getoutdoors.exceptions;

public class NoContentException extends FFAPIException{
	
	public static final long serialVersionUID = 1L;
	
	public NoContentException() {
		super("No content to display from this request");
	}
	
}