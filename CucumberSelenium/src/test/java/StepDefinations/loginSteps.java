package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	WebDriver driver;
	
	

	@Given("launch facebook url  https:\\/\\/www.facebook.com\\/")
	public void launch_facebook_url_https_www_facebook_com() throws Throwable {
	
    	    String projectPath= System.getProperty("user.dir");
    	    System.out.println(projectPath);
			System.setProperty("webdriver.gecko.driver", projectPath+"\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.navigate().to("https://www.facebook.com/");
			Thread.sleep(2000);
		}

	@When("enter username  and password ")
	public void enter_username_saipreethi_prodduturi_and_password_gen_abhi11() {
		System.out.println("facebook login page");
		
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
	}

	@When("click on login button")
	public void click_on_login_button() throws Throwable {
		System.out.println("facebook login page");
		
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
	}

	@Then("verify the login from username saipreethi.prodduturi")
	public void verify_the_login_from_username_saipreethi_prodduturi() {
		System.out.println("facebook login page");
		
		if(driver.getCurrentUrl().contains("saipreethi.prodduturi")){
			System.out.println("verified");
		}
		else {
			System.out.println("not verified");
	}
	}

}
