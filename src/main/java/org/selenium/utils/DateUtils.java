package org.selenium.utils;

import java.util.Date;

public final class DateUtils {
	
	 private DateUtils() {
	    }

	    public static String getCurrentDate() {
	        Date date = new Date();
	        return date.toString().replace(":", "_").replace(" ", "_");
	    }

}
