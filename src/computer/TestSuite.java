package computer;
/**
 * 1.Create class “TestSuite”
 * <p>
 * /** 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on Computer Menu.
 * 1.2 Click on Desktop
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.

 * . Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Click on Computer Menu.
 * 2.2 Click on Desktop
 * 2.3 Select Sort By position "Name: A to Z"
 * 2.4 Click on "Add To Cart"
 * 2.5 Verify the Text "Build your own computer"
 * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 2.7.Select "8GB [+$60.00]" using Select class.
 * 2.8 Select HDD radio "400 GB [+$100.00]"
 * 2.9 Select OS radio "Vista Premium [+$60.00]"
 * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
 * 2.11 Verify the price "$1,475.00"
 * 2.12 Click on "ADD TO CARD" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
 * After that close the bar clicking on the cross button.
 * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.15 Verify the message "Shopping cart"
 * 2.16 Change the Qty to "2" and Click on "Update shopping cart"
 * 2.17 Verify the Total"$2,950.00"
 * 2.18 click on checkbox “I agree with the terms of service”
 * 2.19 Click on “CHECKOUT”
 * 2.20 Verify the Text “Welcome, Please Sign In!”
 * 2.21 Click on “CHECKOUT AS GUEST” Tab
 * 2.22 Fill the all mandatory field
 * 2.23 Click on “CONTINUE”
 * 2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE”
 * 2.26 Select Radio Button “Credit Card”
 * 2.27 Select “Master card” From Select credit card dropdown
 * 2.28 Fill all the details
 * 2.29 Click on “CONTINUE”
 * 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air”
 * 2.33 Verify Total is “$2,950.00”
 * 2.34 Click on “CONFIRM”
 * 2.35 Verify the Text “Thank You”
 * 2.36 Verify the message “Your order has been successfully processed!”
 * 2.37 Click on “CONTINUE”
 * 2.37 Verify the text “Welcome to our store”
 */


