package com.tutorialsninjamentoring;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TuorialsNinjaSearchTest {
	public WebDriver driver;
	public SoftAssert softassert;
	
@Test
	public void searchValidProduct() throws Exception {
		
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.cssSelector("input.form-control.input-lg")).sendKeys("Hp");
		driver.findElement(By.xpath("//button[@class= 'btn btn-default btn-lg']")).click();
		softassert= new SoftAssert();
		softassert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		driver.findElement(By.xpath("//span[@class= 'hidden-xs hidden-sm hidden-md'][text()= 'Add to Cart']")).click();
	driver.findElement(By.cssSelector("button#button-cart")).click();
	String actualAdditionSuccessmessage= driver.findElement(By.xpath("//div[@class= 'alert alert-success alert-dismissible']")).getText();
    String expectedAdditionSuccessmessage= "Success: You have added ";
     softassert.assertTrue(actualAdditionSuccessmessage.contains(expectedAdditionSuccessmessage));
  Thread.sleep(1000);
      driver.findElement(By.xpath("//button[contains(@class, 'btn btn-inverse btn-block')]")).click();
     driver.findElement(By.linkText("Checkout")).click();
     driver.findElement(By.xpath("//label[@class= 'control-label'][text()= 'E-Mail']/following-sibling::input[1]")).sendKeys("sarakhalifa491@gmail.com");
     driver.findElement(By.cssSelector("input#input-password")).sendKeys("Saraselenium@123");
     driver.findElement(By.xpath("//input[@class= 'btn btn-primary'][@id= 'button-login']")).click();
     driver.findElement(By.cssSelector("input#button-payment-address")).click();
     driver.findElement(By.cssSelector("input#button-shipping-address")).click();
     driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("leave by the door");
     driver.findElement(By.cssSelector("input#button-shipping-method")).click();
     Thread.sleep(1000);
     driver.findElement(By.cssSelector("a.agree+input")).click();
     driver.findElement(By.cssSelector("a.agree+input+input")).click();
     driver.findElement(By.cssSelector("input#button-confirm")).click();
   
   
     
     softassert.assertAll();





}

}
