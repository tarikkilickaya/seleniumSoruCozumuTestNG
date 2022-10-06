package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class AmazonPage {
    public AmazonPage() {
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

    @FindBy(xpath = "//table//tr")
    public List<WebElement> satirlar;

    @FindBy(xpath = "//table//td")
    public List<WebElement> sutunlar;

    public void enAltaIn() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.actions.sendKeys(Keys.END).perform();
    }
}