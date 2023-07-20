package com.ExternalElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingNewTabs {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		String url= "www.demoWebsiteName.com";
		driver.get(url);
		
		driver.findElement(By.id("Xyz")).sendKeys(Keys.CONTROL+"t");
		
		driver.findElement(By.id("Xyz")).sendKeys(Keys.CONTROL+"w");
		
		
	}
}
