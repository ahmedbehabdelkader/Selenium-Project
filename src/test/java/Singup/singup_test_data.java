package Singup;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


import java.io.IOException;

public class singup_test_data {

    WebDriver driver = new ChromeDriver();

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        // Set the Excel file path and sheet name
        ExcelUtils.setExcelFile("D:\\Testing\\Software Quality Academy\\PHP\\Test_data\\Book1.xlsx", "Sheet1");

        // Get the total number of rows
        int rowCount = ExcelUtils.getRowCount();

        Object[][] data = new Object[rowCount - 1][2];

        // Loop through the Excel rows and columns
        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Username
            data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
        }

        return data;
    }

    @Test(dataProvider ="loginData")
    public void testclass( String firstname , String lastname , String email , String telephone , String password , String confirm)
        {

               

                driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
                driver.findElement(By.linkText("Register")).click();

                driver.findElement(By.id("input-firstname")).sendKeys(firstname);
                driver.findElement(By.id("input-lastname")).sendKeys(lastname);
                driver.findElement(By.id("input-email")).sendKeys(email);
                driver.findElement(By.id("input-telephone")).sendKeys(telephone);
                driver.findElement(By.id("input-password")).sendKeys(password);
                driver.findElement(By.id("input-confirm")).sendKeys(confirm);
                driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
                driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
                JavascriptExecutor java = (JavascriptExecutor)driver;
                java.executeScript("scroll(0,350)");
                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
                driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")).click();
                WebElement text = driver.findElement(By.id("input-email"));
                String checkValue = text.getAttribute("value");
                System.out.println(text.getAttribute("the Register Mail is : " + checkValue));
                Assert.assertEquals(checkValue,"email@fawry.com");







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

