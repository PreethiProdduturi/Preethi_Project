package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class autoItDEMO {
	public static void main(String[] args) throws Throwable {
		String projectPath=System.getProperty("user.dir");
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Preethi\\Desktop\\CucumberSelenium\\src\\test\\resources\\drivers\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
		
//		System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
//		 WebDriver driver= new ChromeDriver();
	  driver.get("http://tinyupload.com/");
	  Thread.sleep(4000);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.name("uploaded_file")).sendKeys(Keys.ENTER);
	  Runtime.getRuntime().exec("C:\\Users\\Preethi\\Desktop\\autoitDemo.exe");
}
}
