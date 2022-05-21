package com.EX;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryConditions implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult arg0) {
		int min = 0, max = 5;
		if (min < max) {
			min++;
			return true;
		}

		return false;
	}

}
