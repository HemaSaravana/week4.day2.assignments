package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraProject {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//2) Mouse hover on MeN 
		WebElement webMen=driver.findElement(By.xpath("//a[text()='Men']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(webMen).perform();
		
			
        //3) Click Jackets 
	
		
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();

	//4) Find the total count of item 

	String totalCount=driver.findElement(By.xpath("//span[@class='title-count']")).getText();
	
	String str = totalCount.replaceAll("[^0-9]", "");

	int count=Integer.parseInt(str);
	System.out.println("total count of item: " + count);


	//5) Validate the sum of categories count matches

	String num1=driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
	String str1 = num1.replaceAll("[^0-9]", "");
	int count1=Integer.parseInt(str1);
	
    String num2=driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
	String str2 = num2.replaceAll("[^0-9]", "");
	int count2=Integer.parseInt(str2);
	
	int sum=count1+count2;
    System.out.println("sum of categories: " + sum);

	if( sum == count)
	{
		System.out.println("The sum of the categories mathes the total count");
	}
	else
		System.out.println("The sum of the categories not mathes the total count");
	
	//6) Check jackets
	
	driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();

	//7) Click + More option under BRAND	

	driver.findElement(By.xpath("//div[@class='brand-more']")).click();

	//8) Type Duke and click checkbox
	WebElement text=driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']"));
	text.sendKeys("Duke");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
	Thread.sleep(5000);




	//9) Close the pop-up x
	driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
	Thread.sleep(5000);
	//10) Confirm all the Coats are of brand Duke
	//Hint : use List 
	
	List<WebElement> brand=driver.findElements(By.className("product-brand"));
	List<String> list=new ArrayList<String>();
	
    for(int i=0;i<brand.size();i++) {
    	WebElement webElement1=brand.get(i);
    	String textBrandName=webElement1.getText();
    	list.add(textBrandName);
    	}	
    	int count3=0;
    for(String webElement2:list) {
    	
    	if(list.contains("Duke")) {
    	count3=count3+1;
    	}
    }
    
    if(count3==list.size())
    {
    	System.out.println("All the coats are Duke");
    }
    else {
    	System.out.println("All the coats are not Duke");
    }
    	
    //Sort by Better Discount
    
    WebElement sortBy=driver.findElement(By.className("sort-sortBy"));

	builder.moveToElement(sortBy).perform();
    	
	
	driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
	Thread.sleep(1000);

	//12) Find the price of first displayed item

	String price=driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();

	System.out.println(" price of the first displayed item: " +price);

	//Click on the first product
	driver.findElement(By.xpath("(//li[@class='product-base'])[1]//a")).click();
	Set<String> windowHandleSet= driver.getWindowHandles();
	List<String> windowHandleList=new ArrayList<String>(windowHandleSet);
	driver.switchTo().window(windowHandleList.get(1));
	
	//Get the number of windows
	System.out.println("Number of windows: " + windowHandleList.size());
	Thread.sleep(2000);
	
	
	//13) Take a screen shot
	File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File dst = new File("./snap/myntra.png");
	FileUtils.copyFile(src1, dst);
	

	System.out.println("Screenshot page title: " + driver.getTitle());


	//14) Click on WishList Now
	driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();

	

	//15) Close Browser
	
	driver.close();
	driver.quit();
	}

}
