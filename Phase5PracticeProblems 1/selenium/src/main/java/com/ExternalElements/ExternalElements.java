package com.ExternalElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExternalElements {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		String url= "www.demoWebsiteName.com";
		driver.get(url);
		
		
		driver.switchTo().alert().accept();
		
		//click on ‘Cancel’ button in pop up   
		driver.switchTo().alert().dismiss();
		
		//To Capure the alert message
		driver.switchTo().alert().getText();
		
		//To enter the information
		driver.switchTo().alert().sendKeys("text");
		
	
		
		
	}
}
