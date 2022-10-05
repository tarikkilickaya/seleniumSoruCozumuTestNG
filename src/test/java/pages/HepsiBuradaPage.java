package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {

    public HepsiBuradaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='Elektronik'])[1]")
    public WebElement elektronik;

    @FindBy(xpath = "(//*[text()='Bilgisayar/Tablet'])[1]")
    public WebElement bilgisayarTablet;






























































}