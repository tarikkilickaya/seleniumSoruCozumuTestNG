package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPages {
    public AmazonPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//html")
    public WebElement amazonAnaSayfa;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucu;

    @FindBy(xpath = "(//*[@class='a-size-base a-color-base a-text-normal'])[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "//*[@title='See All Buying Options']")
    public WebElement seeAllBuyingOptions;
}