package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports e;

	public static ExtentReports reporter() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		esr.config().setReportName("Automation Results");
		esr.config().setDocumentTitle("Test Results");
		e = new ExtentReports();
		e.attachReporter(esr);
		return e;

	}

}
