package com.flipkart;

import org.testng.annotations.Test;




import org.testng.asserts.SoftAssert;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;



public class flipkart {
	public  WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();

	
	@Test
	public static void launch() throws InterruptedException {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\dasar\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
		String url = "https://www.flipkart.com/";
	
		 WebDriver driver = new ChromeDriver();
	
	
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    boolean isFooterPresent = driver.findElements(By.cssSelector("footer")).size() > 0;
	    System.out.println("Footer Present: " + isFooterPresent);

	
		  
		System.out.println("Flipkart Launched");
		driver.quit();	}
	
  @Test
	public static void search() throws IOException,InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  String url = "https://www.flipkart.com/";
	  driver.get(url);
	  WebElement search = driver.findElement(By.name("q"));
		System.out.println("search Element " + search);
		search.sendKeys("iphone 13"+Keys.ENTER);
		System.out.println("Search Iphone 13 and Clicked Enter");
		System.out.println("Iphone 13 Mobiles will display");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		
		// scrolling 
		
		for(int i = 0 ; i < 22 ; i++) {
		js.executeScript("window.scrollBy(0,350)", " ");
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("E://test-selenium/ss"+i+".jpg");
		Files.copy(source, destinationFile);
		System.out.println("Taking Screen Shot");
		if(source != null) {
			System.out.println("image is downloaded just before the user scrolls to its position and gets displayed in time");
		}else {
			System.out.println("image is not downloaded");
		}
		
		System.out.println("Scrolling");
		}
		
