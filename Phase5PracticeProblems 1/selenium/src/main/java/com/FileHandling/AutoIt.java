package com.FileHandling;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIt {
	public static void main(String[] args) throws Exception {
	
			demoFileUpload();

	}
	
	static void demoFileUpload() throws InterruptedException, IOException{
		WebDriver driver =  new ChromeDriver();
	String url="https://demoqa.com/automation-practice-form";
	driver.get(url);
	Thread.sleep(1000);
	WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
	uploadElement.click();
	
	System.out.println(uploadElement);

	}
}
