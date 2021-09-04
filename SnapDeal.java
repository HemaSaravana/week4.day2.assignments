package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Go to Mens Fashion
		WebElement menFashion = driver.findElement(By.xpath("(//span[contains(text(),'Fashion')])[3]"));

		Actions builder = new Actions(driver);
		builder.moveToElement(menFashion).perform();

		// Go to sports shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		Thread.sleep(2000);

		// Get the count of the sports shoes
		String sportsShoesCount = driver.findElement(By.xpath("//span[@class='category-count']")).getText();
		System.out.println(sportsShoesCount);
		Thread.sleep(2000);

		// Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);

		// Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/following-sibling::ul/li[2]")).click();
		Thread.sleep(5000);

		// Mouse Hover on puma Blue Training shoes
		WebElement mouseHover = driver.findElement(By.xpath("//p[text()='JAGROON RUNNER Green Training Shoes']"));
		builder.moveToElement(mouseHover).perform();
		Thread.sleep(2000);

		// click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		Thread.sleep(2000);

		// Print the cost and the discount percentage
		String cost = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span"))
				.getText();
		String discountPercent = driver
				.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[2]")).getText();
		System.out.println("Price : " + cost + " " + "Discount Percentage : " + discountPercent);

		// 11. Take the snapshot of the shoes.
		//File src = driver.getScreenshotAs(OutputType.FILE);
		//File dest = new File("./snaps/shoes.png");
		//FileUtils.copyFile(src, dest);
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/shoes.png");
		FileUtils.copyFile(src1, dst);

		// Close the current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']/i")).click();
		Thread.sleep(500);

		// Close the main window
		driver.close();

	}

}
