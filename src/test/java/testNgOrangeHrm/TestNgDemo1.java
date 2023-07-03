package testNgOrangeHrm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNgDemo1 {
	@Test(dataProvider = "getData")
	public void validateLogin(String username, String password) {
		System.out.println("Validating login Page");
		System.out.println("UserName ==>"+ username+" Password==> "+ password);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[4][2];
		data[0][0] = "Virat";
		data[0][1] = "Virat123";
		
		data[1][0] = "Sikhar";
		data[1][1] = "Sikhar456";
		
		data[2][0] = "Harbhajan";
		data[2][1] = "Harbhajan789";
		
		data[3][0] = "Rohit";
		data[3][1] = "rohit123";
		
		return data;
	}

}
