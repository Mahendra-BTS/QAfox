package TutorialNinja.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_002 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5km84u9k2k_e&adgrpid=155259813113&hvpone=&hvptwo=&hvadid=713930225034&hvpos=&hvnetw=g&hvrand=4715977310289058692&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062132&hvtargid=kwd-304880464215&hydadcr=14450_2402232&gad_source=1");
		driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Need help')]")).click();
		driver.findElement(By.id("auth-fpp-link-bottom")).click();
		driver.findElement(By.id("ap_email")).sendKeys("thatithotimahendra0@gmail.com");
	}
}