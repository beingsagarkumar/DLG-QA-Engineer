package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportUtil {

	public static void extentReports() {
		ExtentReports reports = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		ExtentTest test = reports.startTest("TestName");
		// Reporting feature to be implemented
	}
}
