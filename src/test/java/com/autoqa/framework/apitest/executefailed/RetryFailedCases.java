package com.autoqa.framework.apitest.executefailed;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedCases implements IRetryAnalyzer{
	private int counter=1, retryMax = 2;
	
	public boolean retry(ITestResult result) {
		if(counter<=retryMax){
			counter++;
			return true;
		}
		return false;
	}

}
