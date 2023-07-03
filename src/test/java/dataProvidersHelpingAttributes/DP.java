package dataProvidersHelpingAttributes;

import org.testng.annotations.DataProvider;

public class DP {
	@DataProvider(name = "Dp1")
	public Object[][] getData1() {
		Object[][] data = {{"ShahRukh", "Shah@Khan"},
						   {"Salman", "SalMon@Bhai"}
								};
		return data;
	}
	
	@DataProvider(name = "Dp2")
	public Object[][] getData2() {
		Object[][] data = {{"Hritik", "Hritik@123"},
						   {"Kartik", "Kartik@456"}
								};
		return data;
	}

}
