package firstseleniumpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class signupQaAuto {
	
	public static void main (String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srini\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://ultimateqa.com/automation");
		driver.findElement(By.linkText("Login automation")).click();
	    driver.manage().window().maximize();
	    js.executeScript("window.scrollBy(0,1000)");
	    //driver.manage().window().
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href='/users/sign_up']")).click();
		System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl(), "https://courses.ultimateqa.com/users/sign_up");
	    driver.findElement(By.name("user[first_name]")).sendKeys("Karthika");
	    driver.findElement(By.name("user[last_name]")).sendKeys("Muthusamy");
	    driver.findElement(By.name("user[email]")).sendKeys("krthkmuthu@gmail.com");
	    driver.findElement(By.name("user[password]")).sendKeys("Personal@12");
	    driver.findElement(By.id("user[terms]")).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(2000);
	    
	    	}

}
