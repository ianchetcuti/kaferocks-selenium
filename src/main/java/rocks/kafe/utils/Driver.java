package rocks.kafe.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author ianche
 */
public class Driver {

    public Driver() {
    }

    private static WebDriver webDriver = null;
    private static String browser;

    public static void setBrowser(String browser) {
        Driver.browser = browser;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            throw new IllegalStateException("Selenium WebDriver is not initialised!");
        }
        return webDriver;
    }

    public static void startWebDriver() {

        // Check whether webDriver has already been initialised.
        if (webDriver != null) {
            throw new IllegalStateException("Selenium WebDriver has already been initialised!");
        }

        if(browser == null){
            System.out.println("-Dbrowser argument not found! Reverting to default localChrome value");
            setBrowser("localChrome");
        }

        try {
            switch (browser) {
                case "localFirefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                case "localChrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                case "headlessLocalChrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--ignore_ssl");
                    webDriver = new ChromeDriver(options);
                    break;
                case "gridFirefox":
                case "gridChrome":
                    throw new UnsupportedOperationException("Not supported in this version");
                default:
                    throw new IllegalArgumentException(String.format("Incorrect Browser system property! Cannot be %s", browser));
            }

            webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Selenium WebDriver!", e);
        }
    }

    public static void nullifyWebDriver() {
        getWebDriver().quit();
        webDriver = null;
    }

    public static void consoleOutput(String message) {
        System.out.println(" - " + message);
    }

}