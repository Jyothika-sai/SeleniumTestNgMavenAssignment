package testcases;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCaseValidCreateUser {

    WebDriver driver=null;
    @BeforeMethod
    public void setUp(){
        String url = "https://www.facebook.com/";
        String chromeDriverPath = "C:\\Software\\chromeDriver_v113\\chromeDriver\\chromedriver.exe";
        System.setProperty("WebDriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    @Description("Creating a new user account")
    @Feature("Create new user")
    @Story("New user account should be created")
    @Severity(SeverityLevel.NORMAL)
    public void createNewUserAccount() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Create new account")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("Rakshitha");
        driver.findElement(By.name("lastname")).sendKeys("Kashyap");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8897556156");
        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Rakshitha123");
        driver.findElement(By.xpath("//option[text()='3']")).click();
        driver.findElement(By.xpath("//option[text()='Feb']")).click();
        driver.findElement(By.xpath("//option[text()='2002']")).click();
        driver.findElement(By.cssSelector("input[value='1']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        Thread.sleep(1000);
    }
}

//This page  automatically creates new user account