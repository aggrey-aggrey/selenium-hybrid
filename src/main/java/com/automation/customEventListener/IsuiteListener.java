package com.automation.customEventListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class IsuiteListener implements ISuiteListener {

	private static final Logger log = LogManager.getLogger(IsuiteListener.class.getName());

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

}
