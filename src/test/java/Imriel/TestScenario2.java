package Imriel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScenario2 {

	public WebDriver driver;

	@BeforeMethod
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver.exe\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

	}

	@Test
	public void method() {

		driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys("Imriel test scenario 2");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		String fullText = driver.findElement(By.cssSelector("[id='result']")).getText();
		String text = fullText.split(":")[1].trim();
		Assert.assertEquals("Imriel test scenario 2", text);
	}
}
