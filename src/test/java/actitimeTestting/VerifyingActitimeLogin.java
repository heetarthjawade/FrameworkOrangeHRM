package actitimeTestting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyingActitimeLogin {
	WebDriver driver;
	private By username = By.id("username") ;
	private By password = By.name("pwd");
	private By loginBtn = By.id("loginButton");
	private By errorMsg = By.xpath("//div[@id='ServerSideErrorMessage']//span");
	
	public VerifyingActitimeLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getWebElement(By by) {
		return driver.findElement(by);
	}
	
	public void typeUserName(By by, String value) {
		getWebElement(by).sendKeys(value);
	}
	
	public void typePassword(By by,String value) {
		getWebElement(by).sendKeys(value);
	}
	
	public void clickLoginBtn(By by) {
		getWebElement(by).click();
	}
	
	public String getActErrorMsg(By by) {
		return getWebElement(by).getText();
	}
	
	public String getActUrl() {
		return driver.getCurrentUrl();
	}
	
	public void verifyingLoginFunt(String username, String password ) {
		typeUserName(this.username,  username);
		typePassword(this.password, password);
		clickLoginBtn(this.loginBtn);
	}
	
	public void verfyingActUrl(String expUrl) {
		String actUrl = getActUrl();
		Assert.assertEquals(expUrl, actUrl, "ExpectedUrl doesn't matches with ActUrl===>"+ actUrl);
	}
	public void verifyingErrorMsg(String expErrorMsg) {
		String actErroMsg = getActErrorMsg(errorMsg);
		Assert.assertEquals(expErrorMsg, actErroMsg);
	}
	

}
