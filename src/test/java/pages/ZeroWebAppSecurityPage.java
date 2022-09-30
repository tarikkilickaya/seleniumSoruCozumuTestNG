package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ZeroWebAppSecurityPage {

    public ZeroWebAppSecurityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='signin_button']")
    public WebElement ilkSayfaSignIn;

    @FindBy(xpath = "//*[@id='user_login']")
    public WebElement login;

    @FindBy(xpath = "//*[@id='user_password']")
    public WebElement passwword;

    @FindBy(xpath = "//*[@value='Sign in']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='onlineBankingMenu']")
    public WebElement onlineBankingMenu;

    @FindBy(xpath = "//*[@id='pay_bills_link']")
    public WebElement payBills;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeign;

    @FindBy(xpath = "//*[@id='pc_currency']")
    public WebElement currencyDropDown;

    @FindBy(xpath = "//*[@id='pc_currency']")
    public List<WebElement> list;

}