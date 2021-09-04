package week4.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Mouse hover on Testleaf Courses and print all the following links
		WebElement testLeaf=driver.findElement(By.linkText("TestLeaf Courses"));
		Actions builder=new Actions(driver);
		builder.moveToElement(testLeaf).perform();
		
			
		List<WebElement> course = driver.findElements(By.className("listener"));
		for (WebElement webElement1 : course) {
			String courseName =webElement1.getText();
			System.out.println(courseName);
			
		}
		
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		//String text=alert.getText();
		alert.accept();
		//driver.close();

	}

}
