package com.tutorialsninjamentoring;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipKartttt {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	@Test
	public void flipkartECommerce() throws Exception {
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		prop= new Properties();
		ip= new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\tutorialsninjamentoring\\config.properties");
	prop.load(ip);	
	driver.get(prop.getProperty("flipkartUrl"));
	List<WebElement> formalShirts= driver.findElements(By.xpath("//div[@class = '_2WkVRV']"));
	System.out.println("Total formal shirts of this brand is" +formalShirts.size());
	
	List<WebElement> PricesformalShirts= driver.findElements(By.xpath("//div[@class= '_30jeq3']"));
	System.out.println("Total prices of shirts of this brand is" +PricesformalShirts.size());
	
	List<WebElement> discountformalShirts= driver.findElements(By.xpath("//div[@class = '_3Ay6Sb']"));
	System.out.println("Total discount of shirts of this brand is" +discountformalShirts.size());
	
	for (int i= 0; i<formalShirts.size(); i++) {
		System.out.println(formalShirts.get(i).getText()+ "------------------>" +PricesformalShirts.get(i).getText()+"-------->" + discountformalShirts.get(i).getText());
		
		
	}
	driver.quit();
	
	
	
		
		
		
		
		
	}

}
