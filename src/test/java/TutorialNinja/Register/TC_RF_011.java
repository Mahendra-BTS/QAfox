// there is a bug in the test case
package TutorialNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_011 {
		WebDriver driver;
		@AfterMethod
		public void closeWindow() {
			driver.quit();
		}
		@Test
		public void verifingRegisterByProvidingInvalidNumber() {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("input-firstname")).sendKeys("Mahendra");
			driver.findElement(By.id("input-lastname")).sendKeys("Thatithoti");
			driver.findElement(By.id("input-email")).sendKeys(emailGenarator());
			driver.findElement(By.id("input-telephone")).sendKeys("abcd");
			driver.findElement(By.id("input-password")).sendKeys("Mahendra@7");
			driver.findElement(By.id("input-confirm")).sendKeys("Mahendra@7");
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			String expectedWarning = "Invalid phone number!";
			
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedWarning);
		}
		public String emailGenarator() {
			Date date = new Date();
			String dateString = date.toString();
			String dateStringWithoutSpace = dateString.replace(" ", "");
			String dateStringWithoutColon = dateStringWithoutSpace.replace(":", "");
			String mail = dateStringWithoutColon+"@gmail.com";
			return mail;
		}
}
