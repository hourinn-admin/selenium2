package cn.hourinn.samples.chapter1;

import static org.junit.Assert.assertEquals;

import java.sql.Driver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		// Launch a new chrome instance
		driver = new ChromeDriver();
		// Maximize the brower window
		driver.manage().window().maximize();
		// Navigate to google
		driver.get("http://www.google.com");
	}
	
	@Test
	public void testGoogleSearch() {
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));
		// Clear the existing text value
		
		// Enter something to search for
		element.sendKeys("Selenium testing tools cookbook");
		
		element.submit();
		
		// Now submit the form
		
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("selenium testing tools cookbook");
			}
		});
		
		assertEquals("Selenium testing tools cookbook - Google 検索", driver.getTitle());
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
