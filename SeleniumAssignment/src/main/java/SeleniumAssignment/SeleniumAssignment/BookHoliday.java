package SeleniumAssignment.SeleniumAssignment;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BookHoliday {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	
	WebElement usernameBox;
	WebElement passwordBox;
	WebElement btnLogin;
	
	@Test(priority = 1, enabled = true)
	public void Login()	{
		report = new ExtentReports(
				"C:\\Users\\Administrator\\Desktop\\JMJava\\SeleniumJava\\SeleniumAssignment\\Reports\\BookHolidayTest.html",
				true);
		// init/start the test
		test = report.startTest("Verify Login");
		//firefox
		//System.setProperty("webdriver.gecko.driver", 
		//	"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\geckodriver.exe");
		//driver = new FirefoxDriver();
				
		//chrome
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window();
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("http://newtours.demoaut.com");
		
		String title = driver.getTitle();
		if (title.equals("Welcome: Mercury Tours")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}
		report.endTest(test);
		report.flush();
		
		String username = "jackmurph";
		String password = "jackmurph";
		
		usernameBox = driver.findElement(By.name("userName"));
		passwordBox = driver.findElement(By.name("password"));
		btnLogin = driver.findElement(By.name("login"));
		
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		btnLogin.click();
		
		
	}
		@Test (priority = 2, enabled = true)
		public void Booking()	{
			
			
			test = report.startTest("Booking information");
			WebElement tripType = driver.findElement(By.name("tripType"));
			tripType.click();
			
			Select ddb_departFrom = new Select(driver.findElement(By.name("fromPort")));
			ddb_departFrom.selectByVisibleText("San Francisco");
			
			Select ddb_OnMonth = new Select(driver.findElement(By.name("fromMonth")));
			ddb_OnMonth.selectByVisibleText("September");
			
			Select ddb_OnDay = new Select(driver.findElement(By.name("fromDay")));
			ddb_OnDay.selectByVisibleText("15");
			
			Select ddb_Arrive = new Select(driver.findElement(By.name("toPort")));
			ddb_Arrive.selectByVisibleText("Zurich");
			
			Select ddb_ReturnMonth = new Select(driver.findElement(By.name("toMonth")));
			ddb_ReturnMonth.selectByVisibleText("October");
			
			Select ddb_ReturnDay = new Select(driver.findElement(By.name("toDay")));
			ddb_ReturnDay.selectByVisibleText("15");
			
			Select ddb_Airline = new Select(driver.findElement(By.name("airline")));
			ddb_Airline.selectByVisibleText("Pangea Airlines");
			
			String departFrom = ddb_departFrom.getFirstSelectedOption().getText();
			String onMonth = ddb_OnMonth.getFirstSelectedOption().getText();
			String onDay = ddb_OnDay.getFirstSelectedOption().getText();
			String arriveTo = ddb_Arrive.getFirstSelectedOption().getText();
			String returnMonth = ddb_ReturnMonth.getFirstSelectedOption().getText();
			String returnDay = ddb_ReturnDay.getFirstSelectedOption().getText();
			String airline = ddb_Airline.getFirstSelectedOption().getText();
			
			String title = driver.getTitle();
			if (title.equals("Find a Flight: Mercury Tours: ")) {
				// report the test as a pass
				test.log(LogStatus.PASS, "verify Title of the find a flight page");
			} else {
				test.log(LogStatus.FAIL, "verify Title of the find a flight page");
			}
			report.endTest(test);
			report.flush();
			
			WebElement cont = driver.findElement(By.name("findFlights"));
			cont.click();
			
			WebElement reserveFlight = driver.findElement(By.name("reserveFlights"));
			reserveFlight.click();
			
		}
		@Test(priority = 3, enabled = true)
		public void payment()	{
			test = report.startTest("Payment information");
			
			
			
			WebElement firstName = driver.findElement(By.name("passFirst0"));
			WebElement lastName = driver.findElement(By.name("passLast0"));
	
			WebElement ccNumber = driver.findElement(By.name("creditnumber"));
			
			String enterFirstName = "Jack";
			String enterLastName = "Murph";
			
			String enterCCNumber = "1098746375647609";
			
			firstName.sendKeys(enterFirstName);
			lastName.sendKeys(enterLastName);
			
			ccNumber.sendKeys(enterCCNumber);
	
			WebElement securePurchase = driver.findElement(By.name("buyFlights"));
			securePurchase.click();
		
			String title = driver.getTitle();
			if (title.equals("Flight Confirmation: Mercury Tours")) {
				// report the test as a pass
				test.log(LogStatus.PASS, "verify Title of the confirmation page");
			} else {
				test.log(LogStatus.FAIL, "verify Title of the confirmation page");
			}
			report.endTest(test);
			report.flush();
			
		}

}
