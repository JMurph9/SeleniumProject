package SeleniumAssignment.SeleniumAssignment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PurchaseItem {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	// pass scenario
		@Test(priority = 1, enabled = false)
		public void verifyHomePageTitle() {

			// where to create the report file
			report = new ExtentReports(
					"C:\\Users\\Administrator\\Desktop\\JMJava\\SeleniumJava\\SeleniumAssignment\\Reports\\verifyHomePage.html",
					true);
			// init/start the test
			test = report.startTest("Verify application Title");
			//firefox
			System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
					
			driver.manage().window().maximize();
			// add a note to the test
			test.log(LogStatus.INFO, "Browser started");
			driver.get("https://automationpractice.com/");
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals(
					"My Store")) {
				// report the test as a pass
				test.log(LogStatus.PASS, "verify Title of the page");
			} else {
				test.log(LogStatus.FAIL, "verify Title of the page");
			}
			report.endTest(test);
			report.flush();
		}
		/*
		@Test(priority = 2, enabled = true)
		public void NavigateToProduct()	{
			report = new ExtentReports(
					"C:\\Users\\Administrator\\Desktop\\JMJava\\SeleniumJava\\SeleniumAssignment\\Reports\\navigateToProduct.html",
					true);
			test = report.startTest("Navigate To Product");
			//firefox
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			// add a note to the test
			test.log(LogStatus.INFO, "Browser started");
			driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("My Store"));
		}
		*/
}
