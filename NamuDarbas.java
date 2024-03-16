import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.io.*;
import java.lang.Thread;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class NamuDarbas
{
    public static void main (String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edvinas\\Downloads\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//ul[@class = 'top-menu']//a[@href='/gift-cards']")).click();
        driver.findElement(By.xpath("//span[@class='price actual-price'][number() > 99]//ancestor::div[@class = 'details']//a")).click();
        driver.findElement(By.id("giftcard_4_RecipientName")).sendKeys("Testas");
        driver.findElement(By.id("giftcard_4_SenderName")).sendKeys("Testaitis");
        driver.findElement(By.id("addtocart_4_EnteredQuantity")).clear();
        driver.findElement(By.id("addtocart_4_EnteredQuantity")).sendKeys("5000");
        driver.findElement(By.id("add-to-cart-button-4")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-wishlist-button-4")).click();
        driver.findElement(By.xpath("//div[@class='side-2']//a[@href='/jewelry']")).click();
        driver.findElement(By.xpath("//h2//a[@href='/create-it-yourself-jewelry']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_71_9_15']")));
        se.selectByValue("47");
        driver.findElement(By.xpath("//input[@id='product_attribute_71_11_17_50']")).click();
        driver.findElement(By.id("product_attribute_71_10_16")).sendKeys("80");
        driver.findElement(By.id("addtocart_71_EnteredQuantity")).clear();
        driver.findElement(By.id("addtocart_71_EnteredQuantity")).sendKeys("26");
        driver.findElement(By.id("add-to-cart-button-71")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-wishlist-button-71")).click();
        driver.findElement(By.xpath("//a[@href='/wishlist']//span[@class='cart-label']")).click();
        driver.findElement(By.xpath("(//td[@class='add-to-cart']//input[@type='checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//td[@class='add-to-cart']//input[@type='checkbox'])[2]")).click();
        driver.findElement(By.xpath("//input[@name='addtocartbutton']")).click();

    }
}
