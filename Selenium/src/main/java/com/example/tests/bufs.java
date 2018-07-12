package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class bufs {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  
	//if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
	  //System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.20.0-win64/geckodriver.exe");
	  System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");

	  //Now you can Initialize marionette driver to launch firefox
	  //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  //capabilities.setCapability("marionette", true);
	//driver = new FirefoxDriver(capabilities); 
	  driver = new ChromeDriver(); 
	  
    baseUrl = "http://app.bufs.ac.kr/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testBufs() throws Exception {
    driver.get(baseUrl + "food.aspx");
    WebElement element;
    new Select(driver.findElement(By.id("ddl식당"))).selectByVisibleText("교직원 식당"); 
  
    Thread.sleep(500);
    driver.findElement(By.cssSelector("option[value=\"25\"]")).click();
      
    
    element = driver.findElement(By.id("lblTitle"));
    String text = element.getText();
    System.out.println(text);      

    element = driver.findElement(By.className("tbl-type01"));
    text = element.getText();
    System.out.println(text);      
    
   
    
    new Select(driver.findElement(By.id("ddl식당"))).selectByVisibleText("학생식당 K");
    
    
    Thread.sleep(500); //시간 500밀리세컨드 동안 슬립
    
    element = driver.findElement(By.id("lblTitle"));
    text = element.getText();
    System.out.println(text); 
    
    element = driver.findElement(By.className("tbl-type01"));
    text = element.getText();
    System.out.println(text);    
    
    
    driver.findElement(By.cssSelector("option[value=\"30\"]")).click();
    new Select(driver.findElement(By.id("ddl식당"))).selectByVisibleText("학생식당 O");
   
  
    Thread.sleep(500);
    
    element = driver.findElement(By.id("lblTitle"));
    text = element.getText();
    System.out.println(text);     
    
    element = driver.findElement(By.className("tbl-type01"));
    text = element.getText();
    System.out.println(text);    
    
    driver.findElement(By.cssSelector("option[value=\"31\"]")).click();
    
    }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
