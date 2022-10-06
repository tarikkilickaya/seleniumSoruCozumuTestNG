package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBaseCross {
    public WebDriver driver;

    public Faker faker = new Faker();

    public String tarih;

    public Actions actions;

    public WebDriverWait wait;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional String browser) {

        driver = CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        tarih = date.format(formatter);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    @AfterClass
    public void tearDown() {
        CrossDriver.quitDriver();
    }
}