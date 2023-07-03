package firstTestng;

import org.testng.annotations.Test;

public class TestNgDemo3 {
	@Test(priority = 1)
	public void reg() {
		System.out.println("User Registration..");
		//Assert.fail("Intentionally failing :Reg");
	}
		
		@Test(priority = 2,  dependsOnMethods = {"reg"} )
		public void login() {
			System.out.println("User logged in...");
			//Assert.fail("Intentionally failing logged in...");
		}
		
		@Test(priority = 3, dependsOnMethods = {"reg"})
		public void logOut() {
			System.out.println("User logged Out...");
		}
		
	}


