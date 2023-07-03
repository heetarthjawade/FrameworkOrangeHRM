package com.cs.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private final static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();
	
	public static void setExtentTest(ExtentTest extentTest) {
		threadLocal.set(extentTest);
	}
	
	public static ExtentTest getExtentText() {
		return threadLocal.get();
	}

	
}
