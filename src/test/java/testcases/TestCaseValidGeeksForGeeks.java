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
import pages.HomePage1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestCaseValidGeeksForGeeks {
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
        String loginDataPath = "src/main/resources/LoginData1.json";
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
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc01");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        String expectedMessage = "Valid";
        System.out.println(expectedMessage + " " + searchText + " " + searchText1);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }

    @Test
    public void invalidCred() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc02");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        //System.out.println(searchText);
        String expectedMessage = "Invalid";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
    @Test
    public void validUid() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc03");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        //System.out.println(searchText);
        String expectedMessage = "Valid Username and Invalid password";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
    @Test
    public void invalidUid() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc04");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        //System.out.println(searchText);
        String expectedMessage = "InValid Username and valid password";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
    @Test
    public void blankUid() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc05");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        // System.out.println(searchText);
        String expectedMessage = "Blank Username and valid password";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText(searchText);
        Thread.sleep(5000);
    }
    @Test
    public void blankpwd() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc06");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        //System.out.println(searchText);
        String expectedMessage = "Valid Username and blank password";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
    @Test
    public void blankidpwd() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc07");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        //System.out.println(searchText);
        String expectedMessage = "blank Username and blank password";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
    @Test
    public void validIdBlankPwd() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc08");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        //System.out.println(searchText);
        String expectedMessage = "valid Username and blank password";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
    @Test
    public void blankUidInvalidPwd() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc09");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        //System.out.println(searchText);
        String expectedMessage = "blank Username and invalid password";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
    @Test
    public void invalidIdBlankpwd() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath = "src/main/resources/ValidLogin1.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc10");
        String searchText = (String) tc.get("searchText");
        String searchText1 = (String) tc.get("searchText1");
        //System.out.println(searchText);
        String expectedMessage = "invalid Username and blank password";
        System.out.println(expectedMessage);
        HomePage1 hp = new HomePage1(driver);
        hp.clickSearchButton1();
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }
 }
