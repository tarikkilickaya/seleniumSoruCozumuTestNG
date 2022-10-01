package tests.day21;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_AddtoCartFromRecommendedItems {
    @Test
    public void test01() {

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));
        //3. Sayfanın en altına gidin
        Driver.actions.sendKeys(Keys.END, Keys.ARROW_UP, Keys.ARROW_UP).perform();
        //4. 'TAVSİYE EDİLEN ÖĞELER'in görünür olduğunu doğrulayın
        AutomationExercisePage automationExerciseObje = new AutomationExercisePage();
        Assert.assertTrue(automationExerciseObje.onerilenUrunler.isDisplayed());
        //5. Önerilen üründe 'Sepete Ekle'ye tıklayın
        automationExerciseObje.onerilenUrunlerdeSepeteEkle.click();
        //6. 'Sepeti Görüntüle' düğmesine tıklayın
        automationExerciseObje.sepetiGoruntule.click();
        //7. Ürünün sepet sayfasında görüntülendiğini doğrulayın
        Assert.assertTrue(automationExerciseObje.sepettekiUrun.isDisplayed());

        Driver.quitDriver();
    }
}