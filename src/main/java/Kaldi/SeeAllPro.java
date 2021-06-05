package Kaldi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeeAllPro {

	public WebDriver driver;

	public SeeAllPro(WebDriver driver) {
		this.driver = driver;
	}

	By notfound = By.xpath("//div/h1");

	public WebElement notFounds() {
		return driver.findElement(notfound);
	}

}
