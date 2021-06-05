package Imriel;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestScenario1 
{
	public WebDriver driver;

	@BeforeMethod
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver.exe\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/upload");

	}

	@Test
	public void withoutFileUpload() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("[class='button']")).click();
		String text = driver.findElement(By.xpath("//body//h1")).getText();
		System.out.println(text);
		Assert.assertEquals("File not found", text);

		driver.close();

}

@Test
public void zwithFileUpload() throws IOException {
	/*
	 * WebDriverWait wait = new WebDriverWait(driver, 50);
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
	 * "[id='file-upload']")));
	 */
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//form/input"))).click().build().perform();
	
	Runtime.getRuntime().exec("C:\\Users\\RT_PRIO\\eclipse-workspace\\Ideabytes\\Upload2.exe");
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div/h3")));
	driver.findElement(By.cssSelector("[class='button']")).click();
	String uploadText = driver.findElement(By.xpath("//div/h3")).getText();
	System.out.println(uploadText);
	// File Uploaded!
	Assert.assertEquals("File Uploaded!", uploadText);

	String fileName = driver.findElement(By.id("[id='uploaded-files']")).getText();
	Assert.assertEquals("automation-test.txt", fileName);

}

}