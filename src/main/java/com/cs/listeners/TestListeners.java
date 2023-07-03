package com.cs.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cs.annotations.FrameworkAnnotations;
import com.cs.reports.ExtentLogger;
import com.cs.reports.ExtentReport;

public class TestListeners implements ITestListener {
	
	@Override
	public void  onTestStart(ITestResult result) {
		
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
		
		ExtentReport.assignCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() +" is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getName() + " is Failed");
		ExtentLogger.fail(result.getThrowable().getMessage());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}
	
	public void onStart(ITestContext context) 
	{
		ExtentReport.initReports();
	}
	
	public void onFinish(ITestContext context) {
		ExtentReport.flushReport();
	}
	
}