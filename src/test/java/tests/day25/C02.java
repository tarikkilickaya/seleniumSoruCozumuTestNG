package tests.day25;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02 {

    WebUniversityPage webUniversityObje = new WebUniversityPage();

    @Test
    public void test01() {
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");
        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        List<String> list = new ArrayList<>();
        list.add("Kahvaltıyı hazırla");
        list.add("Bulaşıkları yıka");
        list.add("Bebekle ilgilen");
        list.add("Çocuğunun ödevine yardım et");
        list.add("Selenyum çalış");
        list.add("Uyu");

        for (String each : list) {
            webUniversityObje.adNewTodo.sendKeys(each, Keys.ENTER);
        }


        //Tüm yapılacakların üzerini çiz.
        for (WebElement each : webUniversityObje.drawButtons) {
            each.click();
        }

        //Tüm yapılacakları sil.
        for(WebElement each : webUniversityObje.deleteButtonsWebelement) {
            each.click();
        }

        //Tüm yapılacakların silindiğini doğrulayın.
        Assert.assertFalse(webUniversityObje.drawButtons.isEmpty());

    }
}