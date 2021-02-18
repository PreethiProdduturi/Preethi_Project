package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utils.ExcelUtils;

public class excelTest {
public static void main(String[] args) throws Throwable {
		
		//WebDriver driver= new FirefoxDriver();
//		System.setProperty("webdriver.edge.driver","C:\\Users\\Preethi\\Desktop\\CucumberSelenium\\src\\test\\resources\\drivers\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
	String projectPath = System.getProperty("user.dir");
	ExcelUtils excel = new ExcelUtils(projectPath+"\\excelFiles\\data.xlsx", "Sheet1");
	excel.getRowCount();
	excel.getCellDataString(1,0);
	excel.getCellDataNumeric(1,1);
}
}
