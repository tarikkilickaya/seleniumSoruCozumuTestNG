package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPages;
import utilities.Driver;

public class C01_DependsOnTestAmazon {

    AmazonPages amazonPages = new AmazonPages();

    @Test
    public void test01() {
        //Bir class oluşturun: DependsOnTest
        //https://www.amazon.com/ adresine gidin.
        Driver.getDriver().get("https://amazon.com");
        //Test : Amazon ana sayfaya gittiginizi test edin
        Assert.assertTrue(amazonPages.amazonAnaSayfa.isDisplayed());
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
        amazonPages.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        Assert.assertTrue(amazonPages.aramaSonucu.isDisplayed());
    }

    @Test(dependsOnMethods = "test03")
    public void test03() {
        //Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin
        amazonPages.ilkUrun.click();
        amazonPages.seeAllBuyingOptions.click();
        String beklenenFiyat = "$16.83";
        String asilFiyat = Driver.getDriver().findElement(By.xpath("(//*[@class='a-price'])[1]")).getText();
        Assert.assertNotEquals(asilFiyat, beklenenFiyat);
    }
}