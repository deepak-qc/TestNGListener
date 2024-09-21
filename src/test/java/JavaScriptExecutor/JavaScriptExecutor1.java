package JavaScriptExecutor;

import java.io.File;
import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.io.FileHandler;

public class JavaScriptExecutor1 {

	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.get("https://omayo.blogspot.com/");
		driver.get("https://tutorialsninja.com/demo/");
		
		WebElement alert1= driver.findElement(By.cssSelector("div#cart > button"));
		String defaultColour= alert1.getCssValue("background");
		System.out.println(defaultColour);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	//	jse.executeScript("document.getElementById('alert1').click()");
	//	driver.switchTo().alert().accept();
		jse.executeScript("arguments[0].click()", alert1);
		jse.executeScript("arguments[0].style.border='5px dotted red'",alert1);
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("./Screenshots/border.png"));
		Thread.sleep(2000);		
		jse.executeScript("arguments[0].style.background='"+defaultColour+"'",alert1);
		String pageTitle = jse.executeScript("return document.title").toString();
		System.out.println(pageTitle);
		String value= "hp";
		jse.executeScript("document.getElementsByName('search')[0].value='"+value+"'");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		jse.executeScript("document.getElementById('datepicker').value='28/07/2023';");
		jse.executeScript("history.go(0)");
		String pageText= jse.executeScript("return document.documentElement.innerText").toString();
		System.out.println(pageText);
		
	}	
	
	
}
