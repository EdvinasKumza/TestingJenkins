import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NamuDarbas3 {
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
        driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][4]")).click();
        //4.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement progressBarElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Progress Bar']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", progressBarElement);
        progressBarElement.click();
        //5.
        driver.findElement(By.id("startStopButton")).click();
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@role = 'progressbar']"), "aria-valuenow", "100"));

        // 6.
        driver.findElement(By.id("resetButton")).click();
    }
}
