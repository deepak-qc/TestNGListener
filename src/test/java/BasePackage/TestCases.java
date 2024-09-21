package BasePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCases extends Base{

	@Test(priority= 1)
	public static void coursesText() {
		String atext= driver.findElement(By.xpath("(//a[text()='Courses'])[1]")).getText();
		Assert.assertEquals(atext, "cour");
	}
	
	@Test(priority= 2)
	public static void coursesText1() {
		String atext= driver.findElement(By.xpath("(//a[text()='Courses'])[1]")).getText();
		Assert.assertEquals(atext, "Courses");
	}
	
	@Test(priority=3)
	public static void clickOnCoursesAnchorText() {
		WebElement element= driver.findElement(By.xpath("(//a[text()='Courses'])[1]"));
		javaScriptHighlighter(driver,element);
		element.click();
		WebElement element1= driver.findElement(By.xpath("//div[contains(text(),'Category:')]"));
		javaScriptHighlighter(driver,element1);
		String at= element1.getText().trim();
		Assert.assertEquals(at, "Category:");
	}
	
	@Test(priority=4)
	public static void clickOnCoursesAnchorText1() {
		WebElement element= driver.findElement(By.xpath("(//a[text()='Courses'])[1]"));
		javaScriptHighlighter(driver,element);
		element.click();
		WebElement element1= driver.findElement(By.xpath("//div[contains(text(),'Category:')]"));
		javaScriptHighlighter(driver,element1);
		String at= element1.getText().trim();
		Assert.assertEquals(at, "Category:");
	}

}
