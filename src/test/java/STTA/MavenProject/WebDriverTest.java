package STTA.MavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverTest {
 WebDriver driver;
 String pagetitle;
 
  @Test
  public void googleSearch() throws InterruptedException {
   driver = new FirefoxDriver();
   
   driver.get("https://www.google.co.in");
   
   //Get and print page title before search.
   pagetitle = driver.getTitle();
   System.out.println("Page title before search : "+pagetitle);
   
   //Search with Hello World on google.
   WebElement Searchbox = driver.findElement(By.xpath("//input[@name='q']"));
   Searchbox.sendKeys("selenium");
   Searchbox.submit();
   Thread.sleep(5000);
   //Get and print page title after search.
   pagetitle = driver.getTitle();
   System.out.println("Page title after search : "+pagetitle);
   
   //Get list of search result strings.
   List<WebElement> allSearchResults=driver.findElements(By.cssSelector("ol li h3>a"));

   //Iterate the above list to get all the search titles & links from that page.
   for(WebElement eachResult : allSearchResults) {
   System.out.println("Title : "+eachResult.getText()+", Link : "+eachResult.getAttribute("href"));
   
   //  driver.quit();
   
  }
}
}