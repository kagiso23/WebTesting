package myMaven;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myfirst {

	WebDriver driver;
	
	@BeforeTest

	public void setup(){


		String baseurl = "https://www.kurtosys.com/";
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(baseurl);


	}


	@Test(priority = 1)

	public void WhitePeB() {


		Actions action = new Actions(driver);
		
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"kurtosys-menu-item-59810\"]/a/div/div/span"));
		action.moveToElement(menu).perform();
		
		driver.findElement(By.partialLinkText("White Papers & eBooks")).click();
	}

	@Test(priority = 3)

	public void verifyTitle() {

		String expTitle = "White Papers"; 

		String actTitle = driver.getTitle();

		Assert.assertEquals(actTitle, expTitle);

		if(actTitle.contentEquals(expTitle)) {
			System.out.println("Correct titlte");
		}

		else {
			System.out.println("Incorrent title");
		}
	}

	@Test(priority = 4)

	public void ClickWhiteB() {
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/section[2]/div/div/div/div/div/div/div/div/article[2]/div/div[1]/p/a")).click();
		String expTitle = "White Papers"; 

		String actTitle = driver.getTitle();

		Assert.assertEquals(actTitle, expTitle);

		if(actTitle.contentEquals(expTitle)) {
			System.out.println("Correct titlte");
		}

		else {
			System.out.println("Incorrent title");
		}

	}

	public void ValidateImageDisplay() {

		Object image1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/section[2]/div/div/div/div/div/div/div/div/article[2]/div/div[1]/p/a"));

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image1);
		if (!ImagePresent)
		{
			System.out.println("Image not displayed.");
		}
		else
		{
			System.out.println("Image displayed.");
		}	

	}

	@Test(priority = 2)

	public void fillin() {

		driver.findElement(By.id("18882_231669pi_18882_231669")).sendKeys("Kagiso");
		driver.findElement(By.id("18882_231671pi_18882_231671")).sendKeys("Mabokela");
		driver.findElement(By.id("18882_231673pi_18882_231673")).sendKeys("Kagisomw@gmail.com");
		driver.findElement(By.id("18882_231675pi_18882_231675")).sendKeys("Kurtosys");
		driver.findElement(By.id("18882_231677pi_18882_231677")).sendKeys("IT");


		driver.findElement(By.id("18882_234828pi_18882_234828_3080800")).click();
		driver.findElement(By.xpath("18882_231677pi_18882_231677")).click();

	}


	@AfterTest

	public void close() {

		driver.close();
	}

}
