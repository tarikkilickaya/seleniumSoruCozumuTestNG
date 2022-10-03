package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {
    public SauceDemoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement usernameKutusu;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement login;

    @FindBy(xpath = "//*[@src='/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']")
    public WebElement ilkUrunCanta;

    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    public WebElement sepetiGoruntule;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    public WebElement sepettekiCanta;

    @FindBy(xpath = "//*[@id='checkout']")
    public WebElement checkout;

    @FindBy(xpath = "//*[@id='first-name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id='finish']")
    public WebElement finishButton;

    @FindBy(xpath = "//*[text()='THANK YOU FOR YOUR ORDER']")
    public WebElement thankYouYazisi;

    @FindBy(xpath = "//*[@class='product_sort_container']")
    public WebElement dropDownMenu;

    @FindBy(xpath = "(//*[text()='Price (low to high)'])[1]")
    public WebElement priceLowtoHigh;

}