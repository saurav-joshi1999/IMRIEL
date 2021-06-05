package Imriel;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScenario3 {

	public WebDriver driver;

	@BeforeMethod
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver.exe\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/broken_images");

	}

	@Test
	public void method() throws ClientProtocolException,
			IOException {/*
							 * List<WebElement> image_list = driver.findElements(By.tagName("img"));
							 * System.out.println("The page under test has " + image_list.size() +
							 * " images");
							 * 
							 * HttpClient client = HttpClientBuilder.create().build();
							 * 
							 * for (WebElement img : image_list) { HttpGet request = new
							 * HttpGet(img.getAttribute("src")); HttpResponse response =
							 * client.execute(request); if (response.getStatusLine().getStatusCode() != 200)
							 * { System.out.println(img.getAttribute("outerHTML") + " is broken.");
							 * iBrokenImageCount++; } }
							 */
		Integer iBrokenImageCount = 0;
		Integer CorrectImage = 0;
		String status = "passed";

		try {
			iBrokenImageCount = 0;
			CorrectImage = 0;
			List<WebElement> image_list = driver.findElements(By.tagName("img"));
			/* Print the total number of images on the page */
			System.out.println("The Page has " + image_list.size() + " images");
			for (WebElement img : image_list) {
				if (img != null) {
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet request = new HttpGet(img.getAttribute("src"));
					HttpResponse response = client.execute(request);
					/* For valid images, the HttpStatus will be 200 */
					if (response.getStatusLine().getStatusCode() != 200) {
						System.out.println(img.getAttribute("outerHTML") + " is broken.");
						iBrokenImageCount++;
					}
					else if (response.getStatusLine().getStatusCode() <= 200) {
						System.out.println(img.getAttribute("outerHTML") + " is Corrected Render image.");
						CorrectImage++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failed";
			System.out.println(e.getMessage());
		}
		status = "passed";
		System.out.println("The page " + driver.getCurrentUrl() + " has " + iBrokenImageCount + " broken images");
		System.out.println("The page " + driver.getCurrentUrl() + " has " + (CorrectImage - 1) + " Correct images");

}
}
