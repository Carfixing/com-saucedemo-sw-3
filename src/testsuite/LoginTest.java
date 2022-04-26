package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid(){
        //find the username field element
        sendTextToElement(By.id("user-name"),"standard_user");
        //find the password field element
        sendTextToElement(By.name("password"),"secret_sauce");
        //Click on Login button
        clickOnElement(By.id("login-button"));

       //Verify the text “PRODUCTS”
        String expectedMessage = "PRODUCTS";
        String actualMessage = getTextFromElement(By.className("title"));
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);

    }

     @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
         //enter the username
         sendTextToElement(By.id("user-name"),"standard_user");

         //ener the password
         sendTextToElement(By.name("password"),"secret_sauce");

         //Click on Login button
         clickOnElement(By.id("login-button"));


         //Verify the text “PRODUCTS”
         verifyText("PRODUCTS","PRODUCTS","Can not verify Message :");
         getTextFromElement(By.className("title"));
         //* Verify that six products are displayed on page
         List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']\n"));
         //Print number of Items
         System.out.println("Items displayed : " + products.size());
         //to Count how many items
         for (WebElement element : products)
             Assert.assertEquals(true, element.isDisplayed());
             driver.close();
     }


}
