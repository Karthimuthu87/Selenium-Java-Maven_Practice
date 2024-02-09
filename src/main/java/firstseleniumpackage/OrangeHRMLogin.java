package seleniumSITA;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLogin {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		  ChromeDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 Thread.sleep(2000);
		  
		  driver.findElement(By.name("username")).sendKeys("Admin");
		  driver.findElement(By.name("password")).sendKeys("admin123");
		  driver.findElement(By.className("oxd-button")).click();
		  
		  Thread.sleep(5000);
		  driver.close();

	}

}
