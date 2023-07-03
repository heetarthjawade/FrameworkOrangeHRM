package dataProvidersHelpingAttributes;

import org.testng.annotations.Test;

public class DataProviderDemo2 {
	@Test(dataProvider = "Dp2",  dataProviderClass = DP.class)
	public void verifyLogin(String userName, String password) {
		System.out.println("userName: "+ userName+ " password: "+ password);
	}

}
