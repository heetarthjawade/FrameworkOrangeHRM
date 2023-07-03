package firstTestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo4 {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("In the BeforeSuite method");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("In AfterSuite method");
	}
	
	@BeforeClass()
	public void beforeClass() {
		System.out.println("Inside BeforeClass method");
	}
	
	@AfterClass()
	public void afterClass() {
		System.out.println("Inside AfterClass method");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside AFter method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Insode Before Test method..");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Inside After Test Method..");
	}
	
	
	
	@Test(priority = 1)
	public void reg() {
		System.out.println("User Registered");
	}
	
	@Test(priority = 2)
	public void login() {
		System.out.println("User Logged in");
	}
	
	@Test(priority = 3)
	public void logout() {
		System.out.println("User logged Out");
	}

}
