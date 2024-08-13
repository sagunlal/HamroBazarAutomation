package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomepagePageObject;

public class TC_HamroBazar {
	
	public WebDriver driver;
	
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");
        options.addArguments("--acceptInsecureCerts");
		
        
        

		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://hamrobazaar.com/");
		Thread.sleep(Duration.ofSeconds(5));
		// Create Actions instance
		Actions actions = new Actions(driver);

        // Perform Enter key press action
        actions.sendKeys(Keys.RETURN).perform();
		/**
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.manage().deleteAllCookies();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.dispatchEvent(new KeyboardEvent('keydown', {key: 'Enter'}));");
        js.executeScript("document.dispatchEvent(new KeyboardEvent('keyup', {key: 'Enter'}));");
        js.executeScript("document.dispatchEvent(new KeyboardEvent('keypress', {key: 'Enter'}));");
		**/
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	
	}
	
	@Test
	public void Verify_Search_Results() throws InterruptedException{
		HomepagePageObject _homepage = new HomepagePageObject(driver);
		_homepage.sendSearchvalue("Monitor");
		_homepage.clickSearchBarButton();
		
		
	}

}
