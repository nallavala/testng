package ApplicationAccess;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Lists;

public class Start {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\cool\\eclipse-workspace\\TestingBrowser\\drivers\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String List[]= {"Cucumber","Apple"};
	int a=0;
	List<String> NewProd= Arrays.asList(List);
 	List<WebElement> Products=driver.findElements(By.xpath("//h4[@Class='product-name']"));
	for(int i=0;i<Products.size();i++) {
		//System.out.println(Products.get(i).getText());
	 String[] Prod = Products.get(i).getText().trim().split("-");
	 String TrimProd=Prod[0].trim();
	 //System.out.println(TrimProd);	
	  if(NewProd.contains(TrimProd)){
	 a++;
		driver.findElements(By.xpath("//*[contains(text(),'ADD TO CART')]")).get(i).click();
		 if(a==List.length) { 
			 break; 
			 }
	  }	 
	}
	driver.findElement(By.xpath("//a[@Class='cart-icon']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	
	Select dropdown=new Select(driver.findElement(By.xpath("//select")));
	dropdown.selectByVisibleText("India");
	driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
	
	}
}
	


	//driver.close();
	
	


