package actions.reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;
    private WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        String reportFileName = "ExtentReport.html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finishing test execution, flushing ExtentReports.");
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getMethod().getMethodName());
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Test failed: " + result.getThrowable()); // Log failure details
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
        test.log(Status.SKIP, "Test skipped");
    }

}
