package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.security.Key;

public class C03 extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());
        //4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();
        //5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed());
        //6. Adı, e-posta adresini, konuyu ve mesajı girin
        WebElement isim = driver.findElement(By.xpath("//*[@data-qa='name']"));
        actions.sendKeys(isim, "Tarık").sendKeys(Keys.TAB, "tariktechpro@gmail.com").sendKeys(Keys.TAB, "Hesap Sil").
                sendKeys(Keys.TAB, "Hesabımı silin lütfen").perform();
        //7. Dosya yükle
        driver.findElement(By.xpath("//*[@name='upload_file']")).sendKeys("C:\\Users\\Tarik\\Desktop\\a.png");
        //8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();
        //9. Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();
        //10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed());
        //11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']")).click();
        //WebElement homeButonu = driver.findElement(By.xpath("//*[@class='fa fa-home']"));
        //Assert.assertTrue(homeButonu.isEnabled());

        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}