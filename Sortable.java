package week4.day2.assignments;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		
		WebElement item1=driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item5=driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		//Point location=item5.getLocation();
		//int x=location.getX();
		//int y=location.getY();
		//Actions builder=new Actions(driver);
		
		//builder.dragAndDropBy(item1, x, y).perform();
		
		File src = item1.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap/sortable.png");
		FileUtils.copyFile(src, dest);
		
		//driver.close();
//		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
//		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
//
//		Point location = item5.getLocation();
//		int x = location.getX();
//		int y = location.getY();
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		Actions builder = new Actions(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		builder.dragAndDropBy(item1, x, y).perform();
		
		Actions action = new Actions(driver);
	    List<WebElement> list = driver.findElements(By.xpath("//ul[@id='sortable']//li"));
	    WebElement target = list.get(0);
	    WebElement  destiny= list.get(4);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    action.click(target).clickAndHold().moveToElement(destiny).moveByOffset(0, 4).release().build().perform();
	}

}
		

		
		
		
		
