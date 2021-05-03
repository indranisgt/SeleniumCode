package SeleniumPracticeProject.QAClick;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;

import Resources.Base;
import Resources.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	public WebDriver driver;
	ExtentTest t;
	ExtentReports er = ExtentReporter.reporter();
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		t = er.createTest(result.getMethod().getMethodName());
		tl.set(t);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS, "Test Passed");
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name = result.getMethod().getMethodName();
		try {
			captureScreenshot(name, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		er.flush();
	}

}
