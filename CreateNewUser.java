import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.UUID;
import java.io.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewUser
{
    public static void main (String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edvinas\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String randomEmail = generateRandomEmail();
        registerUser(driver, randomEmail);
    }
    public static String generateRandomEmail()
    {
        String randomEmail = "test" + UUID.randomUUID().toString().replace("-", "") + "@example.com";
        return randomEmail;
    }
    public static void registerUser(WebDriver driver, String randomEmail)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edvinas\\Downloads\\chromedriver.exe");
        driver.manage().window().maximize();

        // 1.
        driver.get("https://demowebshop.tricentis.com/");

        // 2.
        driver.findElement(By.linkText("Log in")).click();

        // 3.
        driver.findElement(By.linkText("Register")).click();

        // 4.
        driver.findElement(By.id("gender-male")).click(); // Assuming Male gender
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("User");
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("test123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");

        // 5.
        driver.findElement(By.id("register-button")).click();

        // 6.
        driver.findElement(By.xpath("//input[@class = 'button-1 register-continue-button']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
        driver.findElement(By.xpath("//a[@href= '/logout']")).click();
    }
}
