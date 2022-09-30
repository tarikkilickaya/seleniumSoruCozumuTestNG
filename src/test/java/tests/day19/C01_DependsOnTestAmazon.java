package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPages;
import utilities.Driver;

public class C01_DependsOnTestAmazon {

    AmazonPages amazonPageObje = new AmazonPages();

    @Test
    public void test01() {
        //Bir class oluşturun: DependsOnTest
        //https://www.amazon.com/ adresine gidin.
        Driver.getDriver().get(" https://www.amazon.com/");
        //Test : Amazon ana sayfaya gittiginizi test edin
        Assert.assertTrue(amazonPageObje.amazonAnaSayfa.isDisplayed());
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
        amazonPageObje.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        Assert.assertTrue(amazonPageObje.aramaSonucu.isDisplayed());
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        //Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin
        amazonPageObje.ilkUrun.click();
        amazonPageObje.seeAllBuyingOptions.click();
        String beklenenFiyat = "$16.83";
        String asilFiyat = Driver.getDriver().findElement(By.xpath("(//*[@class='a-price'])[1]")).getText();
        Assert.assertNotEquals(asilFiyat, beklenenFiyat);
    }
}