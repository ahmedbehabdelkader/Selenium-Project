package Singup;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class singup_test {

        WebDriver driver = new ChromeDriver();

    @Test()
    public void testclass()
        {

                String parent =  driver.getWindowHandle();

                driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
                driver.findElement(By.linkText("Register")).click();

                driver.findElement(By.id("input-firstname")).sendKeys("ahmed");
                driver.findElement(By.id("input-lastname")).sendKeys("mohamed");
                driver.findElement(By.id("input-email")).sendKeys("email20201@fawry.com");
                driver.findElement(By.id("input-telephone")).sendKeys("012233445566");
                driver.findElement(By.id("input-password")).sendKeys("password");
                driver.findElement(By.id("input-confirm")).sendKeys("password");
                driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
                driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
                JavascriptExecutor java = (JavascriptExecutor)driver;
                java.executeScript("scroll(0,350)");
                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
                driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")).click();
                WebElement text = driver.findElement(By.id("input-email"));
                String checkValue = text.getAttribute("value");
                System.out.println(text.getAttribute("the Register Mail is : " + checkValue));
                Assert.assertEquals(checkValue,"email20201@fawry.com");







        }
        @BeforeClass
        public void open_browser ()
        {
            WebDriverManager.chromedriver().setup();
            driver.manage().window().maximize();
            driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        }

        @AfterTest
         public void close_browser ()
         {
             driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
             driver.findElement(By.linkText("Logout")).click();
             driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
           // driver.close();
         }



    }

