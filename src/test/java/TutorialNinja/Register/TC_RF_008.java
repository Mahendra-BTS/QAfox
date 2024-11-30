package TutorialNinja.Register;


import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_008 {
	@Test
	public void verifingWarningGivesWhenEnterWrongPasswordInRegisterForm() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Mahendra");
		driver.findElement(By.id("input-lastname")).sendKeys("Thatithoti");
		driver.findElement(By.id("input-email")).sendKeys(BrandNewGmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9959948202");
		driver.findElement(By.id("input-password")).sendKeys("Mahendra@7");
		driver.findElement(By.id("input-confirm")).sendKeys("Mahendra@77");
		driver.findElement(By.name("agree")).click();
 		driver.findElement(By.xpath("//input[@value='Continue']")).click();
 		
 		String expectedWarning = "Password confirmation does not match password!";
 		
 		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger'][text()='Password confirmation does not match password!']")).getText(), expectedWarning);
 		
 		driver.quit();
	}
	public String  BrandNewGmail() {
		Date date = new Date();
		String datestring = date.toString();
		String noSpaceDateString = datestring.replaceAll(" ", "");
		String noColonDateString = noSpaceDateString.replaceAll(":", "");
		String emailWithTimeStamp = noColonDateString+"@gmail.com";
		return emailWithTimeStamp;
	}
}
