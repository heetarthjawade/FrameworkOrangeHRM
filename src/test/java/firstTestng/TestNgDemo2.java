package firstTestng;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNgDemo2 {
	@Test(priority = 4)
	public void timePass() {
			System.out.println("User is so Free and he is killing it's time...");
	}
	
	@Test(priority = 1)
	public void reg() {
		System.out.println("User registered..");
	}
	
	@Test(priority = 2)
	public void login() {
		System.out.println("User logged in");
	}
	
	@Test(priority = 3)
	public void logout() {
		System.out.println("User logged out...");
		throw new SkipException("Intentionaly skiping the step");
	}

}
