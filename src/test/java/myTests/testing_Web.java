package myTests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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

public class testing_Web {

	WebDriver driver;
	private WebElement menu;

	@BeforeTest

	public void setup() throws Exception{


		String baseurl = "https://www.kurtosys.com/";
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(baseurl);
		testing_Web.takesnapshot(driver, "C:\\Users\\kmabokela\\Desktop\\Results\\results.png");

	}



	@Test

	public void WhitePeB() throws Exception {


		Actions action = new Actions(driver);

		WebElement menu = driver.findElement(By.xpath("//*[@id=\"kurtosys-menu-item-59810\"]/a/div/div/span"));
		action.moveToElement(menu).perform();

		driver.findElement(By.partialLinkText("White Papers & eBooks")).click();
		testing_Web.takesnapshot(driver, "C:\\Users\\kmabokela\\Desktop\\Results\\results1.png");
	}

	@Test

	public void verifyTitle() throws Exception {


		String actTitle="White Paper";
		String expTitle = driver.getTitle();

		Assert.assertEquals(actTitle, expTitle);

		if(actTitle.contentEquals(expTitle)) {
			System.out.println("Correct titlte");
		}

		else {
			System.out.println("inCorrect titlte");

		}

		testing_Web.takesnapshot(driver, "C:\\Users\\kmabokela\\Desktop\\Results\\results2.png");
	}



	@Test
	public void ValidateImageDisplay() throws Exception {


		driver.findElement(By.linkText(" UCITS White Paper ")).click();

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

	@Test

	public void fillin() throws Exception {

		driver.findElement(By.id("18882_231669pi_18882_231669")).sendKeys("Kagiso");
		driver.findElement(By.id("18882_231671pi_18882_231671")).sendKeys("Mabokela");
		driver.findElement(By.id("18882_231673pi_18882_231673")).sendKeys("Kagisomw@gmail.com");
		driver.findElement(By.id("18882_231675pi_18882_231675")).sendKeys("Kurtosys");
		driver.findElement(By.id("18882_231677pi_18882_231677")).sendKeys("IT");


		driver.findElement(By.id("18882_234828pi_18882_234828_3080800")).click();
		driver.findElement(By.xpath("18882_231677pi_18882_231677")).click();

		testing_Web.takesnapshot(driver, "C:\\Users\\kmabokela\\Desktop\\Results\\results3.png");

	}
	public static void takesnapshot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	@AfterTest

	public void close() {


	}

}
