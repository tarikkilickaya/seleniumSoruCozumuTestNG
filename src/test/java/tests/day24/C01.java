package tests.day24;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01 {

    AutomationExercisePage automationExerciseObje = new AutomationExercisePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {

        // 1. Tarayıcıyı başlatın
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(automationExerciseObje.automationExerciseAnaSayfa.isDisplayed());
        // 4. Sepete ürün ekleyin
        automationExerciseObje.erkekTshirtSepeteEkle.click();
        // 5. 'Sepet' düğmesini tıklayın
        automationExerciseObje.sepetiGoruntule.click();
        // 6. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(automationExerciseObje.sepetSayfasi.isDisplayed());
        // 7. Ödemeye Devam Et'e tıklayın
        automationExerciseObje.odemeyeDevamEt.click();
        // 8. 'Kaydol / Giriş Yap' düğmesine tıklayın
        automationExerciseObje.registerLogin.click();
        // 9. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        automationExerciseObje.kayitOlName.sendKeys("Tarık");
        automationExerciseObje.kayitOlEmail.sendKeys("tariK4455577@gmail.com", Keys.ENTER);
        automationExerciseObje.cinsiyetMr.click();
        actions.sendKeys(Keys.TAB, Keys.TAB, "12345").sendKeys(Keys.TAB, "25").sendKeys(Keys.TAB, "April").sendKeys(Keys.TAB, "2000").
                sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, "Tarık").sendKeys(Keys.TAB, "KILIÇKAYA").
                sendKeys(Keys.TAB, Keys.TAB, "Kayseri").sendKeys(Keys.TAB, Keys.TAB, "Canada").sendKeys(Keys.TAB, "Student").
                sendKeys(Keys.TAB, "Toronto").sendKeys(Keys.TAB, "38400").sendKeys(Keys.TAB, "123").sendKeys(Keys.TAB, Keys.ENTER).perform();
        // 10. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        Assert.assertTrue(automationExerciseObje.hesapOlusturuldu.isDisplayed());
        automationExerciseObje.continueButton.click();
        // 11. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        Assert.assertTrue(automationExerciseObje.oturumAcildi.isDisplayed());
        // 12.'Sepet' düğmesini tıklayın
        automationExerciseObje.sepetButonu.click();
        // 13. 'Ödemeye Devam Et' düğmesini tıklayın
        automationExerciseObje.odemeyeDevamEt.click();
        // 14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        Assert.assertTrue(automationExerciseObje.teslimatAdresi.isDisplayed());
        // 15. Yorum metni alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        automationExerciseObje.yorumMetniAlani.sendKeys("Teşekkürler");
        automationExerciseObje.odemeyeDevamEt.click();
        // 16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        automationExerciseObje.kartUzerindekiIsim.sendKeys("Tarık");
        actions.sendKeys(Keys.TAB, "123").sendKeys(Keys.TAB, "123").sendKeys(Keys.TAB, "02").sendKeys(Keys.TAB, "2035").perform();
        // 17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        automationExerciseObje.odeVeSiparisiOnayla.click();
        // 18. Başarı mesajının görüntülenmediğini doğrulayın 'Siparişiniz başarıyla verildi!'
        Thread.sleep(2000);
        Assert.assertFalse(automationExerciseObje.siparisMesaji.isDisplayed());
        // 19. 'Faturayı İndir' düğmesine tıklayın ve faturanın başarıyla indirildiğini doğrulayın.
        automationExerciseObje.faturayiIndir.click();
        String dosyaYolu = "C:\\Users\\Tarik\\Downloads\\invoice.txt";
        Thread.sleep(1000);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // 20. 'Devam' düğmesini tıklayın
        automationExerciseObje.continueButton.click();
        // 21. 'Hesabı Sil' düğmesini tıklayın
        automationExerciseObje.hesabiSil.click();
        // 22. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        Driver.quitDriver();
    }
}