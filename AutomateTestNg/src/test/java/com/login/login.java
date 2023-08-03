package com.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class login {
SoftAssert softAssert;
WebDriver driver;



@Test
public void launch() {
	

WebDriver driver = new ChromeDriver();
String url = "http://localhost:4200/";
driver.get(url);
}
@Test 
public void loginPage() throws InterruptedException {
WebDriver driver = new ChromeDriver();
String url=("http://localhost:4200/login");
driver.get(url);
System.out.println(driver.getTitle());
WebElement email = driver.findElement(By.name("email"));
email.click();
email.sendKeys("admin@gmail.com");
System.out.println(email.getText()+"logindetails");
WebElement password = 
driver.findElement(By.name("password"));
password.click();
password.sendKeys("1234");
WebElement login = 
driver.findElement(By.id("loginButton"));
login.click();
}
@Test
public void loginerror() {
WebDriver driver = new ChromeDriver();
String url=("http://localhost:4200/login");
driver.get(url);
WebElement email = 
driver.findElement(By.name("email"));
email.click();
email.sendKeys("user@gmail.com");
System.out.println(email.getText()+"logindetails");
WebElement password = 
driver.findElement(By.name("password"));
password.click();
password.sendKeys("123232");
WebElement login = 
driver.findElement(By.id("loginButton"));
login.click();
WebElement errormsg = 
driver.findElement(By.id("errormsg"));
System.out.println("Error Message "+ 
errormsg.getText());
}
@Test
public void RegistrationTest() {
WebDriver driver = new ChromeDriver();
String url=("http://localhost:4200/register");
driver.get(url);
System.out.println(driver.getTitle());
WebElement username = 
driver.findElement(By.name("username"));
username.click();
username.sendKeys("user");
WebElement email = driver.findElement(By.name("email"));
email.click();
email.sendKeys("user@gmail.com");
WebElement password = 
driver.findElement(By.name("password"));
password.click();
password.sendKeys("1234");
WebElement registerButton = 
driver.findElement(By.id("register"));
registerButton.click();
WebElement alreadyLink = 
driver.findElement(By.id("already"));
alreadyLink.click();
}
@Test
public void AddToCart () throws InterruptedException {
WebDriver driver = new ChromeDriver();
String url = "http://localhost:4200";
driver.get(url);
Thread.sleep(15000);
WebElement Addbutton = 
driver.findElement(By.name("Addbutton"));
Addbutton.click();
System.out.println("AddButton is Clicked");
System.out.println(Addbutton);
WebElement cart = driver.findElement(By.id("cart"));
Thread.sleep(10000);
cart.click();
System.out.println("cart is Clicked");
}
@Test
public void Search() throws InterruptedException {
WebDriver driver = new ChromeDriver();
String ur="http://localhost:4200/search";
driver.get(ur);
WebElement searchInput = 
driver.findElement(By.name("search"));
searchInput.sendKeys("electronics");
WebElement searchButton = 
driver.findElement(By.name("searchButton"));
Thread.sleep(2000);
searchButton.click();
Thread.sleep(2000);
}
 @Test(dataProvider = "dp")
 public void f(Integer n, String s) {
 }
 @BeforeMethod
 public void beforeMethod() {
 }
 @AfterMethod
 public void afterMethod() {
 }
 @DataProvider
 public Object[][] dp() {
 return new Object[][] {
 new Object[] { 1, "a" },
 new Object[] { 2, "b" },
 };
 }
 @BeforeClass
 public void beforeClass() {
 }
 @AfterClass
 public void afterClass() {
 
 }
 @BeforeTest
 public void beforeTest() {
 }
 @AfterTest
 public void afterTest() {
 }
 @SuppressWarnings("deprecation")
@BeforeSuite
 public void beforeSuite() {
	
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setPlatform(Platform.WIN11);
	        caps.setBrowserName("chrome");

	        try {
	            driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	    

 }
 @AfterSuite
 public void afterSuite() {
 }
}
