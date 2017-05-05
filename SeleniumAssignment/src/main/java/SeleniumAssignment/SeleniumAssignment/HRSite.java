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
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class HRSite {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	
	WebElement verifyLog;
	WebElement disciplineTab;
	WebElement src;
	WebElement welcomeTab;
	WebElement signOut;
	
	// pass scenario
		@Test(priority = 1, enabled = true)
		public void verifyHomePageTitle() {

			// where to create the report file
			report = new ExtentReports(
					"C:\\Users\\Administrator\\Desktop\\JMJava\\SeleniumJava\\SeleniumAssignment\\Reports\\HRTests.html",
					true);
			// init/start the test
			test = report.startTest("Verify application Title");
			//firefox
			System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
					
			driver.manage().window();
			// add a note to the test
			test.log(LogStatus.INFO, "Browser started");
			driver.get("https://enterprise-demo.orangehrmlive.com/");
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("OrangeHRM")) {
				// report the test as a pass
				test.log(LogStatus.PASS, "verify Title of the page");
			} else {
				test.log(LogStatus.FAIL, "verify Title of the page");
			}
			report.endTest(test);
			report.flush();
		}
		@Test(priority = 2, enabled = true)
		public void verifyLogin() {
			try {
				String username = "anthony.nolan";
				String password = "anthony.nolan";
				
				// init/start the test
				test = report.startTest("Verify Login");
				
				WebElement usernameBox = driver.findElement(By.id("txtUsername"));
				WebElement passwordBox = driver.findElement(By.id("txtPassword"));
				WebElement loginBtn = driver.findElement(By.id("btnLogin"));
				
				usernameBox.sendKeys(username);
				passwordBox.sendKeys(password);
				loginBtn.click();
				
				src = driver
						.findElement(By.xpath("/html/body/div[1]/div[1]/img"));
				if (src != null) {
					test.log(LogStatus.PASS, "verify login");
					System.out.println("login verified");
				} else {
					test.log(LogStatus.FAIL, "verify login");
					System.out.println("login not verified");
					File scrFile = ((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(
							"C:\\Users\\Administrator\\Desktop\\JMJava\\SeleniumJava\\Reports\\HRTests\\img.jpg"));
					String image = test.addScreenCapture(
							"C:\\Users\\Administrator\\Desktop\\JMJava\\SeleniumJava\\\\Reports\\HRTests\\img.jpg");
					test.log(LogStatus.FAIL, "verify logo of the application", image);
				}
				report.endTest(test);
				report.flush();
				
			} catch (Exception e)	{
				e.printStackTrace();
			}
		}
		@Test(priority = 3, enabled = true)
		public void fileDisciplineReport()	{
			// init/start the test
			test = report.startTest("File Discipline Report");
			try {
				disciplineTab = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[5]/a/b"));
				WebElement btnAdd = driver.findElement(By.id("btnAdd"));
				disciplineTab.click();
				btnAdd.click();
				
				String employeeName = "Julian Taylor";
				String caseName = "Drinking on the job";
				String description = "Arrived this morning clearly drunk and "
						+ "stinking of booze.";
				
				WebElement txtEmployeeName = driver.findElement(By.id("addCase_employeeName_empName"));
				WebElement txtCaseName = driver.findElement(By.id("addCase_caseName"));
				WebElement txtDescription = driver.findElement(By.id("addCase_description"));
				
				txtEmployeeName.sendKeys(employeeName);
				txtCaseName.sendKeys(caseName);
				txtDescription.sendKeys(description);
				
				WebElement btnSave = driver.findElement(By.id("btnSave"));
				btnSave.click();
				disciplineTab.click();
				
				verifyLog = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/div[4]/table/tbody/tr[1]/td[2]"));
				if (verifyLog.getText().equals(employeeName))	{
					test.log(LogStatus.PASS, "Discipline report filed");
					System.out.println("Discipline pass result");
				}	else	{
					test.log(LogStatus.FAIL, "Discipline fail result");
					System.out.println("rubbish");
				}
				report.endTest(test);
				report.flush();
			
			} catch (Exception e)	{
				e.printStackTrace();
			}
			
		}
		@Test(priority = 4, enabled = true)
		public void signOut()	{
			driver.get("https://enterprise-demo.orangehrmlive.com/discipline/viewDisciplineCases");
			// init/start the test
			test = report.startTest("File Sign out");
			try {
				welcomeTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[2]"));
				welcomeTab.click();
				signOut = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[2]/a"));
				signOut.click();
				
				String title = driver.getTitle();
				System.out.println(title);
				if (title.equals("OrangeHRM")) {
					// report the test as a pass
					test.log(LogStatus.PASS, "verify Title of the page");
				} else {
					test.log(LogStatus.FAIL, "verify Title of the page");
				}
				report.endTest(test);
				report.flush();
				
			} catch (NoSuchElementException nE)	{
				System.out.println("Element not found: "+ nE);
			} catch (Exception e)	{
				e.printStackTrace();
			}
		}
}

