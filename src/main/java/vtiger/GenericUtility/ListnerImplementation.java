package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements  ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName); //test is created which will initiate the individual test
		
		//Reporter.log(methodName+" => Test Script execution Started",true);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" ---> passed");
		
		//Reporter.log(methodName+" => is Passed.",true);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		//This will capture the exception occured
		//String msg = result.getThrowable().toString();
		
		//This will capture the current test method name
		String methodName = result.getMethod().getMethodName();
		
		//This will append method name with date for screenshot name
		String screenShotName = methodName+"-"+jLib.getSystemDateInFormat();
		
		//This will log in report and console	
		test.log(Status.FAIL, methodName+" ---> Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		//Reporter.log(methodName+" => is Failed because = > "+msg, true);
		
		//This will capture the screenshot and provide the screenshot name and save it in folder screenshots
		try {
			String path = wLib.takeScreenShoot(BaseClass.sdriver, screenShotName);
			
			test.addScreenCaptureFromPath(path);//Navigate to screenshot path and attach it t the report
			
			//wLib.takeScreenShoot(BaseClass.sdriver, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" ---> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		//Reporter.log(methodName+" => is Skipped because = > "+msg, true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Start of suite execution 
		/*confidgure the extent reports */                          // inside ExtentReports - Report-06 sep 2022 10-38-41.html
		ExtentSparkReporter htmlReport =  new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-sVtiger Execute Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Vtiger Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-Platform", "Windows");
		report.setSystemInfo("Base-URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Rahul");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//End suite execution
		report.flush();
	}

	

}
