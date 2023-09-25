package ua.ithillel.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/?hl=en-US");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
@Test
public void UseWebDriver() throws InterruptedException {


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept all']"))).click();

        driver.findElement(By.name("q")).sendKeys("hillel it school");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));

        WebElement firstElement = elements.get(0);
        String actualText = firstElement.getText().toLowerCase();
        String expectedText = "hillel it school";

        Assert.assertEquals(actualText, expectedText, "The first element should not be confused with 'hillel it school'");



  //   driver.quit();
    }
    @Test
    public void UseWebDriverAfter() throws InterruptedException {


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept all']"))).click();

        driver.findElement(By.name("q")).sendKeys("Linkedin test");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3 "));

            WebElement firstElement = elements.get(0);
            String actualText = firstElement.getText().toLowerCase();
            String expectedText = "linkedin test";

            Assert.assertEquals(actualText, expectedText, "The first element should not be confused with 'linkedin test'");

    }

}



