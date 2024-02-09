package firstseleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkboxcount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.chrome.driver","C:\\Users\\srini\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		driver.quit();
	}

}
