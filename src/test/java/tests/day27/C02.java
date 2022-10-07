package tests.day27;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02 {

    AutomationExercisePage automationExerciseObje = new AutomationExercisePage();

    @Test
    public void test01() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String beklenenUrl = "https://automationexercise.com/";
        String gercekUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(beklenenUrl, gercekUrl);
        //4. 'Ürünler' düğmesine tıklayın
        automationExerciseObje.urunlerButonu.click();
        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(automationExerciseObje.tumUrunler.isDisplayed());
        //6. Ürün listesi görünür
        Assert.assertTrue(automationExerciseObje.urunListesi.isDisplayed());
        //7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        automationExerciseObje.urunuGoruntule.click();
        //8. Kullanıcı, ürün detay sayfasına yönlendirilir
        Assert.assertTrue(automationExerciseObje.urunSayfasi.isDisplayed());
        //9. Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
        Assert.assertTrue(automationExerciseObje.urunAdi.isDisplayed() && automationExerciseObje.urunKategorisi.isDisplayed() &&
                automationExerciseObje.fiyat.isDisplayed() && automationExerciseObje.bulunabilirlik.isDisplayed() &&
                automationExerciseObje.marka.isDisplayed());

        Driver.quitDriver();
    }
}