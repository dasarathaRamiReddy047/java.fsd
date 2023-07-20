package com.to.testCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
    
   public  SoftAssert soft = new SoftAssert();
  public  WebDriver driver;
    @Test
    public void Launch() {
    
     WebDriver  driver = new ChromeDriver();
     String url = "https://www.google.com";
     driver.get(url);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = { "Launch" })
    public void Facebook() {
    	WebDriver driver = new  ChromeDriver();
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
        AssertJUnit.assertEquals("Facebook", driver.getTitle());   
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    @Test(dependsOnMethods = { "Facebook" })
    public void Login() {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("ravi10thstudent@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("12345");
        WebElement button= driver.findElement(By.id("loginbutton"));
        button.click();
        soft.assertAll();
        
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
     

    }
}
