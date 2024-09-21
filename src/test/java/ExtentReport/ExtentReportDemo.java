package ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	WebDriver driver;
	ExtentReports extent;
	@BeforeTest
	public void config() {
			String path= System.getProperty("user.dir")+ "\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Result");
			reporter.config().setDocumentTitle("Test Result");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Deepak Singh");
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("initialDemo");
		driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result do not match");
		extent.flush();
	}
	
}
