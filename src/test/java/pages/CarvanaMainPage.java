package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CarvanaMainPage {
    public CarvanaMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "div[data-qa='logo-wrapper'] svg")
    public WebElement carvanaLogo;

    @FindBy(css="div[data-qa='navigation-wrapper'] div[data-qa='menu-wrapper']")
    public List<WebElement> mainNavigation;

    @FindBy(css = "div[data-qa=\"desktop-wrapper\"]")
    public WebElement signInButton;


    @FindBy(css = "div[data-qa=\"account-modal-tab-wrapper\"]")
    public WebElement signInModal;

    @FindBy(css = "#usernameField")
    public WebElement userEmail;

    @FindBy(css = "#passwordField")
    public WebElement userPassword;

    @FindBy(css = "button[data-cv=\"sign-in-submit\"]")
    public WebElement signInButtonModal;

    @FindBy(css = "div[data-qa=\"error-message-container\"]" )
    public WebElement errorMessage;
}
