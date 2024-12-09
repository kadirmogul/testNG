package com.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class trendyolAddtoCart extends BaseTest{

    @Parameters ({"browser"})
     public void setUp(String browser){

        switch (browser){
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            break;
        case "edge":
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            break;
            default:
                try {
                    throw new IllegalAccessException("hatalı browser verisi");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().window().maximize();

    }
    @Test(priority = 1, description = "Arama sonucu",timeOut = 10000, invocationCount = 1)
    public void test01(){
        driver.get("https://www.trendyol.com/");
       WebElement searchButton= driver.findElement(By.className("V8wbcUhU"));
        searchButton.sendKeys("iphone 16 telefon");
        searchButton.sendKeys(Keys.ENTER);
        String actualDate="sonuç listeleniyor";
        String expectedData=driver.findElement(By.className("dscrptn-V2")).getText();
        softAssert.assertTrue(expectedData.toLowerCase().contains((actualDate).toLowerCase()));
    }
    @Test(priority = 2, description = "Sepete ekleme")
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//div[@data-id='857296083']")).click();
        List<String> tabs = new java.util.ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement acceptButton= driver.findElement(By.className("onboarding-popover__default-renderer-primary-button"));
        Assert.assertTrue(acceptButton.isDisplayed());
        Actions actions = new Actions(driver);
        actions.click(acceptButton);
        actions.perform();

       WebElement buttonAdd= driver.findElement(By.className("add-to-basket-button-text"));
       Assert.assertTrue(buttonAdd.isDisplayed());
       actions.click(buttonAdd);
       actions.perform();

      String totalProduct= driver.findElement(By.className("basket-item-count-container")).getText();
        softAssert.assertFalse(totalProduct.equals("0"));

    }

}
