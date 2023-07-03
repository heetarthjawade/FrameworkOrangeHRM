package Pages;

import org.openqa.selenium.By;

import DriverManager.DriverManager;

public class LoginPage {
	// locators 
	private final static By TXT_USERNAME = By.name("username");
	private final static By TXT_PASSWORD = By.name("password");
	private final static By BTN_LOGIN    = By.xpath("//button[@type='submit']");
	
	
	// methods 
	private void setUserName(String userName)
	{
		DriverManager.getDriver().findElement(TXT_USERNAME).sendKeys(userName);
	}
	private void setPassword(String password)
	{
		DriverManager.getDriver().findElement(TXT_PASSWORD).sendKeys(password);
	}
	private void clickLoginBtn()
	{
		DriverManager.getDriver().findElement(BTN_LOGIN).click();
	}
	
	public HomePage loginAppl(String userName,String password)
	{
		setUserName(userName);
		setPassword(password);
		clickLoginBtn();
		return new HomePage();
	}

}
