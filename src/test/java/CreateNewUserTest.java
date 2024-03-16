import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.UUID;
import java.io.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewUserTest
{
    private WebDriver driver;
    private String generatedEmail;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edvinas\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        generatedEmail = registerUser(driver);
    }

    @Test
    public void testUserCreation() {
        registerUser(driver);
        System.out.println("Created user with email: " + generatedEmail);
    }
    @After
    public void teardown() {
        driver.quit();
    }

    private String registerUser(WebDriver driver)
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
