package TutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_013 {
	@Test
	public void verifyingPlaceholdersInRegisterPage(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedFirstNamePlaceholder = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"), expectedFirstNamePlaceholder);
		
		String expectedLastNamePlaceholder = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"), expectedLastNamePlaceholder);
		
		String expectedEmailPlaceholder = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"), expectedEmailPlaceholder);
		
		String expectedTelephonePlaceholder = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), expectedTelephonePlaceholder);
		
		String expectedPasswordPlaceholder = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"), expectedPasswordPlaceholder);
		
		String expectedConfirmPlaceholder = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), expectedConfirmPlaceholder);
		
		driver.quit();
	}
}
