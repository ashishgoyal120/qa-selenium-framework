package org.selenium.utils;

import static org.selenium.constants.FrameworkConstants.EXTENT_REPORT_FOLDER_PATH;
import static org.selenium.constants.FrameworkConstants.Zipped_ExtentReports_Folder_Name;

import java.io.File;

import org.zeroturnaround.zip.ZipUtil;

public class ZipUtils {
	
	public static void zip() {
		ZipUtil.pack(new File(EXTENT_REPORT_FOLDER_PATH),
				new File(Zipped_ExtentReports_Folder_Name));

		System.out.println("Zipped ExtentReports folder successfuly");
	}

}
