package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;


public class CarvanaTest extends Base {

    /*
        Test Case 1:
    Test name = Validate Carvana home page title and url
    Test priority = 1
    Given user is on "https://www.carvana.com/"
    Then validate title equals to "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
    And validate url equals to "https://www.carvana.com/"
         */

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateCarvanaHomePageTitleAndURL() {
        driver.get("https://www.carvana.com/");

        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    /*
            Test Case 2:
        Test name = Validate the Carvana logo
        Test priority = 2
        Given user is on "https://www.carvana.com/"
        Then validate the logo of the “Carvana” is displayed
     */

    @Test(priority = 2, description = "Test name = Validate the Carvana logo")
    public void validateCarvanaLogo() {
        driver.get("https://www.carvana.com/");
        assertTrue(carvanaMainPage.carvanaLogo.isDisplayed());

    }

        /*
        Test Case 3:
    Test name = Validate the main navigation section items
    Test priority = 3
    Given user is on "https://www.carvana.com/"
    Then validate the navigation section items below are displayed
    |HOW IT WORKS     	|
    |ABOUT CARVANA    	|
    |SUPPORT & CONTACT	|
     */


    @Test(priority = 3, description = " Validate the main navigation section items")
    public void validateMainNavigation() {
        driver.get("https://www.carvana.com/");

        String[] expected = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};

        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(carvanaMainPage.mainNavigation.get(i).getText(), expected[i]);
        }

    }

    /*
        Test Case 4:
    Test name = Validate the sign in error message
    Test priority = 4
    Given user is on "https://www.carvana.com/"
    When user clicks on “SIGN IN” button
    Then user should be navigated to “Sign in” modal
    When user enters email as “johndoe@gmail.com”
    And user enters password as "abcd1234"
    And user clicks on "SIGN IN" button
    Then user should see error message as "Email address and/or password combination is incorrect
    Please try again or reset your password."
     */


    @Test(priority = 4, description = "Validate the sign in error message")
    public void signInMessage() {

        driver.get("https://www.carvana.com/");


        carvanaMainPage.signInButton.click();
        Assert.assertTrue(carvanaMainPage.signInModal.isDisplayed());
        carvanaMainPage.userEmail.sendKeys("johndoe@gmail.com");


        carvanaMainPage.userPassword.sendKeys("abcd1234");
        //  Assert.assertEquals(carvanaMainPage.userPassword.getText(), "abcd1234");

        carvanaMainPage.signInButtonModal.click();
        // Assert.assertEquals(carvanaMainPage.userEmail.getText(), "johndoe@gmail.com");
        //Assert.assertTrue(carvanaMainPage.userPassword.getCssValue("abcd1234"));

        Assert.assertEquals(carvanaMainPage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }

    /*
    Test name = Validate the search filter options and search button
    Test priority = 5
    Given user is on "https://www.carvana.com/"
    When user clicks on "SEARCH CARS" link
    Then user should be routed to "https://www.carvana.com/cars"
    And user should see filter options
    |PAYMENT & PRICE     	|
    |MAKE & MODEL	    	|
    |BODY TYPE		|
    |YEAR & MILEAGE     	|
    |FEATURES	    	|
    |MORE FILTERS		|

 */


    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateSearchFilterButton() {
        driver.get("https://www.carvana.com/");

        carvanaCarsPage.searchCarButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] expected = {"PAYMENT & PRICE",
                "MAKE & MODEL",
                "BODY TYPE",
                "YEAR & MILEAGE",
                "FEATURES",
                "MORE FILTERS"};
        for (int i = 0; i < 6; i++) {

            Assert.assertEquals(carvanaCarsPage.filterOptions.get(i).getText(), expected[i]);

        }

    }

    /*
        Test Case 6:
    Test name = Validate the search result tiles
    Test priority = 6
    Given user is on "https://www.carvana.com/"
    When user clicks on "SEARCH CARS" link
    Then user should be routed to "https://www.carvana.com/cars"
    When user enters "mercedes-benz" to the search input box
    And user clicks on "GO" button in the search input box
    Then user should see "mercedes-benz" in the url
    And validate each result tile
     */

    @Test(priority = 6, description = "Validate the search result tiles")
    public void searchResultTile() {
        driver.get("https://www.carvana.com/");

        carvanaCarsPage.searchCarButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        carvanaCarsPage.searchInputBox.sendKeys("mercedes-benz");

        carvanaCarsPage.goButton.click();
        explicitWait.until(ExpectedConditions.urlContains("mercedes-benz"));
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for (int i = 0; i < 14; i++) {
         // Assert.assertTrue(carvanaCarsPage.tileImg.get(i).isDisplayed());
           Assert.assertTrue(carvanaCarsPage.tileFavorite.get(i).isDisplayed());
            Assert.assertTrue(carvanaCarsPage.tileFavorite.get(i).isEnabled());
            Assert.assertTrue(carvanaCarsPage.tileBody.get(i).isDisplayed());
            Assert.assertTrue(carvanaCarsPage.inventoryType.get(i).isDisplayed() && carvanaCarsPage.inventoryType.get(i).getText() != null);
            Assert.assertTrue(carvanaCarsPage.yearMakeModel.get(i).isDisplayed() && carvanaCarsPage.yearMakeModel.get(i).getText() != null);
            Assert.assertTrue(carvanaCarsPage.trimMileage.get(i).isDisplayed() && carvanaCarsPage.trimMileage.get(i).getText() != null);

            String results = carvanaCarsPage.price.get(i).getText();
            System.out.println(results);

           Assert.assertTrue(Long.parseLong(results.substring(results.indexOf("$")+1).replace(",", "")) > 0);

            assertTrue(carvanaCarsPage.monthlyPaymentInfo.get(i).isDisplayed() && carvanaCarsPage.monthlyPaymentInfo.get(i).getText() != null);
            assertTrue(carvanaCarsPage.downPaymentInfo.get(i).isDisplayed() && carvanaCarsPage.downPaymentInfo.get(i).getText() != null);
            assertTrue(carvanaCarsPage.deliveryChip.get(i).isDisplayed() && carvanaCarsPage.deliveryChip.get(i).getText() != null);

        }


    }
}





