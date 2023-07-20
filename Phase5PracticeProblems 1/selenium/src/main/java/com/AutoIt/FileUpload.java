package com.AutoIt;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void main(String[] args) throws Exception {
		// Basic configuration
	
			demoFileUpload();

	}
	
	static void demoFileUpload() throws InterruptedException, IOException{
		WebDriver driver =  new ChromeDriver();
	String url="https://demoqa.com/automation-practice-form";
	driver.get(url);
	Thread.sleep(1000);
	WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
	uploadElement.click();
	uploadElement.sendKeys("\"E:\\SS.jpg\"");
	System.out.println(uploadElement);
	

	}

}
