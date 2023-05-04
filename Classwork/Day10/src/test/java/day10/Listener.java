package day10;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	 System.out.println("onFinish "+context);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 System.out.println("onStart "+context);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("onTestFailedButWithinSuccessPercentage "+result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("onTestFailedButWithinSuccessPercentage "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("onTestFailure "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("onTestSkipped "+result.getName());
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("onTestStart "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("onTestSuccess "+result.getName());
	}

}
