package com.tutorialsninjamentoring;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TryTestingThisTest {
	public WebDriver driver;
	public Select select;
	@Test
	public void openUrl() {
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		driver.get("https://trytestingthis.netlify.app/");
		driver.findElement(By.cssSelector("label[for= fname]+br+input")).sendKeys("sara");
		driver.findElement(By.xpath("//label[text()= 'Gender:']/preceding-sibling::input[1]")).sendKeys("mahgoub");
		driver.findElement(By.cssSelector("input#female")).click();
		select= new Select(driver.findElement(By.cssSelector("select#option")));
		select.selectByVisibleText("Option 1");
		
		
		
	}

}
