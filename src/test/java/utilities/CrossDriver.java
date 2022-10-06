package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CrossDriver {

    private CrossDriver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        // Eğer browsera bir değer atanmamışsa properties dosyasındaki browser çalışsın.
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        // Testlerimizi xml dosyasından farklı browserlar ile çalıştırabilmek için getDriver() methoduna parametre atamamız gerekir.

        if (driver == null) {
            switch (browser) {
                // CrossBrowser için bizim gönderdiğimiz browser üzerinden çalışması için
                // buraya parametre olarak girdiğimiz değeri yazdık
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }


    public static Actions actions = new Actions(Driver.getDriver());

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}