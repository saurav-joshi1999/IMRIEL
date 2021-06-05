package Imriel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScenario4 {

	public WebDriver driver;

	@BeforeMethod
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver.exe\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://colorlib.com/polygon/gentelella/form_validation.html");

	}

	@Test
	public void method() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("[name='name']")).sendKeys("Saurav Joshi");
		;
		driver.findElement(By.cssSelector("[name='occupation']")).sendKeys("Testing");
		// [name='email']
		driver.findElement(By.cssSelector("[name='email']")).sendKeys("joshi1999saurav@gamil.com");
		// [name='confirm_email']
		driver.findElement(By.cssSelector("[name='confirm_email']")).sendKeys("joshi1999saurav@gamil.com");
		// [name='number']
		driver.findElement(By.cssSelector("[name='number']")).sendKeys("91");
		// [name='date']
		driver.findElement(By.cssSelector("[name='date']")).sendKeys("05061999");
		//[name='time']
		driver.findElement(By.cssSelector("[name='time']")).sendKeys("0800");
		//[name='password']
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("Netid#");
		//[name='password2']
		driver.findElement(By.cssSelector("[name='password2']")).sendKeys("Netid#");
		//[name='phone']
		driver.findElement(By.cssSelector("[name='phone']")).sendKeys("07312364304");
		// message
		driver.findElement(By.cssSelector("[name='phone']")).sendKeys("ENJOY");
		// [type='submit']
		driver.findElement(By.cssSelector("[type='submit']")).click();

	}

	@AfterTest
	public void close() {
		driver.close();
	}
}
