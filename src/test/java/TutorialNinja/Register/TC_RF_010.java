package TutorialNinja.Register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {
	@Test
	public void verifingRegisterFieldIsWorkingWithInvalidmail() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Mahendra");
		driver.findElement(By.id("input-lastname")).sendKeys("Thatithoti");
		driver.findElement(By.id("input-email")).sendKeys("Mahendra");
		driver.findElement(By.id("input-telephone")).sendKeys("9959948202");
		driver.findElement(By.id("input-password")).sendKeys("Mahendra@7");
		driver.findElement(By.id("input-confirm")).sendKeys("Mahendra@7");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		File screenShot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot1, new File(System.getProperty("user.dir")+"\\Screenshot\\sc1.png"));
		
		BufferedImage actualImg1 = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshot\\sc1.png"));
		BufferedImage expectedImg2 = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshot\\Epectedsc.png"));
		
		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDiff = imgDiffer.makeDiff(expectedImg2, actualImg1);
		
		Assert.assertFalse(imgDiff.hasDiff());
		
		driver.quit();
		
	}
}
