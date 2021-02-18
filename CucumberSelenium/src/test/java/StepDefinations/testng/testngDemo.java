package StepDefinations.testng;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngDemo {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Preethi\\Desktop\\CucumberSelenium\\src\\test\\resources\\drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		//WebDriver driver = new EdgeDriver();

		/*chrome options*/
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Preethi\\Desktop\\CucumberSelenium\\src\\test\\resources\\drivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		ChromeDriver driver = new ChromeDriver(options);
	}
	
	@Test
    public  void practiceTest() throws InterruptedException, Throwable  {
        driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		By textbox = By.xpath("//input[@id='fname']");
		driver.findElement(textbox).sendKeys("nothing");
		
		/* scrolling */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500);");
		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		Actions action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		
		/*drag and drop*/
		
		
		driver.findElement(By.xpath("//button[text()='Generate Confirm Box']")).click();
		driver.switchTo().alert().dismiss();
		
		By javat = By.xpath("//img[@id='sourceImage']");
		By box=By.xpath("//div[@id='targetDiv']");
		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	   //  WebDriverWait(driver,10).unti(ExpectedConditions.visibilityOf(driver.findElement(box)));
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(javat), driver.findElement(box)).build().perform();
		System.out.println("doneee");
		Thread.sleep(1000);
    }
		@AfterTest
      public void tearDown() throws Throwable {
		/* taking screenshot */
		//TakesScreenshot scrShot =((TakesScreenshot)driver);
		File image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(image,new File("C:\\Users\\Preethi\\Desktop\\CucumberSelenium\\src\\test\\resources\\screenshots\\screenshot.jpeg"));
		driver.close();
      }
}

