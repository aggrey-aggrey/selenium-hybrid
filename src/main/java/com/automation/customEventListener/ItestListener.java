package com.automation.customEventListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.automation.testBase.TestBase;

public class ItestListener extends TestBase implements ITestListener {
	private static final Logger log = LogManager.getLogger(ItestListener.class.getName());

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
		log.info("These methosds will be executed in this test tag:");
		for (ITestNGMethod method : methods) {
			log.info(method.getMethodName());
		}

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO will execute after <test> tag of testng.xml file
		log.info("OnFinish -> Test Tag Name: " + context.getName());

	}

}
