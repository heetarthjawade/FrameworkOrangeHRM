package dataProvidersHelpingAttributes;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	@Test(dataProvider = "DP")
	public  void verifyLogin(HashMap<String, String> loginDetails){
		
			System.out.println("userName :"+loginDetails.get("username") + "Password: "+ loginDetails.get("password") );
		}
	
	
	
	@DataProvider(name = "DP")
	public Object[] getData() {
		Object[] data = new Object [3];
		
		Map<String,  String> map = new HashMap<>();
		map.put("username", "Virat@123");
		map.put("password", "Virat@123");
		data[0] = map;
		
		Map<String,  String> map1 = new HashMap<>();
		map1.put("username", "Rohit");
		map1.put("password", "Rohit@456");
		data[1] = map1;
		
		Map<String,  String> map2 = new HashMap<>();
		map2.put("username", "Jadega");
		map2.put("password", "Jaddu@123");
		data[2] = map2;
		
		return data;
	}
	

}
