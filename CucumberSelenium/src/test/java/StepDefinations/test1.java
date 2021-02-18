package StepDefinations;

import java.io.File;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test1 {
public static void main(String[] args) throws Throwable {
	
	String projectPath=System.getProperty("user.dir");
	
	
	
	System.setProperty("webdriver.gecko.driver",projectPath+"\\src\\test\\resources\\drivers\\geckodriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	FirefoxOptions options= new FirefoxOptions();
	options.addArguments("-private");
	capabilities.setCapability("moz:firefoxOptions",options);
	WebDriver driver= new FirefoxDriver(options);
	

	
	/* open in incognito mode*/
//	System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
//    DesiredCapabilities capabilities = new DesiredCapabilities();
//	ChromeOptions options = new ChromeOptions();
//    options.addArguments("--incognito");
//    capabilities.setCapability(ChromeOptions.CAPABILITY,options);
//    WebDriver driver= new ChromeDriver(options);
	
	
	By signIn=By.xpath("//a[@class='fuji-button-link fuji-button-text fuji-button-inverted']");
	By userName=By.xpath("//input[@id='login-username']");
	By next=By.xpath("//input[@id='login-signin']");
	By password=By.xpath("//input[@id='login-passwd']");
	By passwordNext=By.xpath("//button[@id='login-signin']");
	By sent=By.xpath("//span[@class='rtlI_dz_sSg '][text()='Sent']");
	/* login into gmail and open sent i=mails*/
	
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(3000);
	driver.get("https://mail.yahoo.com/");
	driver.findElement(signIn).click();
	//driver.manage().deleteAllCookies();
	
	driver.findElement(userName).sendKeys("preethiprodduturi");
	driver.findElement(next).click();
	Thread.sleep(2000);
	driver.findElement(password).sendKeys("Anitha11");
	driver.findElement(passwordNext).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    wait.until(ExpectedConditions.visibilityOfElementLocated(sent)).click();
    
  
    Thread.sleep(2000);
    
    File image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(image,new File(projectPath+"\\src\\test\\resources\\screenshots\\sent.jpeg"));
	
    driver.close();
	
	
	
}
}
