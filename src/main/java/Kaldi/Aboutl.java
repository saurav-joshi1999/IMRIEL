package Kaldi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Aboutl {
	public WebDriver driver;

	public Aboutl(WebDriver driver) {
		this.driver = driver;

	}

	By noOfLink = By.xpath("//div[@class='container has-background-black has-text-white-ter']//a");
	By home = By.xpath("//a[contains(text(),'Home')]");

	public List<WebElement> noOfLinks() {
		return driver.findElements(noOfLink);
	}

	public WebElement home() {
		return driver.findElement(home);
	}

}
