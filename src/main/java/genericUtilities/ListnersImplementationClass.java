package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * This class provide implementation to ITestListner interface of testNG
 * @author dewesh
 *
 */
public class ListnersImplementationClass implements ITestListener
{

	public void onTestStart(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"=========Test execution started=========");
	}

	public void onTestSuccess(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"=========Passed=========");

	}

	public void onTestFailure(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"=========Failled=========");

		//Exception for Failure

		String screenShotName = testScriptName+new JavaUtilies().getSystemDate();
		System.out.println(result.getThrowable());
		WebDriverUtility w = new WebDriverUtility();
		try {
			w.captureScreenShot(BaseClass.Sdriver, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"=========Skipped=========");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("==== Suite Execution Started ====");
	}

	public void onFinish(ITestContext context) {
		System.out.println("==== Suite Execution Finished ====");
	}

}
