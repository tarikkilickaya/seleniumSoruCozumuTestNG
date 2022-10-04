package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {
    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//html")
    public WebElement automationExerciseAnaSayfa;


    @FindBy(xpath = "//*[@class='fa fa-lock']")
    public WebElement kayitOlGirisYap;

    @FindBy(xpath = "//*[@data-qa='signup-name']")
    public WebElement kayitOlName;


    @FindBy(xpath = "//*[@data-qa='signup-email']")
    public WebElement kayitOlEmail;


    @FindBy(xpath = "//*[@id='id_gender1']")
    public WebElement cinsiyetMr;


    @FindBy(xpath = "//*[@id='id_gender2']")
    public WebElement cinsiyetMrs;


    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement hesapOlusturuldu;


    @FindBy(xpath = "//*[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@class='fa fa-user']")
    public WebElement oturumAcildi;


    @FindBy(xpath = "(//*[@class='fa fa-shopping-cart'])[4]")
    public WebElement erkekTshirtSepeteEkle;

    @FindBy(xpath = "//*[text()='Shopping Cart']")
    public WebElement sepetSayfasi;

    @FindBy(xpath = "//*[@class='btn btn-default check_out']")
    public WebElement odemeyeDevamEt;


    @FindBy(xpath = "//*[@id='address_delivery']")
    public WebElement teslimatAdresi;


    @FindBy(xpath = "//*[@id='address_invoice']")
    public WebElement faturaAdresi;


    @FindBy(xpath = "//*[@class='fa fa-trash-o']")
    public WebElement hesabiSil;


    @FindBy(xpath = "//*[text()='recommended items']")
    public WebElement onerilenUrunler;

    @FindBy(xpath = "(//*[@data-product-id='2'])[3]")
    public WebElement onerilenUrunlerdeSepeteEkle;

    @FindBy(xpath = "//*[text()='View Cart']")
    public WebElement sepetiGoruntule;

    @FindBy(xpath = "//*[@class='cart_description']")
    public WebElement sepettekiUrun;

    @FindBy(xpath = "//*[text()='Register / Login']")
    public WebElement registerLogin;

    @FindBy(xpath = "(//*[@href='/view_cart'])[1]")
    public WebElement sepetButonu;

    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement yorumMetniAlani;

    @FindBy(xpath = "//*[@data-qa='name-on-card']")
    public WebElement kartUzerindekiIsim;

    @FindBy(xpath = "//*[@data-qa='pay-button']")
    public WebElement odeVeSiparisiOnayla;

    @FindBy(xpath = "//*[text()='Congratulations! Your order has been confirmed!']")
    public WebElement siparisMesaji;


    @FindBy(xpath = "//*[text()='Download Invoice']")
    public WebElement faturayiIndir;




}