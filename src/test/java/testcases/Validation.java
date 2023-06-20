package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

class Validation {
    WebDriver driver=null;
    @BeforeMethod
    public void setUp(){
        String url = "https://www.geeksforgeeks.org/";
        String chromeDriverPath = "C:\\Software\\chromeDriver_v113\\chromeDriver\\chromedriver.exe";
        System.setProperty("WebDriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

