package week4.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement brandMouseOver = driver.findElement(By.xpath("//a[text()='brands']"));

		// Mouseover on Brands and Mouseover on Popular
		Actions builder = new Actions(driver);
		builder.moveToElement(brandMouseOver).perform();

		WebElement popularMouseOver = driver.findElement(By.xpath("//a[text()='Popular']"));
		builder.moveToElement(popularMouseOver).perform();

		// Click L'Oreal Paris
		driver.findElement(By.xpath("(//ul[@class='l-vertical-list'])/li[5]/a")).click();

		// Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		String lorealPage = driver.getTitle();
		System.out.println("Loreal Page is currently displayed");
		Thread.sleep(5000);

		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()='popularity']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);

		// Click Category and click Shampoo
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(2000);

		// check whether the Filter is applied with Shampoo
		Thread.sleep(2000);
		String filterBy = driver.findElement(By.xpath("//div[@class='filter-applied']/following-sibling::ul/li"))
				.getText();
		System.out.println("Filtered By Category : " + filterBy);
		if (filterBy.contains("Shampoo")) {
			System.out.println("Filter applied by Shampoo");
		}

		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//span[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		Thread.sleep(5000);

		// GO to the new window and select size as 175ml
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(2));
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='175ml']")).click();
		Thread.sleep(1000);

		//
		String mrp = driver.findElement(By.xpath("//div[@class='price-info']")).getText();
		System.out.println(mrp);

		// Click on ADD to BAG
		driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
		Thread.sleep(2000);

		// Go to Shopping Bag
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(5000);

		// Print the Grand Total amount
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		String grandTotalReplace = grandTotal.replaceAll("[^0-9]", "");
		System.out.println("Grand Total is : " + grandTotalReplace);

		Thread.sleep(2000);

		// Click Proceed
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		Thread.sleep(2000);

		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		Thread.sleep(2000);

		//
		String finalPrice = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		System.out.println("Final Price " + finalPrice);
		String replacePrice = finalPrice.replaceAll("[^0-9]", "");
		System.out.println(replacePrice);

		if (replacePrice.equals(grandTotalReplace)) {
			System.out.println("Price is Same");
		} else {
			System.out.println("Price is Different");
		}
		
	}

}
