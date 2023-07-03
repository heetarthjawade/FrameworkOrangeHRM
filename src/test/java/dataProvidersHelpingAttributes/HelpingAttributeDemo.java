package dataProvidersHelpingAttributes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class HelpingAttributeDemo {
	@Test(invocationCount = 5, enabled = false)
	public void verfiyLogin() {
		System.out.println("userName: "+ new Faker().name().username());
	}
	
	@Test(enabled = true)
	public void test1() {
		Assert.fail("Intentionally Failing test");
		System.out.println("I am in Test 1");
	}
	
	@Test(dependsOnMethods = {"test1"}, alwaysRun = true, enabled = true )
	public void test2() {
		System.out.println("I am in Test 2222");
	}
	
	
	
	

}