		for(int i = 0 ; i < 22 ; i++) {
			js.executeScript("window.scrollBy(0,-350)", " ");
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			
			File destinationFile = new File("E://test-selenium/Scrollss"+i+".jpg");
			Files.copy(source, destinationFile);
			System.out.println("Taking Screen Shot");
			if(source != null) {
				System.out.println("image is downloaded just before the user scrolls to its position and gets displayed in time");
			}else {
				System.out.println("image is not downloaded");
			}
			
			System.out.println("Scrolling");
			
		}
		driver.quit();
		
				
	}
  
  @Test
  public void testPageScrollFeature() {
	  
	  WebDriver driver = new ChromeDriver();
	  String url="https://flipkart.com";
	  driver.get(url);

      JavascriptExecutor js = (JavascriptExecutor) driver;
      long totalPageHeight = (Long) js.executeScript("return Math.max( document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight );");

      long viewportHeight = (Long) js.executeScript("return window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;");

      boolean hasScrollFeature = totalPageHeight > viewportHeight;

      SoftAssert softAssert = new SoftAssert();
      softAssert.assertEquals(hasScrollFeature, true);
      
  	driver.quit();
  }
  
  @Test
  public static void performancetestForLaunchingPage() {
	  WebDriver driver = new ChromeDriver();
	  ChromeOptions options = new ChromeOptions();
	  
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-extensions"); 

	  
	  String url="https://www.flipkart.com";
	  driver.get(url);
	  
	  long startTime = System.currentTimeMillis();

	  long waitTimeInMillis = 5000; 
      try {
          Thread.sleep(waitTimeInMillis);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      long endTime = System.currentTimeMillis();
      
      System.out.println("startTime in currentTimeMillis: "+  startTime);
      System.out.println("endTime in currentTimeMillis: "+ endTime);

      long pageLoadTimeInMillis = endTime - startTime;
      System.out.println("Page Load Time: " + pageLoadTimeInMillis + " milliseconds");
  	driver.quit();
  }
  
  @Test
  public static void performanceTestingForSearchProduct() {
	  
	  WebDriver driver = new ChromeDriver();
	  
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-extensions"); 

	  
	  String url="https://www.flipkart.com";
	  driver.get(url);
	  
	  WebElement search = driver.findElement(By.name("q"));
		System.out.println("search Element " + search);
		search.sendKeys("iphone 13"+Keys.ENTER);
	  
	  long startTime = System.currentTimeMillis();

	  
	  long waitTimeInMillis = 2000; 
      try {
          Thread.sleep(waitTimeInMillis);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }	 
	  

      long endTime = System.currentTimeMillis();
      
      System.out.println("startTime in currentTimeMillis: "+  startTime);
      System.out.println("endTime in currentTimeMillis: "+ endTime);

      long pageLoadTimeInMillis = endTime - startTime;
      System.out.println("Page Load Time: " + (pageLoadTimeInMillis) + " milliseconds");
	  
  	driver.quit();
  }
  
  @Test
  
  public static void VisibleImagesWithinHeight() {
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("--no-sandbox"); 
      options.addArguments("--disable-extensions"); 

      WebDriver driver = new ChromeDriver(options);

      String url = "https://www.flipkart.com/search?q=iphone%2013&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off"; 
      driver.get(url);

      List<WebElement> imageElements = driver.findElements(By.className("_396cs4"));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      
      if (!imageElements.isEmpty()) {
          System.out.println("Total Images Found: " + imageElements.size());

          long viewportHeight = (long) ((JavascriptExecutor) driver).executeScript("return window.innerHeight;");
          
          
          for (int i = 0; i < imageElements.size(); i++) {
        	  js.executeScript("window.scrollBy(0,250)", " ");
              WebElement imageElement = imageElements.get(i);
              
            
              boolean isLoadedAndVisible = (boolean) ((JavascriptExecutor) driver).executeScript(
                      "var rect = arguments[0].getBoundingClientRect();\n" +
                              "return (rect.top >= 0 && rect.bottom <= " + viewportHeight + ");", imageElement);

              if (isLoadedAndVisible) {
                  System.out.println("Image #" + (i + 1) + " is loaded and visible within the screen height.");

                  String altText = imageElement.getAttribute("alt");
                  System.out.println("Alt Text: " + altText);

                  String srcURL = imageElement.getAttribute("src");
                  System.out.println("Image Source URL: " + srcURL);

              
              } else {
                  System.out.println("Image #" + (i + 1) + " is not loaded or not visible within the screen height.");
              }
          }
      } else {
          System.out.println("No images found with the class name _396cs4.");
      }
  	driver.quit();
  }
  
  
  @Test
  public static void pageHasAScrollFeature() {
	  
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("--no-sandbox"); 
      options.addArguments("--disable-extensions"); 

      WebDriver driver = new ChromeDriver(options);

      String url = "https://www.flipkart.com/search?q=iphone%2013&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off"; 
      driver.get(url);
	  
      long pageHeight = (long) ((JavascriptExecutor) driver).executeScript("return Math.max( document.body.scrollHeight, " +
              "document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, " +
              "document.documentElement.offsetHeight );");

      long viewportHeight = (long) ((JavascriptExecutor) driver).executeScript("return window.innerHeight;");

      SoftAssert softAssert = new SoftAssert();  
      softAssert.assertTrue(pageHeight > viewportHeight, "The page does not have a scroll feature.");
    System.out.println("The page has Scroll feature");
    driver.quit();
  }
  
  @Test
  public void bottomPage() throws InterruptedException {

	  
	  WebDriver driver = new  ChromeDriver();

      String url = "https://www.flipkart.com/search?q=iphone%2013&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off"; 
      driver.get(url);
      
      Thread.sleep(4000);
	  WebElement elements = driver.findElement(By.className("_3-dnWo"));
	  
	  
	  softAssert.assertEquals("About", elements.getText());
	  
	  System.out.println(elements.getText());
	  
	  Actions action = new Actions(driver);
	  action.scrollToElement(elements);
	
	  
	     JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	        Thread.sleep(4000);

	        softAssert.assertTrue(elements.isDisplayed());
	        System.out.println("Bottom page");
	  
	  
	  
  }
  
	

  
  
}
