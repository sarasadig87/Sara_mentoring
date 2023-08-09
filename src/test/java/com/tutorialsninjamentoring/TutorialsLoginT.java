package com.tutorialsninjamentoring;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TutorialsLoginT {

	public WebDriver driver;
	public SoftAssert softassert;


	@Test(dataProvider= "getData" )
	public void setUp(String email, String password)  {
		driver= new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		 driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
	        driver.findElement(By.linkText("Login")).click();
			driver.findElement(By.xpath("//label[@class= 'control-label'][text()= 'E-Mail Address']/following-sibling::input[1]")).sendKeys(email);
			driver.findElement(By.cssSelector("input[name= password]")).sendKeys(password);
			driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
			softassert= new SoftAssert();
			softassert.assertTrue(driver.findElement(By.xpath("//a[text()= 'Logout'][@class= 'list-group-item']")).isDisplayed());
			softassert.assertAll();
	
	}
	
	@DataProvider
	public  Object[][] getData() {
		
		Object[][] data= {{"sarakhalifa491@gmail.com", "Saraselenium@123"},
				{"seleniumpanda@gmail.com", "Selenium@123"},
				{"seleniumpanda1@gmail.com", "Selenium@123"},
				{"seleniumpanda2@gmail.com", "Selenium@123"},
				{"seleniumpanda3@gmail.com", "Selenium@123"},
				{"seleniumpanda4@gmail.com", "Selenium@123"},
				{"seleniumpanda5@gmail.com", "Selenium@123"},
				{"seleniumpanda6@gmail.com", "Selenium@123"},
				{"seleniumpanda7@gmail.com", "Selenium@123"},
				{"seleniumpanda8@gmail.com", "Selenium@123"},
				{"seleniumpanda9@gmail.com", "Selenium@123"},
				{"seleniumpanda10@gmail.com", "Selenium@123"}};
		return data;}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();}
}
		