import browsertesting.BaseTest;
import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.apache.commons.exec.OS;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class TestSuite extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);  //this method comes from BaseTest
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        /** 1.1 Click on Computer Menu.
         * 1.2 Click on Desktop */

        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

       /* Actions action = new Actions(driver);
        // Computer -----> Desktop click
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        action.moveToElement(computer).moveToElement(desktop).click().build().perform();
*/
        /** 1.3 Select Sort By position "Name: Z to A" */
        selectByValueFromDropDown(By.id("products-orderby"), "6");

        /** 1.4 Verify the Product will arrange in Descending order.*/
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByValue("6");
        String expectedresult = "Name: Z to A";
        String acutalresult = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Products not display in descending order", expectedresult, acutalresult);

    }

    @Test
    public void verifyPRoductAddedtoShoppingCartSuccesFully() throws InterruptedException {

        /**  2.1 Click on Computer Menu.
            2.2 Click on Desktop */
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

        /*Actions action = new Actions(driver);
        // Computer -----> Desktop click
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

        action.moveToElement(computer).moveToElement(desktop).click().build().perform();
*/
        /** 2.3 Select Sort By position "Name: A to Z"*/
        Thread.sleep(3000);
        selectByValueFromDropDown(By.id("products-orderby"),"5");

        /** 2.4 Click on "Add To Cart"*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']"));

        /**2.5 Verify the Text "Build your own computer"*/
        Thread.sleep(3000);
        String expectedmessage1 = "Build your own computer";
        String actualmessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Message display",expectedmessage1,actualmessage1);

        /**2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class */
        Thread.sleep(3000);
        selectByIndex(By.xpath("//select[@id='product_attribute_1']"),1);

        /** 2.7.Select "8GB [+$60.00]" using Select class.*/
        Thread.sleep(3000);
        selectByValueFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"5");

        /** 2.8 Select HDD radio button "400 GB [+$100.00]"*/
        Thread.sleep(3000);
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_3_7']"));

        /*Actions action1 = new Actions(driver);
        WebElement HDD2 = driver.findElement(By.xpath("//input[@id='product_attribute_3_7']"));
        action1.moveToElement(HDD2).click().build().perform();*/

        /**  2.9 Select OS radio button "Vista Premium [+$60.00]"*/
        Thread.sleep(3000);
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_4_9']"));

        /*Actions action2 = new Actions(driver);
        WebElement OS2 = driver.findElement(By.xpath("//input[@id='product_attribute_4_9']"));
        action2.moveToElement(OS2).click().build().perform();*/

        /** 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"*/
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//input[@id='product_attribute_5_10']"));
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_5_12']"));

        /*Actions action3 = new Actions(driver);
        WebElement Software1 = driver.findElement(By.xpath("//input[@id='product_attribute_5_10']"));
        action3.moveToElement(Software1).build().perform();
        WebElement Software3 = driver.findElement(By.xpath("//input[@id='product_attribute_5_12']"));
        action3.moveToElement(Software3).click().build().perform();*/

        /** 2.11 Verify the price "$1,475.00"*/
        Thread.sleep(3000);
        String expectedprice = "$1,475.00";
        String actualprice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("Price do not match",expectedmessage1,actualmessage1);

        /**2.12 Click on "ADD TO CARD" Button.*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        /**2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        * After that close the bar clicking on the cross button.*/
        Thread.sleep(3000);
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//div[@id='bar-notification']"));
        Assert.assertEquals("Message do not match",expectedmessage1,actualmessage1);

        clickOnElement(By.xpath("//span[@class='close']"));

        /**2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.*/
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        /*Actions mousehoover = new Actions(driver);
        WebElement Shoppingcart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement GotoCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        mousehoover.moveToElement(Shoppingcart).moveToElement(GotoCart).click().build().perform();*/

        /**2.15 Verify the message "Shopping cart"*/
        Thread.sleep(3000);
        String expectedmessage2 = "Shopping cart";
        String actualmessage2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Message 'Shopping cart' is not displayed", expectedmessage2,actualmessage2);

        /**2.16 Change the Qty to "2" and Click on "Update shopping cart"*/
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElement(By.xpath("//input[@value='1']"), "2");
        clickOnElement((By.xpath("//button[contains(text(),'Update shopping cart')]")));

        /** 2.17 Verify the Total"$2,950.00"*/
        Thread.sleep(3000);
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("Total is not correct", expectedTotal,actualTotal);

        /** 2.18 click on checkbox “I agree with the terms of service”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        /** 2.19 Click on “CHECKOUT”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        /** 2.20 Verify the Text “Welcome, Please Sign In!”*/
        Thread.sleep(3000);
        String expectedtext = "Welcome, Please Sign In!";
        String actualtext = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Text is not correct", expectedtext,actualtext);

        /** 2.21 Click on “CHECKOUT AS GUEST”Tab*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        /** 2.22 Fill the all mandatory field*/
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Sanya");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Mishra");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"def@gmail.com");
        selectByValueVisibleText(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"Fiji");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Suva");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "120,Marine Drive");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "00000");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "00116796548765");

        /** 2.23 Click on “CONTINUE”*/
        Thread.sleep(5000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        /** 2.24 Click on Radio Button “Next Day Air($0.00)”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

         /** 2.25 Click on “CONTINUE”*/
        Thread.sleep(3000);
         clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

         /** 2.26 Select Radio Button “Credit Card” and Click on Continue*/
         Thread.sleep(3000);
         clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
         clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

         /** 2.27 Select “Master card” From Select credit card dropdown*/
         Thread.sleep(3000);
         selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");
        //option[contains(text(),'Master card')]

        /** 2.28 Fill all the details*/
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Miss Sanya");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5578952379476164");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "7");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2027");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "552");

        /** 2.29 Click on “CONTINUE”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        /** 2.30 Verify “Payment Method” is “Credit Card”*/
        Thread.sleep(3000);
        String expectedpaymentmethod = "Payment Method: Credit Card";
        String actualpaymentmethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Payment method is not correct", expectedpaymentmethod,actualpaymentmethod);

        /**2.32 Verify “Shipping Method” is “Next Day Air”*/
        Thread.sleep(3000);
        String expectedshippingmethod = "Shipping Method: Next Day Air";
        String actualshippingmethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Shipping Method is not correct", expectedshippingmethod,actualshippingmethod);

        /** 2.33 Verify Total is “$2,950.00”*/
        Thread.sleep(3000);
        String expectedTotalfinal = "$2,950.00";
        String actualTotalfinal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("Final Total is not correct", expectedTotalfinal,actualTotalfinal);

        /**2.34 Click on “CONFIRM”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        /** 2.35 Verify the Text “Thank You”*/
        Thread.sleep(3000);
        String expectedtext1 = "Thank you";
        String actualtext1 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank You does not display", expectedtext1,actualtext1);

        /** 2.36 Verify the message “Your order has been successfully processed!”*/
        Thread.sleep(3000);
        String expectedtext2 = "Your order has been successfully processed!";
        String actualtext2 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Thank You does not display", expectedtext2,actualtext2);

        /** 2.37 Click on “CONTINUE”*/
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        /** * 2.37 Verify the text “Welcome to our store”*/
        Thread.sleep(3000);
        String expectedtextWelcome = "Welcome to our store";
        String actualtextWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome to our store not displayed", expectedtextWelcome,actualtextWelcome);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}







