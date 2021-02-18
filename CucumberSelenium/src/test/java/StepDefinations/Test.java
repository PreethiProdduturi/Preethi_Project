package StepDefinations;


import java.io.File;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.codec.http.multipart.FileUpload;

public class Test {

	public static void main(String[] args) throws Throwable {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Preethi\\Desktop\\CucumberSelenium\\src\\test\\resources\\drivers\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		//WebDriver driver = new EdgeDriver();

		/*chrome options*/
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Preethi\\Desktop\\CucumberSelenium\\src\\test\\resources\\drivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		ChromeDriver driver = new ChromeDriver(options);
	
		
	    driver.get("https://www.testandquiz.com/selenium/testing.html");
		
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
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
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(box));
	    
		
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(driver.findElement(javat), driver.findElement(box)).build().perform();
		
		System.out.println("doneee");
		Thread.sleep(4000);
		
		/* taking screenshot */
		//TakesScreenshot scrShot =((TakesScreenshot)driver);
		File image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(image,new File("C:\\Users\\Preethi\\Desktop\\CucumberSelenium\\src\\test\\resources\\screenshots\\drag.jpeg"));
		
	    driver.close();
	    
		
//		
//		Scanner s= new Scanner(System.in);
//		String x=s.nextLine();
//		
//		System.out.println("entered string" + x);
//		int uppercount=0;
//		int lowercount=0;
//		
//		for(int i=0;i<x.length();i++) {
//			
//			if(x.charAt(i)>=65 && x.charAt(i)<=90) {
//				uppercount++;
//				}
//			else if (x.charAt(i)>=97 && x.charAt(i)<=122) {
//				lowercount++;
//			}
//		}
//		
//		System.out.println("upper count is "+uppercount+"  lower count is  "+lowercount);
//	      
//		
		
	}
}
