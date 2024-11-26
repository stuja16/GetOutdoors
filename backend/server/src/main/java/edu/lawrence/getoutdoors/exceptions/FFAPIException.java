package edu.lawrence.getoutdoors.exceptions;

public class FFAPIException extends Exception{
	
	static final long serialVersionUID = 1L;
	
	/**
	 * Constructs an FFAPIException, which extends the standard Exception
	 * @param messages the messages to be passed to the detail message of the Exception
	 */
	public FFAPIException(String[] messages) {
		super(ArrayFormat(messages));
	}
	
	/**
	 * Constructs and FFAPIException, which extends the standard Exception
	 * @param firstMessage the first message to be passed to the detail message of the Exception
	 * @param followMessages the followup message(s) to be passed to the detail message of the Exception
	 */
	public FFAPIException(String firstMessage, String... followMessages) {
		super(FrontCatArrayFormat(firstMessage, followMessages));
	}
	
	private static String ArrayFormat(String[] messages) {
		String ret = "";
		
		for (int i = 0; i < messages.length; i++)
			ret += "\n" + messages[i];
		
		return ret;
	}

	private static String FrontCatArrayFormat(String front, String[] back) {
		String ret = front;
		
		for(int i = 0; i < back.length; i++)
			ret += "\n" + back[i];
		
		return ret;
	}
	
}