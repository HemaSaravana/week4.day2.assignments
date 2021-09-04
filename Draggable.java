package week4.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);
		
		Actions builder=new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		builder.dragAndDropBy(source, 150, 80).perform();
		
        //WebElement source = driver.findElement(By.id("draggable"));
		
		//Actions builder=new Actions(driver);
		
		//WebElement desti = driver.findElement(By.tagName("body"));
		
		//builder.dragAndDrop(findElement, desti).perform();
		
		//driver.close();

		
	}

}
