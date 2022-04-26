package utilities;

import browserfactory.BaseTest;
import com.beust.jcommander.internal.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    //*******************This method will click on element************************//
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    //*************This method will get text from element**********************//
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //*****************this method will send text to element*********************//
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //*********************** verify text **************************************//
    public void verifyText(String exceptedMessage, String actualMessage, @Nullable String errorMessage)
    {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }

}
