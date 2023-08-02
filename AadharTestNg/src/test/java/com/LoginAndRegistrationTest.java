package com;


import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginAndRegistrationTest {
    private WebDriver driver;
    private String baseUrl = "http://localhost:4200"; 

   
	@BeforeMethod
	@BeforeClass
    public void setUp() {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\dasar\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
        driver = new ChromeDriver();
    }

   
	@AfterMethod
	@AfterClass
    public void tearDown() {
        driver.quit();
    }
    
    @Test(priority = 1)
    public void Launch() {
    	driver.get(baseUrl);
    }

    @Test(priority = 2)
    public void testValidLogin() throws InterruptedException {
    	String url="http://localhost:4200/login";
        driver.get(url);
        WebElement phoneInput = driver.findElement(By.id("phone"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        phoneInput.sendKeys("7435356343");
        passwordInput.sendKeys("123456");
        loginButton.click();
        Thread.sleep(2000);
     

        String expectedTitle = "MaadharAppProject"; 
        String actualTitle = driver.getTitle();
        AssertJUnit.assertEquals(actualTitle, expectedTitle);
        
       
    }



    @Test(priority = 3)
    public void testValidRegistration() throws InterruptedException {
    	String url="http://localhost:4200/sign";
        driver.get(url);
        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement phoneInput = driver.findElement(By.id("phone"));
        WebElement registerButton = driver.findElement(By.cssSelector("button[type='submit']"));

        nameInput.sendKeys("John Doe");
        emailInput.sendKeys("johndoe@example.com");
        passwordInput.sendKeys("123456");
        phoneInput.sendKeys("1234567890");
        
  JavascriptExecutor js = (JavascriptExecutor) driver;

        
        for (int i = 0; i < 6; i++) {
            js.executeScript("window.scrollBy(0,200)", "");
            System.out.println("System Scrolling " + i);
        }
        
        Thread.sleep(6000);
        registerButton.click();

        String expectedTitle = "MaadharAppProject"; 
        String actualTitle = driver.getTitle();
        AssertJUnit.assertEquals(actualTitle, expectedTitle);
    }
    
    
    @Test(priority = 4)
    public void testNewAadharCardApplication() throws InterruptedException {
    	String url="http://localhost:4200/service";
        driver.get(url);
        WebElement applyButton = driver.findElement(By.cssSelector(".btn.bt-info.button"));
        applyButton.click();
 
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        

        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.sendKeys("John Doe");

        WebElement dobInput = driver.findElement(By.name("date"));
        dobInput.sendKeys("1990-01-01");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("johndoe@example.com");

        WebElement addressInput = driver.findElement(By.name("aadrees"));
        addressInput.sendKeys("123 Main St");

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys("1234567890");
        
        Thread.sleep(6000);
        
        for(int i=0; i<6 ; i++) {
            js.executeScript("window.scrollBy(0,600)", "");
            System.out.println("System Scrolling "+ i);
        }

        WebElement genderMaleInput = driver.findElement(By.id("male"));
        genderMaleInput.click();
        js.executeScript("window.scrollBy(0,450)", "");

        
        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        Thread.sleep(2000);
        submitButton.click();
        
      

    }


}