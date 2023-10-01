import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SecondTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account#account-creation");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void EmailTest() throws InterruptedException {


        WebElement emailCreate = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        emailCreate.sendKeys("qa-test777@gmail.com");
        WebElement buttonSubmitCreate = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        buttonSubmitCreate.click();
        Thread.sleep(3000);
        WebElement createAccountText = driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1"));
        Assert.assertEquals(createAccountText.getText(), "CREATE AN ACCOUNT");

    }

    @Test
    public void InvalidEmailTest() throws InterruptedException {

        //  WebElement emailCreate = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        WebElement emailCreate = driver.findElement(By.cssSelector("#email_create"));
        emailCreate.sendKeys("qa-test777gmail.com");
        WebElement buttonSubmitCreate = driver.findElement(By.cssSelector("#SubmitCreate > span"));
        buttonSubmitCreate.click();
        Thread.sleep(3000);
        WebElement errorAlert = driver.findElement(By.cssSelector("#create_account_error > ol > li"));
        Assert.assertEquals(errorAlert.getText(), "Invalid email address.");
    }
}
