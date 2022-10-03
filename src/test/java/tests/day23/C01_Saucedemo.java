package tests.day23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_Saucedemo {

    SauceDemoPage saudecemaObje = new SauceDemoPage();

    @Test
    public void test01() {

        // https://www.saucedemo.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));
        // Username ve password kullanarak giriş yapın
        saudecemaObje.usernameKutusu.sendKeys(ConfigReader.getProperty("saudecemoUserName"));
        saudecemaObje.passwordKutusu.sendKeys(ConfigReader.getProperty("saudecemePassword"));
        saudecemaObje.login.click();
        // İlk ürün olarak görünen çantaya tıklayın
        saudecemaObje.ilkUrunCanta.click();
        // Çantanın sayfasında çantayı sepete ekleyin
        saudecemaObje.sepeteEkle.click();
        // Sepet sayfasına gidin
        saudecemaObje.sepetiGoruntule.click();
        // Çantanın sepette olduğunu test edin
        Assert.assertTrue(saudecemaObje.sepettekiCanta.isDisplayed());
        // Checkout butonuna tıklayın
        saudecemaObje.checkout.click();
        // İsim, soyisim ve posta kodunu girin
        saudecemaObje.firstName.sendKeys("Tarık");
        Driver.actions.sendKeys(Keys.TAB, "KILIÇKAYA").sendKeys(Keys.TAB, "38400").perform();
        // Continue butonuna tıklayın
        saudecemaObje.continueButton.click();
        // Açılan sayfada finish butonuna tıklayın
        saudecemaObje.finishButton.click();
        // THANK YOU FOR YOUR ORDER yazısının çıktığını test edip tarayıcıyı kapatın
        Assert.assertTrue(saudecemaObje.thankYouYazisi.isDisplayed());

        Driver.quitDriver();
    }
}