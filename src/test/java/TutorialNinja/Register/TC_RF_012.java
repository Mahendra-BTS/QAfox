package TutorialNinja.Register;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_012 {
	@Test
	public void verifingRegisterByUsingKeyboard() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Actions actions = new Actions(driver);
		for (int i = 1; i<=23; i++) {
			actions.sendKeys(Keys.TAB).perform();
		}
		actions.sendKeys("Mahendra").pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("Thatithoti")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(emailGenarator())
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("9959948202")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("Mahendra@7")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("Mahendra@7")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT)
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.SPACE).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();
		
		String expectedResult = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='col-sm-9']/h1")).getText(), expectedResult);
		
		driver.quit();
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
