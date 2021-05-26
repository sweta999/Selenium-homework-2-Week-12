package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {
    public WebDriver driver;

    /**
     * This method will click on element
     * @param by
     */
    // click-on-element method. By=class, by=variable
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will get text from element
     * @param by
     * @return
     */
    public String getTextFromElement(By by) {
        /*String text = driver.findElement(by).click();
        text =*/
        //OR
        return driver.findElement(by).getText();
    }

    /**
     * This method will send Text to/on  Element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will select by value from dropdown by value
     */
    public void selectByValueFromDropDown(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    /**
     * This method will select by visibleText from dropdown by visibleText
     */
    public void selectByValueVisibleText(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }

    /**
     * This method will select by Index from dropdown by Index
     */
    public void selectByIndex(By by, int value){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    /**
     * This method will used to hover mouse on element
     */
     public void mouseHoverToElementAndClick(By by){
         Actions actions = new Actions(driver);
         actions.moveToElement(driver.findElement(by)).click().build().perform();
     }

}
