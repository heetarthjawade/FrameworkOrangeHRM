package grouping;

import org.testng.annotations.Test;

public class GroupsDemo {
	@Test(groups = {"cars"} )
	public void testBMW(String browser, String env, String rcs) {
		System.out.println("brower name : "+ browser);
		System.out.println("environment : "+ env);
		System.out.println("response code : "+ rcs);
	String[] rc = rcs.split(",");
		for(String s : rc) 
			System.out.println(Integer.parseInt(s) + 100);
		
			System.out.println("BMW method");
	}
	
	@Test(groups = {"cars"})
	public void testBenz() {
		System.out.println("Benz Method");
	}
	
	@Test(groups = {"cars","bikes"})
	public void testHonda() {
		System.out.println("Honda method..");
	}
	
	@Test(groups = {"bikes"})
	public void testYamaha() {
		System.out.println("Yamaha method..");
	}
	
	@Test(groups = {"bikes"})
	public void testBajaj() {
		System.out.println("Bajaj method");
	}
}
