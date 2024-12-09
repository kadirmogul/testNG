import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class amazonAddtoCart {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test()
    public void test01(){
      driver.get("https://www.amazon.com.tr/");
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
      WebElement resultWE=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
      Assert.assertTrue(resultWE.isDisplayed());
    }
    @Test(dependsOnMethods = "test01")
    public void test02(){

        driver.findElement(By.id("sp-cc-accept")).click();
        driver.findElement(By.xpath("//div[@data-component-id='7']")).click();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        String count=driver.findElement(By.id("nav-cart-count")).getText();
        System.out.println(count);
        Assert.assertFalse(count.equals("0"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
