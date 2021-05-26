package browsertesting;

import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utility {

    public void openBrowser(String baseUrl) {

        /*System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();  // creating object of ChromeDriver class. //driver is declared
        driver.manage().window().maximize();   //this is used to maximise the browser window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //this will wait till browser is loaded
        driver.get(baseUrl);
*/


        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        // Creating object of ChromeDriver class
        driver = new ChromeDriver();

        // this will maximise the window of the browser
        driver.manage().window().maximize();

        // this will wait till the browser is loaded
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);

        // get() method will get us URL
        driver.get(baseUrl);
    }

        public void closeBrowser () {
            if (driver != null) {
                driver.quit();
            }
        }


    }
