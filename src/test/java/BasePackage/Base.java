package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Base {

	static Properties prop;
	static WebDriver driver= null;
	static String browserName= "Chrome";

	@BeforeTest
	public static WebDriver openBrowserAndEnterURL() {
		prop = new Properties();
		File propfile= new File("src/main/java/properties.prop");
		try {
			FileInputStream fis = new FileInputStream(propfile);
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")){
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("URL"));
		return driver;
		
	}
	
	//Utility to take screenshot
	public static String takeScreenShot(String testCaseName) throws IOException {
	TakesScreenshot tks= 	(TakesScreenshot)driver;
	File file = tks.getScreenshotAs(OutputType.FILE);
	File sf = new File(System.getProperty("user.dir")+"/screenshot/"+testCaseName+".png");
	FileUtils.copyFile(file, sf);
	return System.getProperty("user.dir")+"/screenshot/"+testCaseName+".png";
	}
	
	public static void javaScriptHighlighter(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='5px solid red'",element );
	}
	

}
