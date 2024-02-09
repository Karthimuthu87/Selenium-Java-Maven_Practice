package firstseleniumpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\srini\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://ultimateqa.com/automation");
		 driver.manage().window().maximize();
		driver.findElement(By.linkText("Login automation")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Username");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("user@1234");
		driver.findElement(By.id("user[remember_me]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector("li.form-error__list-item")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("li.form-error__list-item")).getText(),"Invalid email or password.");
							}

}
