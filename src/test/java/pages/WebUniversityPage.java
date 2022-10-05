package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class WebUniversityPage {

    public List<WebElement> todosWebelement;

    public WebUniversityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement adNewTodo;

    @FindBy(xpath = "//li")
    public List<WebElement> drawButtons;

    @FindBy(xpath = "//i[@class='fa fa-trash']")
    public List<WebElement> deleteButtonsWebelement;

    @FindBy(xpath = "//li")
    public List<WebElement> newtodosWebelement;
}