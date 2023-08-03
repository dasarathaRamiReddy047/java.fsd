package com;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAndRegistrationTestSelenium {
   
    private String baseUrl = "http://localhost:4200";

    public static void main(String[] args) throws InterruptedException {
    	LoginAndRegistrationTestSelenium test = new LoginAndRegistrationTestSelenium();
        test.Launch();
        test.testValidLogin();
        test.testValidRegistration();
        
    }


    public void Launch() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dasar\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.quit();
        System.out.println("Launch Page");
    }

    public void testValidLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

    	String url = "http://localhost:4200/login";
        driver.get(url);
        WebElement phoneInput = driver.findElement(By.id("phone"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        phoneInput.sendKeys("9876543210");
        passwordInput.sendKeys("Abcd1234@");
      
        JavascriptExecutor js = (JavascriptExecutor) driver;

        
        for (int i = 0; i < 6; i++) {
            js.executeScript("window.scrollBy(0,200)", "");
            System.out.println("System Scrolling " + i);
        }
        
        loginButton.click();
        Thread.sleep(2000);
        System.out.println("Login Page");

  
        driver.quit();

    }

    public void testValidRegistration() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

    	String url = "http://localhost:4200/sign";
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
        System.out.println("Registration Page");
        driver.quit();


    }

 
  

}
