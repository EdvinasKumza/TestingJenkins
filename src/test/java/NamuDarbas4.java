import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NamuDarbas4 {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edvinas\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 1.
        driver.get("https://demoqa.com");
        // 2.
        try
        {
            driver.findElement(By.id("close-fixedban")).click();
        }
        catch (Exception e){}
        //3.
        driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]")).click();
        //4.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webTablesElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Web Tables']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", webTablesElement);
        webTablesElement.click();
        //5.
        while (true)
        {
            driver.findElement(By.id("addNewRecordButton")).click();
            driver.findElement(By.id("firstName")).sendKeys("Test");
            driver.findElement(By.id("lastName")).sendKeys("Test");
            driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");
            driver.findElement(By.id("age")).sendKeys("22");
            driver.findElement(By.id("salary")).sendKeys("22");
            driver.findElement(By.id("department")).sendKeys("Test");
            driver.findElement(By.id("submit")).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='-totalPages']"))).getText().equals("2")) {
                break;
            }
        }
        //6.
        driver.findElement(By.xpath("//button[text() = 'Next']")).click();
        //7.
        driver.findElement(By.id("delete-record-11")).click();

    }
}
