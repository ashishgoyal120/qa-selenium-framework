package org.selenium.utils;

import static org.selenium.constants.FrameworkConstants.*;

public final class ReportPathUtils {
	
	private ReportPathUtils() {};
	
	public static String createExtentReportPath() {
		if (ConfigLoader.getInstance().getOverrideReports().equalsIgnoreCase(NO)) {
			return EXTENT_REPORT_FOLDER_PATH + OSInfoUtils.getOSInfo() + "_" + DateUtils.getCurrentDate() + "_"
					+ EXTENT_REPORT_NAME;

		} else {
			return EXTENT_REPORT_FOLDER_PATH + EXTENT_REPORT_NAME;
		}
	}

}
