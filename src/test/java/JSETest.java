import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class JSETest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
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
        clickElementWithJs(buttonSubmitCreate);
        Thread.sleep(3000);
        String createAccountText = findElementTextWithJs("#noSlide > h1");
        Assert.assertTrue(createAccountText.equalsIgnoreCase( "CREATE AN ACCOUNT"));

    }

    @Test
    public void ContactUsTest() throws InterruptedException {

       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement buttonContactUs = driver.findElement(By.cssSelector("#block_various_links_footer > ul > li:nth-child(5) > a"));
        clickElementWithJs(buttonContactUs);
        Thread.sleep(3000);
        String cs = findElementTextWithJs("#center_column > h1");

       Assert.assertTrue(cs.equalsIgnoreCase(  "\n" + "    CUSTOMER SERVICE - CONTACT US"));
    }
    private void clickElementWithJs(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    private String findElementTextWithJs(String xpath) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.querySelector('" + xpath + "').textContent");

    }
}
