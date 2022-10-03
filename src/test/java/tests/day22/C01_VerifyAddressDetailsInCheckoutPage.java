package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_VerifyAddressDetailsInCheckoutPage {

    AutomationExercisePage automationExerciseObje = new AutomationExercisePage();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(automationExerciseObje.automationExerciseAnaSayfa.isDisplayed());
        //4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
        automationExerciseObje.kayitOlGirisYap.click();
        //5. Kaydolma bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        automationExerciseObje.kayitOlName.sendKeys("Tarık");
        automationExerciseObje.kayitOlEmail.sendKeys("tarikkksssllkggfddddfkzxxxxkk@gmail.com", Keys.ENTER);
        automationExerciseObje.cinsiyetMr.click();
        actions.sendKeys(Keys.TAB, Keys.TAB, "12345").sendKeys(Keys.TAB, "25").sendKeys(Keys.TAB, "April").sendKeys(Keys.TAB, "2000").
                sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, "Tarık").sendKeys(Keys.TAB, "KILIÇKAYA").
                sendKeys(Keys.TAB, Keys.TAB, "Kayseri").sendKeys(Keys.TAB, Keys.TAB, "Canada").sendKeys(Keys.TAB, "Student").
                sendKeys(Keys.TAB, "Toronto").sendKeys(Keys.TAB, "38400").sendKeys(Keys.TAB, "123").sendKeys(Keys.TAB, Keys.ENTER).perform();
        //6. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        Assert.assertTrue(automationExerciseObje.hesapOlusturuldu.isDisplayed());
        automationExerciseObje.continueButton.click();
        //7. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        Assert.assertTrue(automationExerciseObje.oturumAcildi.isDisplayed());
        //8. Sepete ürün ekleyin
        automationExerciseObje.erkekTshirtSepeteEkle.click();
        //9. 'Sepet' düğmesini tıklayın
        automationExerciseObje.sepetiGoruntule.click();
        //10. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(automationExerciseObje.sepetSayfasi.isDisplayed());
        //11. Ödemeye Devam Et'e tıklayın
        automationExerciseObje.odemeyeDevamEt.click();
        //12. Teslimat adresiyle fatura adresinin aynı olmadığını doğrulayın.
        Assert.assertNotEquals(automationExerciseObje.teslimatAdresi.getText(), automationExerciseObje.faturaAdresi.getText());
        //13. 'Hesabı Sil' düğmesini tıklayın
        automationExerciseObje.hesabiSil.click();
        //14. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

        Driver.quitDriver();
    }
}