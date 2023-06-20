package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidOrInvalidUsingDataProvider {
    WebDriver driver;
    @DataProvider(name = "data-set")
    public static Object[][] Dataset(){
        Object[][] obj = {
                {"valid","8688055719", "Selenium@1234"},
                {"invalid","standard_user", "1234"}
        };
        return obj;
    }

    @Test(dataProvider = "data-set")
    public void DataProviderSampleTest(String type, String username, String password) throws InterruptedException {
        System.out.println(type + " " + username + " " + password);
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\chromeDriver_v113\\chromeDriver\\chromedriver.exe");
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='login']")).click();

        if(type.equals("valid")){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"facebook\"]/body")));
        }else
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class = '_9ay7']")));

        Thread.sleep(3000);
        driver.quit();
    }
}