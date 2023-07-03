package actitimeTestting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPageActitime {

	WebDriver driver;

	public LoginPageActitime(WebDriver driver) {
		this.driver = driver;
	}

	private By username = By.name("username");
	private By password = By.name("pwd");
	private By loginButton = By.id("loginButton");
	private By errorMsg = By.xpath("//span[contains(text(),'Username')]");

	private WebElement getWebElement(By by) {
		return driver.findElement(by);
	}

	private void typeUsername(String value, By by) {
		getWebElement(by).sendKeys(value);
	}

	private void typePassword(String value, By by) {
		getWebElement(by).sendKeys(value);
	}

	private void clickOnLogin(By by) {
		getWebElement(by).click();
	}

	private String getActualText(By by) {
		return getWebElement(by).getText();
	}
	
	private String getActualUrl() {
		return driver.getCurrentUrl();
	}

	public void verifyLoginFunctionality(String username, String password) {
		typeUsername(username, this.username);
		typePassword(password, this.password);
		clickOnLogin(this.loginButton);
	}

	public void verifyActualUrl(String expUrl) {
		String actUrl = getActualUrl();
		Assert.assertEquals(actUrl, expUrl, "expUrl :- " + expUrl + " does not match with actual Url:-" + actUrl);
	}
	
	public void verifyLoginMsg(String expMsg) {
		String actMsg = getActualText(errorMsg);
		Assert.assertEquals(actMsg, expMsg,"expMsg :- "+expMsg+" does not match with actual Msg :-"+actMsg);
	}

}
