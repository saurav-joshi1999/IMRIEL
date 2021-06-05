package Kaldi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	By about = By.linkText("About");
	By product = By.cssSelector("[href='/products']");
	By blog = By.xpath("//div[@id='navMenu']//a[3]");
	By contact = By.xpath("//div[@id='navMenu']//a[4]");
	By superCharge = By.xpath("//div[@id='navMenu']//a[5]");
	By seeAllProduct = By.linkText("See all products");

	public Aboutl about() {
		driver.findElement(about).click();
		return new Aboutl(driver);

	}

	public WebElement product() {
		return driver.findElement(product);
	}

	public WebElement blog() {
		return driver.findElement(blog);

	}

	public WebElement contact() {
		return driver.findElement(contact);
	}

	public WebElement superCharge() {
		return driver.findElement(superCharge);
	}

	public SeeAllPro seeAllProduct() {
		driver.findElement(seeAllProduct).click();
		SeeAllPro sap = new SeeAllPro(driver);
		return sap;
	}

}
