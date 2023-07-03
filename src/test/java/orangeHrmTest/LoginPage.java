package orangeHrmTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	private By username = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWebElement(By by) {
		return driver.findElement(by);
	}
	
	public void typeUserName(By by, String value) {
	 getWebElement(by).sendKeys(value);
	}
	
	public void typePassword(By by, String value) {
		getWebElement(by).sendKeys(value);
	}
	
	public void clickLoginBtn(By by) {
		getWebElement(by).click();
	}
	
	public void login(String username, String password) {
		typeUserName(this.username, username);
		typePassword(this.password, password);
		clickLoginBtn(loginBtn);
		
	}
	
	public void verifyLoginUrl(String expLoginUrl) {
	String actLoginUrl = driver.getCurrentUrl();
	Assert.assertEquals(expLoginUrl, actLoginUrl);
	}
	
	public void verifyLoginHeader(String expHeaderText) {
		String actHeaderText = driver.findElement(By.xpath("//h5")).getText();
		Assert.assertEquals(expHeaderText, actHeaderText);
	}
	
	public void verifyDashboardText(String expText) {
		String actText = driver.findElement(By.xpath("//h6")).getText();
		Assert.assertEquals(expText, actText);
	}
	

}
