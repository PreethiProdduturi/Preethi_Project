package StepDefinations.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testngMultibrowser {
	WebDriver driver= null;
	String projectPath=System.getProperty("user.dir");
	
	 @Parameters("browserName")
	 @BeforeTest
	public void setup(String browserName) {
       
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"\\src\\test\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
}
	 @Test
	 public void performtest() {
		 driver.get("http://www.google.com");
	 }
	 @AfterTest
	 public void tearDown() {
		 driver.close();
	 }
}
