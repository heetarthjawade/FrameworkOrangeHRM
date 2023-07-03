package com.cs.utils;

import static com.cs.ReadProperties.ReadProperties.prop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.enums.WaitTypes;
import com.cs.reports.ExtentLogger;

import DriverManager.DriverManager;

public class SeleniumUtils {
	
	private static WebDriverWait waitUntilElementPresent() {
	  WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
	  return wait;
	}
	
	private static WebElement getElement(By by, WaitTypes waitType, WebElement element) {
		if(waitType == WaitTypes.PRESENCE)
			element = waitUntilElementPresent().until(ExpectedConditions.presenceOfElementLocated(by));
		else if(waitType == WaitTypes.VISIBLE)
			element = waitUntilElementPresent().until(ExpectedConditions.visibilityOfElementLocated(by));
		else if(waitType == WaitTypes.CLICKABLE)
			element = waitUntilElementPresent().until(ExpectedConditions.elementToBeClickable(by));
		return element;
	}
	
	public static void click(By by, String elementName) {
		WebElement element = null;
		element = waitUntilElementPresent().until(ExpectedConditions.elementToBeClickable(by));
		element.click();
		ExtentLogger.pass(elementName + "Clicked Successfully");
	}
	
	public static void click(By by, WaitTypes waitType, String elementName) {
		WebElement element = null;
	    element = getElement(by, waitType, element);
	    
	    element.click();
	    ExtentLogger.pass(elementName + " Clicked Successfully");
	}

	public static void sendKeys(By by,String value , WaitTypes waitType, String elementName) {
		WebElement element = null;
		element = getElement(by, waitType, element);
		
		element = waitUntilElementPresent().until(ExpectedConditions.presenceOfElementLocated(by));
		element.sendKeys(value);
		ExtentLogger.pass(value + " entered Successfully in " + elementName);
	}
	
	public static void sendKeys(By by, String value, String elementName)
	{
		WebElement element = null;
		element = waitUntilElementPresent().until(ExpectedConditions.presenceOfElementLocated(by));

		element.sendKeys(value);
		ExtentLogger.pass(value + " entered successfully in " + elementName);
	}
	
	
}
