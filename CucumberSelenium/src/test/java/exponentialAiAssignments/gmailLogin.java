package exponentialAiAssignments;

import java.io.File;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class gmailLogin {
public static void main(String[] args) throws Throwable {
	
	String projectPath=System.getProperty("user.dir");
	By signIn=By.xpath("//a[@class='fuji-button-link fuji-button-text fuji-button-inverted']");
	By userName=By.xpath("//input[@id='login-username']");
	By next=By.xpath("//input[@id='login-signin']");
	By password=By.xpath("//input[@id='login-passwd']");
	By passwordNext=By.xpath("//button[@id='login-signin']");
	By sent=By.xpath("//span[@class='rtlI_dz_sSg '][text()='Sent']");
	
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

    /* to enter username and password */
	Scanner s= new Scanner(System.in);
	System.out.println("enter username:");
	String gmailUserName=s.nextLine();
	System.out.println("enter password");
	String gmailPassword=s.nextLine();
	s.close();
	
	/* login into gmail and open sent i=mails*/
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(3000);
	driver.get("https://mail.yahoo.com/");
	driver.findElement(signIn).click();
	//driver.manage().deleteAllCookies();
	
	driver.findElement(userName).sendKeys(gmailUserName);
	driver.findElement(next).click();
	//Thread.sleep(2000);
	driver.findElement(password).sendKeys(gmailPassword);
	driver.findElement(passwordNext).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    wait.until(ExpectedConditions.visibilityOfElementLocated(sent)).click();
    
  
    Thread.sleep(2000);
    
    File image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(image,new File(projectPath+"\\src\\test\\resources\\screenshots\\sent.jpeg"));
	
    driver.close();
	
	
}
}
