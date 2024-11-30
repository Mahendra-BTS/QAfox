package TutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {
	@Test
	public void verifingWarningsCameWhenNoDatafills() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expecterFirstwarning = "First Name must be between 1 and 32 characters!";
		String expecterTwowarning = "Last Name must be between 1 and 32 characters!";
		String expecterThreewarning = "E-Mail Address does not appear to be valid!";
		String expecterFourwarning = "Telephone must be between 3 and 32 characters!";
		String expecterFivewarning = "Password must be between 4 and 20 characters!";
		String expectersixwarning = "Warning: You must agree to the Privacy Policy!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expecterFirstwarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expecterTwowarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), expecterThreewarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expecterFourwarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expecterFivewarning);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Warning: You must agree to the Privacy Policy!']")).getText(), expectersixwarning);
		driver.quit();
	}
}
