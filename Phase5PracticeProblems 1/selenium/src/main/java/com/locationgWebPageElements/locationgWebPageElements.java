package com.locationgWebPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locationgWebPageElements {
	
	public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	String url= "https://www.amazon.in/";
	driver.get(url);
	System.out.println(driver.getTitle());
	
	// id
	
	driver.findElement(By.id("Email"));
	
	// className
	driver.findElement(By.className("className"));
	
	//name 
	
	driver.findElement(By.name("name"));
	
	//LinkText 
	
	driver.findElement(By.partialLinkText("plink"));
	
	//xpath
	// relative xpath
	driver.findElement(By.xpath("[@class=relativexapth]"));	
	
	//absolute xpath
	
	driver.findElement(By.xpath("html/body/div[1]/div[1]/div/h4[1]/b"));
	
	// css 
	// tag id
	
	driver.findElement(By.cssSelector("input#email"));
	//tag.class
	
	driver.findElement(By.cssSelector("input.inputtext"));
	
	//tag and attribute
	
	driver.findElement(By.cssSelector("input[name=lastName"));
	
	
	// tag class and attribute
	
	driver.findElement(By.className("input.inputtext[tabindex=1"));
	
	//inner text
	
	driver.findElement(By.cssSelector(":contains('Boston')"));
	//xpath handling and dynamic elements
	
	driver.findElement(By.xpath("[contains(test(),sub]"));
	
	driver.findElement(By.xpath("=//*[@type=’submit’ or @name=’btnReset’]"));
			
    driver.findElement (By.xpath("//label[starts-with(@id,’message’)]"));
	
    driver.findElement (By.xpath("=//td[text()=’UserID’]"));
	
    driver.findElement(By.xpath("=//*[@type=’text’]//following::input"));

    driver.findElement(By.xpath("=//*[@type=’text’]//following::input"));


    driver.findElement (By.xpath ("//*[@type=’text’]//following-sibling::input"));
	
	
	
	
	}
	
}
