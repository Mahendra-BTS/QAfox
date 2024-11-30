package TutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {
	@Test
	public void verifingNavigationWaysToRegisterPage() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String AccountText = "Register Account";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), AccountText);
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), AccountText);
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), AccountText);
		
		driver.quit();
		
	}
}
