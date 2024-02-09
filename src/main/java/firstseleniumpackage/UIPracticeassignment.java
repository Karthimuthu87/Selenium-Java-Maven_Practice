package firstseleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UIPracticeassignment {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srini\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.name("name")).sendKeys("Karthika123");
		driver.findElement(By.name("email")).sendKeys("Karthimuthu187@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password123");
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.id("exampleCheck1")).click();
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")));
		
		select.selectByVisibleText("Female");
				//driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1'][2]")).click();
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("1987-11-11");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		js.executeScript("window.scrollBy(1000,0)");
		//System.out.println(driver.findElement(By.cssSelector("div.alert-success")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert-success")).getText()," Success! The Form has been submitted successfully!." );
	    Thread.sleep(5000);
	    driver.close();
	
	}

}
