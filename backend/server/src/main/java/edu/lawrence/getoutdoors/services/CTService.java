package edu.lawrence.getoutdoors.services;

// Java-level includes [Utility Exceptions]
import java.util.regex.PatternSyntaxException;

// Java-level includes [Time Exceptions]
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.DateTimeException;

// Java-level includes [Time]
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.ZoneId;

public class CTService {
	
	/**
	 * time format examples: 
	 * 12:04 PM, 5/21/2024 CST
	 * 11:59 AM, 5/16/2024 PST
	 * 8:45 PM, 6/03/2024 UCT
	 * 
	 * leading zeros in front of hour will be removed automatically
	 */
	private static final String regexPattern = "^\\d{1,2}:\\d{2} [A-Z]{2}, \\d{1,2}/\\d{2}/\\d{4} [A-Z]{1,3}$";
	private static final String pattern = "h:mm a, M/dd/uuuu z";
	 private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	
	/**
	 * Formats a java.time.Instant into a String (h:mm a, M/dd/yyyy z), assumes UTC timezone
	 * @param time the Instant object to convert
	 * @return the formatted String version of the instant, formatted UTC EPOCH on failure
	 */
	static public String instToStr(Instant time) {
		
		String ret = strictFormat_Intern(Instant.EPOCH, null);
		
		try {
			ret = strictFormat_Intern(time, null);
		}catch (DateTimeException e) {}
		
		return ret;
	}
	
	/**
	 * Formats a java.time.Instant into a String of format (h:mm a, M/dd/yyyy z)
	 * @param time time the Instant object to convert
	 * @param zone the specified timezone to display in the String
	 * @return the formatted String version of the instant, formatted zone-adjusted EPOCH on failure
	 */
	static public String instToStr(Instant time, String zone) {
		
		String ret = strictFormat_Intern(Instant.EPOCH, zone);
		
		try{
			ret = strictFormat_Intern(time, zone);
		} catch (DateTimeException e) {}
		
		return ret;
	}
	
	/**
	 * Parses a formatted String into a java.time.Instant, formats to UTC timezone
	 * @param time the formatted String representation of time (h:mm a, M/dd/yyyy z)
	 * @return the parsed Instant object, UTC EPOCH on failure
	 */
	static public Instant strToInst(String time) {

		Instant ret = Instant.EPOCH;
		
		if (!checkShape_Intern(time))
			return ret;
		
		try {
			ret = strictParse_Intern(time, null);
		} catch (DateTimeParseException e) {}
		
		return ret;
	}
	
	/**
	 * Parses a formatted String into a java.time.Instant, formats to specified timezone
	 * @param time the formatted String representation of time (h:mm a, M/dd/yyyy z)
	 * @param zone the specified zone abbreviation (UTC, CST, PST, etc.)
	 * @return the parsed Instant object, zone-adjusted EPOCH on failure
	 */
	static public Instant strToInst(String time, String zone) {
		
		Instant ret = Instant.from(
				Instant.EPOCH.atZone(zoneOf_Intern(zone)));
		
		if (!checkShape_Intern(time))
			return ret;
		
		try {
			ret = strictParse_Intern(time, zone);
		} catch (DateTimeParseException e) {}
		
		return ret;
	}

	/**
	 * Checks to see if formatted String timestamp is valid in both format and content
	 * @param time the input String timestamp to check
	 * @return 
	 */
	static public boolean validateFormattedInput(String time) {

		boolean status = checkShape_Intern(time) && 
				!Instant.EPOCH.equals(strictParse_Intern(time, null));
			
		return status;
	}
	
	/**
	 * Checks if input string is of correct format, for internal use
	 * @param time input formatted String time
	 * @return
	 */
	static private boolean checkShape_Intern(String time) {
		
		boolean status = false;
		
		try {
			status = time.matches(regexPattern);
		} catch (PatternSyntaxException e) {
			e.printStackTrace(); // regexPattern is malformed
		}
		
		return status;
	}
	
	/**
	 * Strictly parses an input String to Instant, for internal use
	 * @param time formatted String time to be strictly parsed
	 * @param zone 1-3 character String code for time zone, pass null for UTC
	 * @return parsed Instant object, zone-adjusted EPOCH on failure
	 */
	static private Instant strictParse_Intern(String time, String zone) {
		
		DateTimeFormatter strictFormatter = formatter
				.withResolverStyle(ResolverStyle.STRICT)
				.withZone(zoneOf_Intern(zone));
		
		Instant ret = Instant.from(
				Instant.EPOCH.atZone(zoneOf_Intern(zone)));

		try {
			ret = Instant.from(strictFormatter.parse(time));
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		} catch (DateTimeException e) {
			e.printStackTrace();
		}
			
		return ret;
	}
	
	/**
	 * Strictly formats an input Instant to a String, for internal use
	 * @param time the Instant to format to a string
	 * @param zone the 1-3 character String code for the time zone, pass null for UTC
	 * @return the formatted String, formatted zone-adjusted EPOCH on failure
	 */
	static private String strictFormat_Intern(Instant time, String zone) {
		
		DateTimeFormatter strictFormatter = formatter
				.withResolverStyle(ResolverStyle.STRICT)
				.withZone(zoneOf_Intern(zone));

		String ret = strictFormatter.format(Instant.EPOCH);
		
		try {
			ret = strictFormatter.format(time);
		} catch (DateTimeException e) {}
			
		return ret;
	}
	
	/**
	 * Get's the ZoneId for a given 1-3 character time zone Code, for internal use
	 * @param zone the 1-3 character time zone code, pass null for UTC
	 * @return the ZoneId object, UTC on failure
	 */
	static private ZoneId zoneOf_Intern(String zone) {
		ZoneId ret = ZoneId.of("UTC");
		
		if (zone != null)
			try {
				ret = ZoneId.of(zone, ZoneId.SHORT_IDS);
			} catch (DateTimeException e) {}
		
		return ret;
	}
	
}