package TutorialNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_006 {
	@Test
	public void verifingAccountIsSubscribed() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Mahendra");
		driver.findElement(By.id("input-lastname")).sendKeys("Thatithoti");
		driver.findElement(By.id("input-email")).sendKeys(BrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9959948202");
		driver.findElement(By.id("input-password")).sendKeys("Mahendra@7");
		driver.findElement(By.id("input-confirm")).sendKeys("Mahendra@7");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
 		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).isSelected());
		
		driver.quit();
	}
	public String BrandNewEmail() {
		Date date = new Date();
		String datestring = date.toString();
		String noSpaceDateString = datestring.replaceAll(" ", "");
		String noColonDateString = noSpaceDateString.replaceAll(":", "");
		String emailWithTimeStamp = noColonDateString+"@gmail.com";
		return emailWithTimeStamp;
	}
}