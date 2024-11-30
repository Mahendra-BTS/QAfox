package TutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Temp.GenarateEmailDemo;

public class TC_RF_017 {    //we have a defect in this test scrict no warning accurs when user do not follow password privacy polacy 
	WebDriver driver;
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(dataProvider = "passwordSupplier")
	public void verifyRegisterPageWithoutFallowPasswordPolacy(String password) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Mahendra");
		driver.findElement(By.id("input-lastname")).sendKeys("Thatithoti");
		driver.findElement(By.id("input-email")).sendKeys(GenarateEmailDemo.GenarateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("3623642");
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedWarning = "Inavlid password, Please fallow password polacy";
		Assert.assertEquals(driver.findElements(By.xpath("//input[@id='input-password']/following-sibling::div")), expectedWarning);
		Assert.assertFalse(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
	}
	@DataProvider(name="passwordSupplier")
	public Object[][] passwardData() {
		Object[][] data = {{"12345"},{"qwerty"},{"asdFGHJ"},{"ASDFGHJKL"},{"12345tgnLO"}};
		return data;
	}
}
