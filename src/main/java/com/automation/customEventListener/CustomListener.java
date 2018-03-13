package com.automation.customEventListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener implements ISuiteListener, ITestListener, IInvokedMethodListener {

	private static final Logger log = LogManager.getLogger(CustomListener.class.getName());

	@Override
	public void onStart(ISuite suite) {
		// TODO When <suite> tag starts
		log.info("OnStart: before suite startes " + suite.getName());

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO when <suite> tag completes
		log.info("OnFinish: before suite startes " + suite.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO when test method starts
		log.info("OnTestStart -> Test Name: " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO If test method is successful
		log.info("OnTestSuccess -> Test Name: " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO If test method has failed
		log.info("OnTestFailure -> Test Name: " + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO If test method is skipped
		log.info("OnTestSkipped -> Test Name: " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO will execute before <test> tag of testng.xml file
		log.info("OnStart -> Test  Tag Name: " + context.getName());
		ITestNGMethod methods[] = context.getAllTestMethods();
		log.info("These methods will be executed in this test tag:");
		for (ITestNGMethod method : methods) {
			log.info(method.getMethodName());
		}

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO will execute after <test> tag of testng.xml file
		log.info("OnFinish -> Test Tag Name: " + context.getName());

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// Run before every method in the Test class
		log.info("before invocation: " + testResult.getTestClass().getName() + "=>"
				+ method.getTestMethod().getMethodName());

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// Run after every method in the Test class
		log.info("after invocation: " + testResult.getTestClass().getName() + "=>"
				+ method.getTestMethod().getMethodName());

	}

}
