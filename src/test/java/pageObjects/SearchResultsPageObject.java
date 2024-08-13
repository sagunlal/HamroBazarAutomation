package pageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPageObject extends BasePage {
	
	public SearchResultsPageObject(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = "//div[contains(@class,'search--titles')]/h3/strong")
	WebElement searchQueryString;
	
	@FindBy(xpath = "//div[contains(@class,'search--titles')]/h3/small")
	WebElement searchResultResultsCount;
	
	@FindBy(xpath = "//div[contains(@class,'filter--form')]/div[contains(@class,'filter--box')]//h4")
	WebElement addFilterHeader;
	
	@FindBy(xpath = "(//label[contains(text(),'Location')]/../div/input)[2]")
	WebElement LocationDynamicDropdown;
	
	@FindBy(xpath = "(//div[contains(@class,'rs-slider-bar')])[2]")
	WebElement SliderBar;
	
	@FindBy(xpath = "(//div[contains(@class,'rs-slider-handle')])[2]")
	WebElement SliderHandle;
	
	@FindBy(xpath = "(//button[contains(@class,'btn')])[2]")
	WebElement FilterButton;
	
	@FindBy(xpath = "(//select[@class='input' and @name='sortParam'])[2]")
	WebElement SortDropdown;
	
	public void SelectLocationDropdownOptionbyText(String text) {
        String xpath = "//*[contains(text(), '" + text + "')]";
        driver.findElement(By.xpath(xpath)).click();
    }
	
	public void MoveSlider(int changevalue) {
		// Execute JavaScript to interact with the slider
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Execute JavaScript to set the slider value
	    js.executeScript("document.querySelector('.rs-slider-bar').value = arguments[0]", changevalue);

	    // Trigger input event to update the slider position
	    js.executeScript("document.querySelector('.rs-slider-bar').dispatchEvent(new Event('input'));");
	}
    
	public String GetSearchQueryTest() {
		return searchQueryString.getText();
	}
	
	public int GetSearchResultsCount() {
		String number = "0";
		String resultString = searchResultResultsCount.getText();
        String regex = "\\((\\d+) total results\\)";

        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(resultString);

        if (matcher.find()) {
            number = matcher.group(1);
        	}	
        return Integer.parseInt(number);
		}
	
	public void SendTextToLocation(String text) {
		LocationDynamicDropdown.clear();
		LocationDynamicDropdown.sendKeys(text);
	}
	
	public void SortbyText(String text) {
		Select dropdown = new Select(SortDropdown);
		dropdown.selectByVisibleText(text);
	}
	
	
}
