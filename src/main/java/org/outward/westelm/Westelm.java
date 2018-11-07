package org.outward.westelm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Westelm {
    public static void main(String args[]) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\Prem\\outward\\Outward\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(co);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        /*System.setProperty("webdriver.gecko.driver.driver","./");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();*/

        driver.get("https://www.westelm.com/");
        if (driver.getTitle().contains("west elm")) {

            //to close the pop-up
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"home\"]/div[7]/div/a[1]")));
            driver.findElement(By.xpath("//*[@id=\"home\"]/div[7]/div/a[1]")).click();

            WebElement searchField = driver.findElement(By.id("search-field"));

            //to enter the sku number in search field and validate the valid SKU
           /* searchField.sendKeys("2613243");
            searchField.sendKeys(Keys.RETURN);
            //System.out.println(driver.getCurrentUrl());
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#pip div.jump-below > div > a")));
            WebElement addToCartBtn = driver.findElement(By.cssSelector("div#pip div.jump-below > div > a"));
            if (addToCartBtn.isDisplayed()) {
                System.out.println("Valid UPC - User able to see the result");
            }
            //Assert.assertTrue(addToCartBtn.isDisplayed(),"Invalid UPC - User is not able to see the result");


            //to enter the sku number in search field and validate the invalid SKU
            searchField.sendKeys("12345");
            searchField.sendKeys(Keys.RETURN);
            WebElement invalidUPCErrorMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/ul"));
            if (invalidUPCErrorMsg.isDisplayed()) {
                System.out.println("Invalid UPC - User not able to see the result");
            }
            //Assert.assertTrue(invalidUPCErrorMsg.isDisplayed(),"Valid UPC - Please provide invalid UPC to validate
            // this scenario");*/

            //to find stores for states "Arizona" and "Texas"
            driver.findElement(By.id("stores-link")).click();
            driver.findElement(By.xpath("//*[@id=\"store-locator\"]/main/div[3]/div[2]/section[1]/section[1]/div[3]/a")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("state-list-selector")));
            Select stateDropDown = new Select(driver.findElement(By.id("state-list-selector")));
            stateDropDown.selectByVisibleText("Arizona");
            if (driver.findElement(By.id("js-store-counter")).getText().contains("2")) {
                System.out.println("Two stores found for state Arizona");
            }

            stateDropDown.selectByVisibleText("Texas");
            if (driver.findElement(By.id("js-store-counter")).getText().contains("8")) {
                System.out.println("Eight stores found for state Texas");
            }

        }

        //driver.close();

    }
}
