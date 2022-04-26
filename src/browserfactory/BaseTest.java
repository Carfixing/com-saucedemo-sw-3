package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    //for chrome browser
    public void openBrowser(String baseUrl){
        System.setProperty("webdriver.chrome.driver","drivres/chromedriver.exe");
        driver = new ChromeDriver();
        //launch Url
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //we give implicite time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }
    //create method for close browser
    public void closeBrowser(){

        driver.quit();
    }
}
