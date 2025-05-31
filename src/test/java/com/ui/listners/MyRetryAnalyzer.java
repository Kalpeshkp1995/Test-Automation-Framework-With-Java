package com.ui.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

//	private static final int MAX_NUMBER_OF_ATTEMPT=Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTEMPT"));
	private static final int MAX_NUMBER_OF_ATTEMPT= JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPT();
	
	private static int currentAttempt=1;
	@Override
	public boolean retry(ITestResult result) {
	if(currentAttempt<=MAX_NUMBER_OF_ATTEMPT) {
		currentAttempt++;
		return true;
	}
		return false;
	}

}
