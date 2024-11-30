package TutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_014 {   //we have a defect in this test scrict becouse privacy polacy do not have mendatory symbol and color
	WebDriver driver;
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
	public void verifyingMandetorySymbolAndColorInRegisterPage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedContent = "\"* \"";
		String expectedCoror = "rgb(255, 0, 0)";
		
		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fnConten = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", firstNameLabel);
		String fnColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", firstNameLabel);
		Assert.assertEquals(fnConten, expectedContent);
		Assert.assertEquals(fnColor, expectedCoror);
		
		WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		String lnConten = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", lastNameLabel);
		String lnColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", lastNameLabel);
		Assert.assertEquals(lnConten, expectedContent);
		Assert.assertEquals(lnColor, expectedCoror);
		
		WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
		String emConten = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", emailLabel);
		String emColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", emailLabel);
		Assert.assertEquals(emConten, expectedContent);
		Assert.assertEquals(emColor, expectedCoror);
		
		WebElement telephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		String tpConten = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", telephoneLabel);
		String tpColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", telephoneLabel);
		Assert.assertEquals(tpConten, expectedContent);
		Assert.assertEquals(tpColor, expectedCoror);
		
		WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
		String pwConten = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", passwordLabel);
		String pwColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", passwordLabel);
		Assert.assertEquals(pwConten, expectedContent);
		Assert.assertEquals(pwColor, expectedCoror);
		
		WebElement passwordConfirmLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
		String pwcConten = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", passwordConfirmLabel);
		String pwcColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", passwordConfirmLabel);
		Assert.assertEquals(pwcConten, expectedContent);
		Assert.assertEquals(pwcColor, expectedCoror);
		
		WebElement privacyPolacyLabel = driver.findElement(By.cssSelector("[class='pull-right']"));
		String ppConten = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", privacyPolacyLabel);
		String ppColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", privacyPolacyLabel);
		Assert.assertEquals(ppConten, expectedContent);
		Assert.assertEquals(ppColor, expectedCoror);
		
	}
}
