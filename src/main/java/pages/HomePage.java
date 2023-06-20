package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchText(String value) {
        String Loc = "//input[@aria-label='Email address or phone number']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }

    public void setSearchText1(String value) {
        String Loc = "//input[@type='password']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }

    public void clickSearchButton() {
        String Loc = "//button[@name='login']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickAccount() {
        driver.findElement(By.xpath("//div[@class='x1i10hfl x1qjc9v5 xjbqb8w xjqpnuy xa49m3k xqeqjp1 x2hbi6w x13fuv20 xu3j5b3 x1q0q8m5 x26u7qi x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x1ypdohk xdl72j9 x2lah0s xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x2lwn1j xeuugli xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 x16tdsg8 x1hl2dhg xggy1nq x1ja2u2z x1t137rt x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m x1q0g3np x87ps6o x1lku1pv x1a2a7pz xzsf02u x1rg5ohu']")).click();
    }

    public void clickSettings1() {
       driver.findElement(By.xpath("//span[contains(text(), 'Settings ')]")).click();
    }

    public void clickSettings() {
        String Loc = "//span[contains(@class, 'x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x3x7a5m x6prxxf xvq8zen xk50ysn xzsf02u x1yc453h') and text() = 'Settings']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickAccountSettings() {
        String Loc = "//span[contains(text(), 'See more in Accounts Centre')]";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickAccountProfile() {
        String Loc = "//span[contains(@class, 'x1lliihq x1plvlek xryxfnj x1n2onr6 x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xt4736n x1f0sm9e x12qp5cl xi81zsa x1yc453h xudqn12 x3x7a5m xjpr12u x889kno') and text() = 'Facebook']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickName() {
        String Loc = "//span[contains(@class, 'x1lliihq x1plvlek xryxfnj x1n2onr6 x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1sfkdl8 x3vd66c xhqx0jl xzsf02u x1yc453h xudqn12 x3x7a5m xjpr12u x1nn3v0j') and text() = 'Name']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void nameValue() {
        WebElement middleNameInput = driver.findElement(By.xpath("//label[contains(text(), 'Middle name')]/preceding::input[1]"));
        middleNameInput.clear();
        middleNameInput.click();
        middleNameInput.sendKeys("bolla");
    }

    public void submit() {
        WebElement reviewChangeElement = driver.findElement(By.cssSelector(".x1lliihq.x1plvlek.xryxfnj.x1n2onr6.x193iq5w.x1fj9vlw"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reviewChangeElement);
    }

    public void done(){
        WebElement doneElement = driver.findElement(By.cssSelector(".x1lliihq.x193iq5w.x6ikm8r.x10wlt62.xlyipyv.xuxw1ft"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", doneElement);

    }

    public void clickPersonalDetails(){
        String Loc = "//span[contains(text(), 'Personal details')]";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickContactDetails(){
        String Loc = "//span[contains(text(), 'Contact info')]";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickMail(){
        String Loc = "(//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x2lah0s x193iq5w x5ib6vp xc73u3c'])//span[contains(text(), '@')]";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickDeleteMail(){
        String Loc = "//span[contains(text(), 'Delete email address')]";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickDelete(){
        String Loc = "//span[contains(@class, 'x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft') and text() = 'Delete']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

}


//This page has all the locators and functions required