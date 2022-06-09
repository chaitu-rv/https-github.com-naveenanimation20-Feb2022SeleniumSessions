package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//parent window
		String parentWindowId = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);//sel 4.x feature
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);//sel 4.x feature
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		
		
		
	}

}
