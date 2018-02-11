package com.automation.customEventListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener {
	private static final Logger log = LogManager.getLogger(InvokedMethodListener.class.getName());

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
