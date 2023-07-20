package com.cssAndXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssAndXpath {
	
	public static void main(String[] args) {
		
		WebDriver driver  = new ChromeDriver();
		String url="https://www.google.com/";
		driver.get(url);
		
		//tag and id
		driver.findElement(By.cssSelector("input#email"));
		
		// tag and class
		
		driver.findElement(By.cssSelector("input.inputtext"));
		
		// tag and attribute
		
		driver.findElement(By.cssSelector("input[name=lastName]"));
		
		// tag and class attribute
		
		driver.findElement(By.cssSelector("input.inputtext[tabindex=1]"));
		
		// inner text
		driver.findElement(By.cssSelector(":contains('Boston')"));

		//xpath
		//absolute 
		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/h4[1]/b"));
		
		// relative
		
		driver.findElement(By.xpath("//*[@class=’relativexapath’]"));
		
	}
	
}
