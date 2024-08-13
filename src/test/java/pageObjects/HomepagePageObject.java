package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepagePageObject extends BasePage {
	
	public HomepagePageObject(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath =  "//div[contains(@class,'nav-searchbar-input')]/input")
	WebElement searchBarInput;
	
	@FindBy(xpath =  "//div[contains(@class,'nav-searchbar-input')]/button")
	WebElement searchBarButton;
	
	public void sendSearchvalue(String searchvalue) {
		searchBarInput.clear();
		searchBarInput.sendKeys(searchvalue);
	}
	
	public void clickSearchBarButton() {
		searchBarButton.click();
	}
	

}