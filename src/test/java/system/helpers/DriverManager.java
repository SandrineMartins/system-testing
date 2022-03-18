package system.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static system.helpers.Constants.CAMINHO_CHROMEDRIVER;

public class DriverManager {

    private static WebDriver driver;
    private static WebDriverWait driverWait;

    public static WebDriver getDriver(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", CAMINHO_CHROMEDRIVER);
            System.setProperty("webdriver.chrome.silentOutput", "true");
            driver = new ChromeDriver();
        }

        return driver;
    }

    public static WebDriverWait getDriverWait(){
        if (driverWait == null) {
            driverWait = new WebDriverWait(driver, 10);
        }

        return driverWait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            driverWait = null;
        }
    }
}
