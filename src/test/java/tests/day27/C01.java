package tests.day27;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01 {

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
        //4. 'Test Vakaları' düğmesine tıklayın
        automationExerciseObje.testCaseButonu.click();
        //5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/test_cases";
        Assert.assertEquals(expectedUrl, actualUrl);

        Driver.quitDriver();
    }
}