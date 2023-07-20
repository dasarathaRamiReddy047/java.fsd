package com.HandlingWebElemets;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;

public class HandlingWebElements {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		String url="file:///C:/Users/html.html";
		driver.get(url);
		
		//link 
		
	WebElement link = driver.findElement(By.linkText("Link"));
		link.click();
		
		boolean exists  = link.isDisplayed();
		System.out.println("is link exist?" + exists);
			
		boolean isEnable = link.isEnabled();
		System.out.println(isEnable);
			
		String linkName = link.getText();
		System.out.println(linkName);

	
	// button
	
	WebElement button = driver.findElement(By.tagName("button"));
	button.click();
	
	button.isEnabled();
	button.isDisplayed();
	
	//image
	
	WebElement tagimage  = driver.findElement(By.tagName("image"));
	WebElement idimage = driver.findElement(By.id("imageId"));
	WebElement classImage = driver.findElement(By.className("imageClass"));
	
	
	tagimage.click();
	tagimage.isDisplayed();
	tagimage.getAttribute("src");
	
	WebElement imageButton = driver.findElement(By.id("imageButton"));
	imageButton.click();
	
	WebElement imageLink = driver.findElement(By.id("imageLink"));
	imageLink.click();
	
	// text
	
	WebElement textarea  = driver.findElement(By.tagName("teatarea"));
	textarea.getText();
	
	// checkBox
	
	WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
	checkbox.isDisplayed();
	checkbox.isEnabled();
	checkbox.isSelected();
	checkbox.click();
	
	
	// Radio 
	
	WebElement radio = driver.findElement(By.cssSelector("input[type='radio']"));
	radio.isDisplayed();
	radio.isEnabled();
	radio.isSelected();
	
	// dropdown
	
	WebElement dropdown = driver.findElement(By.id("dropdownId"));
	Select select = new Select(dropdown);

	dropdown.isEnabled();
	dropdown.isDisplayed();

	select.selectByVisibleText("option");
	select.getOptions().size();
	select.selectByIndex(1);
	
	
	  WebElement table = driver.findElement(By.tagName("table"));
	 


	// iframe
      
      WebElement iframeEl = driver.findElement(By.tagName("iframe"));
      iframeEl.click();
      driver.switchTo().frame("iframeEl");
      driver.switchTo().frame("id of the element");
      
      
      //tab
   WebElement tab1 =  driver.findElement(By.tagName("body"));
   tab1.sendKeys(Keys.CONTROL + "t");
   
  
      
   ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
   driver.switchTo().window(tabs.get(1));
   driver.get("https://www.google.com");
   driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "\t");
   driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "\t");

   driver.switchTo().window(tabs.get(0));
	
      
	}

}
