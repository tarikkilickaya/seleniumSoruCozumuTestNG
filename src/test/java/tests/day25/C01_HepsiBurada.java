package tests.day25;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_HepsiBurada {


    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {
        // Hepsiburada sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("hepsiBuradaUrl"));
        // Elektronik altında Bilgisayar/Tablet altındaki tüm linkleri tıklayın

        // Her linkten sonra o sayfaya gittiğinizi test edin ve o sayfanın resmini alın
        // Sayfayı kapatın
    }
}