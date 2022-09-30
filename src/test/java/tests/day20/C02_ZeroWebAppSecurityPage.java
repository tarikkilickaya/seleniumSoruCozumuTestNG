package tests.day20;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppSecurityPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_ZeroWebAppSecurityPage {

    public ZeroWebAppSecurityPage zeroWebAppObje = new ZeroWebAppSecurityPage();

    @Test
    public void test01() {
        //"http://zero.webappsecurity.com/" Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroWebAppUrl"));

        //Sign in butonuna basin
        zeroWebAppObje.ilkSayfaSignIn.click();

        //Login kutusuna "username" yazin
        zeroWebAppObje.login.sendKeys("username");

        //Password kutusuna "password" yazin
        zeroWebAppObje.passwword.sendKeys("password");

        //Sign in tusuna basin
        zeroWebAppObje.signIn.click();

        Driver.getDriver().navigate().back();

        //Online banking menusu icinde Pay Bills sayfasina gidin
        zeroWebAppObje.onlineBankingMenu.click();
        zeroWebAppObje.payBills.click();

        //"Purchase Foreign Currency" tusuna basin
        zeroWebAppObje.purchaseForeign.click();

        //"Currency" drop down menusunden Eurozone'u secin
        Select select = new Select(zeroWebAppObje.currencyDropDown);
        select.selectByValue("EUR");

        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(zeroWebAppObje.currencyDropDown.getText().equals("Eurozone (Euro)"));

        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin  "Select One", "Australia (dollar)",
        // "Canada (dollar)","Switzerland (franc)","China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand  (dollar)",
        //"Sweden (krona)", "Singapore (dollar)","Thailand (baht)"

        List<WebElement> dropDownMenuList = select.getOptions();

        List<String> verilenListe = new ArrayList<>(Arrays.asList("Select One",
                "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)",
                "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)",
                "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)",
                "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));

        for (int i = 0; i < dropDownMenuList.size(); i++) {
            softAssert.assertEquals(dropDownMenuList.get(i).getText(), verilenListe.get(i), i + ". elementler esit degil");
        }

        Driver.quitDriver();
    }
}