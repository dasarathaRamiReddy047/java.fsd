package com.ScreenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserProfile {

    public static void main(String[] args) {
  
    	WebDriver driver = new ChromeDriver();
    	String url= "https://www.amazon.in/";
    	driver.get(url);
     
        createFirefoxProfile("ProfileName", driver);
    }

    public static void createFirefoxProfile(String profileName, WebDriver driver) {
      

       
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-P", profileName);
        WebDriver driver1 = new FirefoxDriver(options);

     
        driver.get("about:profiles");

       
        driver.findElement(By.cssSelector("button#createProfileButton")).click();

      
        driver.findElement(By.id("profileName")).sendKeys(profileName);


        driver.findElement(By.cssSelector("button[data-dialogaccept='accept']")).click();

       
        driver.quit();
    }

  
}
