package DriverManager;

import org.openqa.selenium.WebDriver;

public class DriverManager {
private DriverManager() {};
	
    //public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	private final static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	
    public static void setDriver(WebDriver driver)
    {
    	dr.set(driver); // thread
    }
    
    public static WebDriver getDriver()
    {
    	return dr.get();
    }

}
