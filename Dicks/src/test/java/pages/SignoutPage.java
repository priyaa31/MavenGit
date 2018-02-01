package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignoutPage
{
	WebDriver driver;

	public SignoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign Out')]")
	private WebElement SignOut;
	
	public void clickSignOut()
	{
		SignOut.click();
	}

}
