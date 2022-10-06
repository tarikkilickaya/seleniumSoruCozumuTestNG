package tests.day26;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_AmazonSatirSutunSayisi extends TestBaseRapor {

    //Amazon anasayfaya gidebilecek sekilde bir page sayfasi olusturun : AmazonPage
    //Amazon sayfasinda en altta bulunan Webtable’i inceleyebilmek icin AmazonPage clasinda en altta gitme isini yapacak bir method olusturun
    //Tests paketi altinda yeni bir class olusturun: D26_AmazonSatirSutunSayisi
    //Bu class’in altinda bir test method olusturun : satirSayisi() ve webtable’da 10 satir oldugunu test edin
    //Yeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7oldugunu test edin

    AmazonPage amazonObje = new AmazonPage();

    @Test
    public void satirSayisi() {
        amazonObje.enAltaIn();
        int satirSayisi = amazonObje.satirlar.size();
        Assert.assertEquals(satirSayisi, 10);
    }

    @Test
    public void sutunSayisi() {

        amazonObje.enAltaIn();

        List<WebElement> butunSutunlar = amazonObje.sutunlar;
        List<String> yaziliSutunlar = new ArrayList<>();


        for (int i = 0; i < butunSutunlar.size(); i++) {
            if (butunSutunlar.get(i).getText() == null) {
                yaziliSutunlar.add(butunSutunlar.get(i).getText());
            }
        }
        System.out.println(yaziliSutunlar.size());


    }
}