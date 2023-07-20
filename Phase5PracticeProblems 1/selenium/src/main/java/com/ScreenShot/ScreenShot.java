package com.ScreenShot;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenShot {
	 public static void main(String[] args ) throws IOException
	    {
	    	System.setProperty("webdriver.chrome.driver",   "C:\\Users\\Testing-L-064\\chromedriver_win32\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();
	       driver.get("https://www.flipkart.com/");
	       WebElement upload = driver.findElement(By.xpath("//*[@type='text']"));
	       upload.click();
	       TakesScreenshot ts = (TakesScreenshot)driver;
	       File scr = ts.getScreenshotAs(OutputType.FILE);
	       Files.copy(scr, new File("/Screenshot/test.png"));
	       
	       
	    }
}
