package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	WebDriver driver;

	public WebDriver baseClass() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver.exe\\chromedriver.exe");

		driver = new ChromeDriver();
		return driver;

	}

}
