package TutorialNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
	@Test
	public void verifyRegisterField() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Mahendra");
		driver.findElement(By.id("input-lastname")).sendKeys("Thatithoti");
		driver.findElement(By.id("input-email")).sendKeys(genarateGmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9959948202");
		driver.findElement(By.id("input-password")).sendKeys("Mahendra@7");
		driver.findElement(By.id("input-confirm")).sendKeys("Mahendra@7");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		String expectedTitle = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedTitle);
		String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";
		
		String expectedProperDetails = driver.findElement(By.id("content")).getText();
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));
		
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
	}
	public String genarateGmail() {
		Date date = new Date();
		String datestring = date.toString();
		String noSpaceDateString = datestring.replaceAll(" ", "");
		String noColonDateString = noSpaceDateString.replaceAll(":", "");
		String emailWithTimeStamp = noColonDateString+"@gmail.com";
		return emailWithTimeStamp;
	}
}
