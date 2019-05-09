package example;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class NewTest {		
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
      driver = new ChromeDriver();
    baseUrl = "http://127.0.0.1/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWeb() throws Exception {
    driver.get(baseUrl + "//wtlab108/index.html");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("1");
    driver.findElement(By.id("account")).clear();
    driver.findElement(By.id("account")).sendKeys("108");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("108");
    driver.findElement(By.xpath("//input[@value='Log in']")).click();
    Thread.currentThread().sleep(1000);
    driver.findElement(By.cssSelector("a > h2")).click();
    Thread.currentThread().sleep(1000);
    driver.findElement(By.cssSelector("#block2 > a > div.abgne_tip_gallery_block > a > img.img-responsive")).click();
    driver.findElement(By.id("cartSub")).click();
    driver.findElement(By.id("cash")).click();
    driver.findElement(By.cssSelector("div.inputGroup.B > label")).click();
    driver.findElement(By.id("checkOut")).click();
  }

  @AfterClass(alwaysRun = true)
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
