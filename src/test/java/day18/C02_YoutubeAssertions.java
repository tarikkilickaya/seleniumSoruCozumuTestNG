package day18;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_YoutubeAssertions extends TestBaseBeforeClassAfterClass {

    // https://www.youtube.com adresine gidin
    @Test(priority = 1)
    public void testName() {
        driver.get("https://youtube.com");
    }

    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test(priority = 2)
    public void titleTest() {
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
    }

    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test(priority = 3)
    public void imageTest() {
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed());
    }

    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test(priority = 4)
    public void searchBoxTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='search_query']")).isEnabled());
    }

    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test(priority = 5)
    public void wrongTitleTest() {
        String nonExpectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(actualTitle, nonExpectedTitle);
    }
}