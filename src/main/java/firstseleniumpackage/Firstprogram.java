package seleniumSITA;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Firstprogram {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		  ChromeDriver driver = new ChromeDriver();
		  driver.get("https://fb.com");
		  driver.close();
		
	}

}

