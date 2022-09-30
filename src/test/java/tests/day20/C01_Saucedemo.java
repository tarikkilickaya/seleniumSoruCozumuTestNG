package tests.day20;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoPage;
import utilities.Driver;

public class C01_Saucedemo {
    @Test
    public void test01() {
        //  Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get("https://www.saucedemo.com/");
        // Enter the username  as standard_user
        SauceDemoPage sauceDemoPage = new SauceDemoPage();
        sauceDemoPage.userName.sendKeys("standard_user");
        // Enter the password as secret_sauce
        sauceDemoPage.password.sendKeys("secret_sauce");
        // Click on login button
        sauceDemoPage.loginButton.click();
        // Choose price low to high
        Select select = new Select(sauceDemoPage.dropDownMenu);
        select.selectByValue("lohi");
        // and verify that PRICE (LOW TO HIGH) is visible
        Assert.assertTrue(sauceDemoPage.priceLowtoHigh.isDisplayed());

        Driver.quitDriver();
    }
}