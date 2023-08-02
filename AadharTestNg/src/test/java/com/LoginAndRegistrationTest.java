package com;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
        Alert alert = driver.switchTo().alert();
        alert.accept();

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
        
        Thread.sleep(6000);
        registerButton.click();

        String expectedTitle = "MaadharAppProject"; 
        String actualTitle = driver.getTitle();
        AssertJUnit.assertEquals(actualTitle, expectedTitle);
    }


}