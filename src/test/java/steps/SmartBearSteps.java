package steps;

import com.github.javafaker.Faker;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearBasePage;
import utils.Driver;
import utils.DropdownHandler;
import utils.TableHandler;

import java.util.List;

public class SmartBearSteps {
    WebDriver driver;
    SmartBearBasePage smartBearBasePage;
    Faker faker;
    List<WebElement> tableRow;
    WebElement table;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        smartBearBasePage = new SmartBearBasePage();
        faker = new Faker();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }


    @When("user enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        smartBearBasePage.userNameInput.sendKeys(userName);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        smartBearBasePage.passwordInput.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        smartBearBasePage.loginButton.click();
    }

    @Then("user should see {string} message")
    public void userShouldSeeMessage(String message) {
        Assert.assertEquals(message, smartBearBasePage.errorMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }


    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable data) {
        for(int i = 0; i < data.asList().size(); i++) {
            Assert.assertTrue(smartBearBasePage.menuItems.get(i).isDisplayed());
            Assert.assertEquals(data.asList().get(i), smartBearBasePage.menuItems.get(i).getText());
        }
    }

    @When("user clicks on Check All button")
    public void userClicksOnCheckAllButton() {
        smartBearBasePage.checkAllButton.click();
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i < smartBearBasePage.checkBox.size(); i++) {
            Assert.assertTrue(smartBearBasePage.checkBox.get(i).isSelected());
        }
    }

    @When("user clicks on Uncheck All button")
    public void userClicksOnUncheckAllButton() {
        smartBearBasePage.uncheckAllButton.click();
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i < smartBearBasePage.checkBox.size(); i++) {
            Assert.assertFalse(smartBearBasePage.checkBox.get(i).isSelected());
        }
    }

    @When("user clicks on Order menu item")
    public void userClicksOnMenuItem() {
        smartBearBasePage.menuItems.get(2).click();
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String product) {
        DropdownHandler.selectByVisibleText(smartBearBasePage.productDropdown, product);
    }

    @And("user enters {string} as quantity")
    public void userEntersAsQuantity(String quantity) {
        smartBearBasePage.quantityInput.clear();
        smartBearBasePage.quantityInput.sendKeys(quantity);
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        smartBearBasePage.customerName.sendKeys(faker.name().fullName());
        smartBearBasePage.streetInput.sendKeys(faker.address().streetAddress());
        smartBearBasePage.cityInput.sendKeys(faker.address().city());
        smartBearBasePage.stateInput.sendKeys(faker.address().state());
        smartBearBasePage.zipInput.sendKeys("45678");
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        smartBearBasePage.cardOption.get(0).click();
        smartBearBasePage.cardNumber.sendKeys("123456789");
        smartBearBasePage.expireDate.sendKeys("12/12");
    }

    @And("user clicks on Process button")
    public void userClicksOnProcessButton() {
        smartBearBasePage.processButton.click();
    }

    @And("user clicks on View all orders menu item")
    public void userClicksOnViewAllOrdersMenuItem() {
        smartBearBasePage.menuItems.get(0).click();
    }

    @Then("user should see their order displayed in the “List of All Orders” table")
    public void userShouldSeeTheirOrderDisplayedInTheListOfAllOrdersTable() {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertTrue(tableRow.get(i).isDisplayed());
        }
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder() {
    }

    @And("user clicks on Delete Selected button")
    public void userClicksOnDeleteSelectedButton() {
        smartBearBasePage.deleteSelectedButton.click();
    }

    @Then("validate all orders are deleted from the “List of All Orders”")
    public void validateAllOrdersAreDeletedFromTheListOfAllOrders() {
        Assert.assertTrue(smartBearBasePage.deleteMessage.isDisplayed());
    }

    @And("validate user sees {string} message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, smartBearBasePage.deleteMessage.getText());
    }
}