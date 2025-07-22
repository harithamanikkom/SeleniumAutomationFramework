package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	private static ExtentTest test;
	

	public static ExtentReports getReportInstance() {

		if (extent == null) {
			String timestamp = new SimpleDateFormat("YYYY-MM-DD_HH-MM-SS").format(new Date());
			String reportpath = "reports/ExtentReport_" + "timestamp" + ".html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("Test Execution Report");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}

	public static ExtentTest createTest(String testname) {

		test = getReportInstance().createTest(testname);
		return test;
	}
}
