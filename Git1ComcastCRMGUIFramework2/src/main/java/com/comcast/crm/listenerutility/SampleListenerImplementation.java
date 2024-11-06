package com.comcast.crm.listenerutility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleListenerImplementation implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart method implementation of ISuiteListener");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish method implementation of ISuiteListener");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart method implementation of ITestListener");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess method implementation of ITestListener");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure method implementation of ITestListener");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped method implementation of ITestListener");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage method implementation of ITestListener");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout method implementation of ITestListener");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart method implementation of ITestListener");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish method implementation of ITestListener");
	}

	
}
