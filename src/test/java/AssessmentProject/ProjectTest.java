package AssessmentProject;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class ProjectTest {
	
	ChromeOptions options = new ChromeOptions();
    WebDriver driver;
     @BeforeTest
      public void beforeTest() {
         System.setProperty("webdriver.chrome.driver", "D:\\Project\\Assessment\\driver\\chromedriver.exe");
         
         driver = new ChromeDriver();
          driver.get("https://tms.pisystindia.com/admin/login");
          
          driver.manage().window().maximize();
          
          
      }
  @Test(priority=1)
  public void f() {
      
      String title = driver.getTitle();
      AssertJUnit.assertEquals(title,"Tool Management System");
  }
  @Test(priority=2)
  public void f1() throws InterruptedException {
      
      driver.findElement(By.cssSelector("input[type='email']")).sendKeys("sales.infinitycorp@gmail.com");
      
      driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123456");
      
      driver.findElement(By.cssSelector("button[class*='btn btn-outline-primary btn-flat m-b-30 m-t-30']")).click();
      Thread.sleep(1000);
  }
  
  @Test(priority=3)
  public void find_tools_utility() {
	  driver.findElement(By.cssSelector("a[class*='sidebar-sub-toggle'] i[class*='fa-solid fa-compass-drafting']")).click();
	  driver.findElement(By.xpath("//a[text()='Tools']")).click();
	  
	  
  }
  @Test(priority=4)
  public void add_tool() throws InterruptedException  {
	  driver.findElement(By.xpath("//a[text()='Add Tool']")).click();
	  driver.findElement(By.id("tool_no")).sendKeys("1788");
	  driver.findElement(By.id("tool_name")).sendKeys("Aradhya");
	  driver.findElement(By.id("tool_make")).sendKeys("Iron");
	  driver.findElement(By.id("tool_price")).sendKeys("500");
	  driver.findElement(By.id("tool_service_price")).sendKeys("373");
	  Select s = new Select(driver.findElement(By.id("select_tool_type")));
	  s.selectByIndex(1);
	  driver.findElement(By.id("tool_description")).sendKeys("Latest Tool");
	  driver.findElement(By.id("other")).sendKeys("Not Required");
	  driver.findElement(By.xpath("//button[text()='Add']")).click();
	  Thread.sleep(2000);
	  driver.navigate().back();
  }
  
  @Test(priority=5)
  public void search_tool() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("C342");
	  driver.findElement(By.xpath("//a[@class=\"fa-solid fa-pen-to-square text-blue\"]")).click();
//	  Hence we get desired output
	  Thread.sleep(3000);
	  
  }
  
  @AfterTest
  public void Logout() {
	  driver.quit();
  }
}
