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

    @FindBy(xpath = "//picture[@class='vehicle-image']")
    public List<WebElement> tileImg;

    @FindBy(css = "div[class=\"favorite-vehicle\"]")
    public List<WebElement> tileFavorite;


}