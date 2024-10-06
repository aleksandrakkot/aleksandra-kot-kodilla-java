package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    public static final String XPATH_COOKIE = "//body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]";
    public static final String XPATH_NEW_ACCOUNT = "//div[@class=\"_6ltg\"]/a";
    public static final String XPATH_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_YEAR= "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com/");

        driver.findElement(By.xpath(XPATH_COOKIE)).click();
        driver.findElement(By.xpath(XPATH_NEW_ACCOUNT)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement dayOfBirth = driver.findElement(By.xpath(XPATH_DAY));
        Select day = new Select(dayOfBirth);
        day.selectByIndex(7);

        WebElement monthOfBirth = driver.findElement(By.xpath(XPATH_MONTH));
        Select month = new Select(monthOfBirth);
        month.selectByIndex(5);

        WebElement yearOfBirth = driver.findElement(By.xpath(XPATH_YEAR));
        Select year = new Select(yearOfBirth);
        year.selectByIndex(24);
    }
}
