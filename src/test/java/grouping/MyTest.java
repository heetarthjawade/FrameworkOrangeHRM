package grouping;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class MyTest {
	@Test
	public void test1() {
		System.out.println("test1 : is getting executed ");
		Assert.assertTrue(true);
	}
	public void test2() {
		System.out.println("test2 : is getting executed ");
		Assert.fail();
	}
	public void test3() {
		System.out.println("test3 : is getting executed ");
		throw new SkipException("Intentionally skipping test script");
	}
	public void test4() {
		System.out.println("tes4 : is getting executed ");
		Assert.assertTrue(true);	
	}

}
