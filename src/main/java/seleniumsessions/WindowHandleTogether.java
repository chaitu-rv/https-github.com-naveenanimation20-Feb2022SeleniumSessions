package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleTogether {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
		String parentWindowId = driver.getWindowHandle();

		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			System.out.println(driver.getTitle());
			if(!windowID.equals(parentWindowId)) {
				driver.close();

			}
		}
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		

	}

}
