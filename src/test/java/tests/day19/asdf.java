package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPages;
import utilities.Driver;


public class asdf {

    AmazonPages amazonPage = new AmazonPages();

    @Test
    public void test01() {
        //    https://www.amazon.com/ adresine gidin.
        Driver.getDriver().get(" https://www.amazon.com/");
        Assert.assertTrue(amazonPage.amazonAnaSayfa.isDisplayed());
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //    Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
//    arama yapin ve aramanizin gerceklestigini Test edin
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
//    Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
        Assert.assertTrue(amazonPage.aramaSonucu.isDisplayed());
        amazonPage.ilkUrun.click();
        amazonPage.seeAllBuyingOptions.click();
//    $16.83 oldugunu test edi
        String expectedPrice = " $16.83";
        String actualPrice = (Driver.getDriver().findElement(By.xpath(" //*[@id='aod-price-1']")).getText());
        Assert.assertNotEquals(expectedPrice, actualPrice);
    }
}
