package com.cybertek.tests.day15_stale_test;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StaleTest extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement Iagree =  driver.findElement(By.xpath("//div[.='I agree']"));
        Iagree.click();
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium"+ Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));
        Assert.assertTrue(results.isDisplayed());

        //go to google again
        driver.navigate().back();                  // * X * X * X * X * X
        input = driver.findElement(By.name("q")); //need to locate again otherwise stale element exception
        input.sendKeys("Java"+Keys.ENTER);
        results = driver.findElement(By.id("result-stats"));

        Assert.assertTrue(results.isDisplayed());

    }
}
