package com.cs.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.cs.utils.ScreenshotUtils;

public class ExtentLogger {
	private ExtentLogger() {}
	
	public static void pass(String message) {
		ExtentManager.getExtentText().pass(message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
		} 
	
	public static void fail(String message) {
		ExtentManager.getExtentText().fail(message, MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.getScreenShot()).build());
	}
	
	public static void info(String message) {
		ExtentManager.getExtentText().info(message, MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.getScreenShot()).build());
	}
}
