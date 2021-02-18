package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class headlessBrowser {
	public static void main(String[] args) {
		
		 WebDriver driver = new HtmlUnitDriver();
	 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.facebook.com/");
		driver.close();
	//.sleep(2000);
}
}
