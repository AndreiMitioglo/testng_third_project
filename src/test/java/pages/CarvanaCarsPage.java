package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaCarsPage {
    public CarvanaCarsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "div[data-test='HeaderFacets'] button")
    public List<WebElement> filterOptions;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarButton;


    @FindBy(css = "input[type='text']")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "class=\"tk-frame top-frame\"")
    public List<WebElement> tileImg;

    @FindBy(css = "div[class=\"favorite-vehicle\"]")
    public List<WebElement> tileFavorite;

    @FindBy(css = "div[class=\"tk-frame middle-frame\"]")
    public List<WebElement> tileBody;

    @FindBy(css = "div[data-qa=\"base-inventory-type\"]")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[class=\"make-model\"]")
    public List<WebElement> yearMakeModel;

    @FindBy(css = "div[class=\"trim-mileage\"]")
    public List<WebElement> trimMileage;

    @FindBy(css = "div[class=\"tk-pane middle-frame-pane\"]  div[class=\"price \"]")
    public List<WebElement> price;

    @FindBy(css = ".monthly-payment")
    public List<WebElement> monthlyPaymentInfo;

    @FindBy(css = ".down-payment")
    public List<WebElement> downPaymentInfo;

    @FindBy(css = ".base-delivery-chip")
    public List<WebElement> deliveryChip;



}