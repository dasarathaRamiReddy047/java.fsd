package com.ecommerce.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;


import org.testng.asserts.SoftAssert;

public class FBRegistration2 {
	public WebDriver driver;
	public String baseUrl = "file:///C:/Users/dasar/html.html";

	SoftAssert softAssert =  new SoftAssert();
	
	@Test(groups = { "Google", "Account Creation" })
	public void searchGoogleAndTestTitleText() {
		System.out.printf("Inside %s and thread-id is %s \n", "searchGoogle", Thread.currentThread().getId());

		driver.get("http://www.google.com");

		System.out.println("Title of google page is " + driver.getTitle());
		
		AssertJUnit.assertEquals(driver.getTitle(), "Google");
		

		softAssert.assertAll("Google title did not match");		
	}
	
	@Test(groups = { "Dummy" }, dependsOnGroups = { "Account Creation" })
	public void f1() {
		System.out.printf("Inside %s and thread-id is %s \n", "f1", Thread.currentThread().getId());
	}

	@Test(enabled = false, dependsOnMethods = {"testLocalPage"})
	public void f2() {
		System.out.printf("Inside %s and thread-id is %s \n", "f2", Thread.currentThread().getId());
	}

	@Test()
	public void testLocalPage() {
		System.out.printf("Inside %s and thread-id is %s \n", "testLocalPage", Thread.currentThread().getId());

		driver.get(baseUrl);

		WebElement selectMonthElement = driver.findElement(By.id("month"));
		Select selectMonth = new Select(selectMonthElement);

		System.out.println("selectMonth is muti select " + selectMonth.isMultiple());

		selectMonth.selectByIndex(0);
		selectMonth.selectByIndex(6);

		List<WebElement> optionsList = selectMonth.getAllSelectedOptions();

		for (WebElement option : optionsList)
			System.out.println("selectMonth selected options are " + option.getText());
	}

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
		System.out.printf("Inside %s and thread-id is %s \n", "afterSuite", Thread.currentThread().getId());
		driver.quit();
	}

}
