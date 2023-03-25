package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup {

	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	// syntax for finding UI elements and storing them in POM classes
	/**
	 * @FindBy(locatorType = "value") public WebElement nameOfElement
	 */

	@FindBy(xpath = "//a[text()='TEKSCHOOL']")
	public WebElement tekSchoolLogo;

	@FindBy(id = "search")
	public WebElement allDepartmentDropDown;

	@FindBy(css = "#searchInput")
	public WebElement searchBar;

	@FindBy(xpath = "//button[@id='searchBtn']")
	public WebElement searchButton;

	@FindBy(linkText = "Sign in")
	public WebElement signInButton;

	@FindBy(id = "cartBtn")
	public WebElement cartButton;

	@FindBy(xpath = "//img[contains(@alt, 'Pokemon')]")
	public WebElement pokemanProductImage;

	@FindBy(xpath = "//a[text()='Account']")
	public WebElement accountOption;

	@FindBy(id = "hamburgerBtn")
	public WebElement allIcon;

	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarElements;

	@FindBy(xpath = "//span[text()='Electronics']")
	public WebElement electronicsSideBar;

	@FindBy(xpath = "//span[text()='Computers']")
	public WebElement computersSideBar;

	@FindBy(xpath = "//span[text()='Smart Home']")
	public WebElement smartHomeSideBar;

	@FindBy(xpath = "//span[text()='Sports']")
	public WebElement sportsSideBar;

	@FindBy(xpath = "//span[text()='Automative']")
	public WebElement automativeSideBar;

	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarOptionElements;

	@FindBy(xpath = "//p[contains(text(),'Kasa Outdoor Smart Plug')]")
	public WebElement SmartPlugItem;

	@FindBy(xpath = "//option[contains(text(),'2')]")
	public WebElement plugItemQty;
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	public WebElement addToCardPlugButton;

	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cartIcon;

	@FindBy(xpath = "//button[@id='proceedBtn']")
	public WebElement proccedButton;

	@FindBy(xpath = "//button[@id='addAddressBtn']")
	public WebElement addNewAddressButton;

	@FindBy(xpath = "//button[@id='addPaymentBtn']")
	public WebElement addNewCardButton;

	@FindBy(xpath = "//select[@id='countryDropdown']")
	public WebElement country;

	@FindBy(id = "fullNameInput")
	public WebElement fullNameField;

	@FindBy(id = "phoneNumberInput")
	public WebElement phoneNumberField;

	@FindBy(id = "streetInput")
	public WebElement streetAddressField;

	@FindBy(xpath = "//input[@id='apartmentInput']")
	public WebElement apartmentNumber;

	@FindBy(id = "cityInput")
	public WebElement cityField;

	@FindBy(xpath = "(//select[@class='account__address-new-dropdown'])[2]")
	public WebElement stateDropDown;

	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeField;

	@FindBy(id = "addressBtn")
	public WebElement addYourAddressButton;

	@FindBy(xpath = "//input[@id='cardNumberInput']")
	public WebElement cardNumberInput;

	@FindBy(xpath = "//input[@id='nameOnCardInput']")
	public WebElement nameOnCardInput;

	@FindBy(xpath = "//select[@id='expirationMonthInput']")
	public WebElement expirationMonthInput;

	@FindBy(xpath = "//select[@id='expirationYearInput']")
	public WebElement expirationYearInput;

	@FindBy(xpath = "//input[@id='securityCodeInput']")
	public WebElement ccvInput;

	@FindBy(xpath = "//button[@id='paymentSubmitBtn']")
	public WebElement addCardButton;
	
	@FindBy(xpath = "//button[@id='placeOrderBtn']")
	public WebElement placeYourOrder;
	
	@FindBy(xpath = "//div[contains(text(),'Order Placed Successfully')]")
	public WebElement orderPlacedSuccessfully;
	
	@FindBy(xpath = "//p[contains(text(),'Apex Legends - 1,000 Apex Coins')]")
	public WebElement apexItem;
	
	@FindBy(xpath = "//option[contains(text(),'5')]")
	public WebElement apexQty;

}
