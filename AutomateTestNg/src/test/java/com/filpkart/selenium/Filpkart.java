package com.filpkart.selenium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Filpkart{
	
	public static void main(String[] args) {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\dasar\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
	   WebDriver driver =  new ChromeDriver();
	   String url="https://www.flipkart.com/";
	   launch(url,driver);
	    search(driver);
	  
	}
	
	@Test
	public static void launch(String url,WebDriver driver) {
	
		   driver.get(url);
		   System.out.println("Launched Filpkart");
		
	}
	
	@Test
	public static void search(WebDriver driver) {
		WebElement searchEl = driver.findElement(By.name("q"));
		 searchEl.sendKeys("iPhone 13" + Keys.ENTER);
		 System.out.println("searched iphone 13");


		
	}
	

}