import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class TestScenario {
    public static void main (String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edvinas\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String randomEmail = "ededed@gmail.com";

        // 1.
        driver.get("https://demowebshop.tricentis.com/");

        // 2.
        driver.findElement(By.xpath("//a[@href= '/login']")).click();

        // 3.
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("ededed");
        driver.findElement(By.xpath("//input[@value = 'Log in']")).click();

        // 4.
        driver.findElement(By.linkText("Digital downloads")).click();

        // 5.
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("src/test/text/data1.txt"));
            String productName;
            while ((productName = reader.readLine()) != null)
            {

                WebDriverWait wait = new WebDriverWait(driver, 10);
                WebElement product = driver.findElement(By.xpath("//div[@class='product-item']//a[contains(., '" + productName + "')]"));
                System.out.println(product.getText());
                System.out.println(productName);

                product.findElement(By.xpath(".//ancestor::div[@class='product-item']//input[@value='Add to cart']")).click();

                wait.until(webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
                        .executeScript("return document.getElementById('" + "bar-notification" + "').style.display === 'block';"));
                wait.until(webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
                        .executeScript("return document.getElementById('" + "bar-notification" + "').style.display === 'none';"));
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //6.
        driver.findElement(By.xpath("//a[@href = '/cart']//span[@class = 'cart-label']")).click();

        //7.
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

        //8.
        List<WebElement> selectElement = driver.findElements(By.id("billing-address-select"));

        if(selectElement.isEmpty())
        {
            WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
            Select countrySelect = new Select(country);
            countrySelect.selectByIndex(1);
            driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Test");
            driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Test");
            driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("88888");
            driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("860000000");
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addressButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@class = 'button-1 new-address-next-step-button']")));
        addressButton.click();

        // 9.
        WebElement paymentMethodButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@class = 'button-1 payment-method-next-step-button']")));
        paymentMethodButton.click();

        // 10.
        WebElement paymentInfoButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@class = 'button-1 payment-info-next-step-button']")));
        paymentInfoButton.click();

        // 11.
        WebElement confirmOrderButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@class = 'button-1 confirm-order-next-step-button']")));
        confirmOrderButton.click();
    }
}
