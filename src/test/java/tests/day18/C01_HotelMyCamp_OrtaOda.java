package tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C01_HotelMyCamp_OrtaOda extends TestBaseBeforeClassAfterClass {
    @Test
    public void actions() {

        //Yeni bir class olusturun : ScroolInto
        //hotelmycamp anasayfasina gidin
        driver.get("https://hotelmycamp.com");
        //2 farkli test method’u olusturarak actions ve Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        WebElement ortaOda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='View Room Details '])[2]")));
        ortaOda.click();
        //istediginiz oda inceleme sayfasi acildigini test  edin
        String expectedUrl = "https://www.hotelmycamp.com/RoomDetail/488";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

    }

    @Test
    public void javaScriptExecutor() {
        driver.get("https://hotelmycamp.com");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement ortaOda = driver.findElement(By.xpath("(//*[text()='View Room Details '])[2]"));
        jse.executeScript("arguments[0].click();", ortaOda);
        String expectedUrl = "https://www.hotelmycamp.com/RoomDetail/425";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}