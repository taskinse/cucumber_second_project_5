package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SmartBearBasePage {
    public SmartBearBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "ctl00_MainContent_username")
    public WebElement userNameInput;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordInput;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errorMessage;

    @FindBy(css = "ul[id=ctl00_menu]>li")
    public List<WebElement> menuItems;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(id = "ctl00_MainContent_orderGrid_ctl")
    public List<WebElement> checkBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInput;

    @FindBy(css = "input[id*='cardList']")
    public List<WebElement> cardOption;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelectedButton;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement deleteMessage;

}