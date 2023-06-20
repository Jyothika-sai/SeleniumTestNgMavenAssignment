package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestCaseValidAndInvalid {
    WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws IOException, ParseException {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Integer> consentSettings = new HashMap<String, Integer>();
        HashMap<String , Object> profile = new HashMap<String, Object>();
        HashMap<String, Object> prefs = new HashMap<String , Object>();

        consentSettings.put("notifications", 2);
        profile.put("managed_default_content_settings", consentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        String chromeDriverPath = "C:\\Software\\chromeDriver_v113\\chromeDriver\\chromedriver.exe";
        String loginDataPath = "src/main/resources/LoginData.json";
        System.setProperty("webDriver.chrome.driver", chromeDriverPath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        FileReader fr = new FileReader(loginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        String url = (String) jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Description("Verify login functionality")
    @Feature("Login")
    @Story("User should be able to log in with valid credentials")
    @Severity(SeverityLevel.NORMAL)
    public void validCred() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc01");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        String expectedMessage = "Valid";
        System.out.println(expectedMessage + " " + searchText + " " + searchText1);
        HomePage hp = new HomePage(driver);
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }

    @Test
    @Description("Verify invalid login functionality")
    @Feature("Invalid Login")
    @Story("User should not be able to log in with invalid credentials")
    @Severity(SeverityLevel.NORMAL)
    public void invalidCred() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc02");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        System.out.println(searchText);
        String expectedMessage = "Invalid";
        System.out.println(expectedMessage + " " + searchText + " " + searchText1);
        HomePage hp = new HomePage(driver);
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
}

//This page includes various testcases for validating the user credentials

