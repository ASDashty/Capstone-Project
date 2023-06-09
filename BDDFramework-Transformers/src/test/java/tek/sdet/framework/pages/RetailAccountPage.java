package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//img[@id='profileImage']")
	public WebElement profileImage;

	@FindBy(id = "nameInput")
	public WebElement profileNameInputField;

	@FindBy(id = "personalPhoneInput")
	public WebElement profilePhoneNumberField;

	@FindBy(xpath = "//button[text()='Update']")
	public WebElement profileUpdateButton;

	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMessage;

	@FindBy(xpath = "//div[@class='account__address-new']")
	public WebElement addAddressOption;

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

	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressAddedSuccessfullyMessage;

	@FindBy(xpath = "//input[@id='previousPasswordInput']")
	public WebElement previousPassword;

	@FindBy(id = "newPasswordInput")
	public WebElement newPassword;

	@FindBy(xpath = "//input[@id='confirmPasswordInput']")
	public WebElement confirmNewPassword;

	@FindBy(id = "credentialsSubmitBtn")
	public WebElement changePassword;

	@FindBy(xpath = "//div[text()='Password Updated Successfully']")
	public WebElement passwordUpdatedSuccessfully;

	@FindBy(xpath = "//p[contains(text(),'Add a payment method')]")
	public WebElement addPaymentMethod;

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

	@FindBy(xpath = "//div[contains(text(),'Payment Method added sucessfully')]")
	public WebElement paymentMethodAddedMessage;

	@FindBy(xpath = "//p[contains(text(),'Master Card')]")
	public WebElement editPaymentMethod;

	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	public WebElement editPaymentButton;

	@FindBy(xpath = "//button[contains(text(),'remove')]")
	public WebElement removeCardButton;

	@FindBy(xpath = "//input[@id='cardNumberInput']")
	public WebElement editCardNumberInput;

	@FindBy(xpath = "//input[@id='nameOnCardInput']")
	public WebElement editCardNameOnCardInput;

	@FindBy(xpath = "//select[@id='expirationMonthInput']")
	public WebElement editCardExpirationMonth;

	@FindBy(xpath = "//select[@id='expirationYearInput']")
	public WebElement editCardExpirationYearInput;

	@FindBy(xpath = "//input[@id='securityCodeInput']")
	public WebElement editCardCcvInput;

	@FindBy(xpath = "//button[@id='paymentSubmitBtn']")
	public WebElement updateYourCardButton;

	@FindBy(xpath = "//div[contains(text(),'Payment Method updated Successfully')]")
	public WebElement paymentMethodUpdatedMessage;

	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	public WebElement editAddressButton;

	@FindBy(xpath = "//button[@id='addressBtn']")
	public WebElement updateAddressButton;

	@FindBy(xpath = "//div[contains(text(),'Address Updated Successfully')]")
	public WebElement AddressUpdatedMessage;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	public WebElement removeAddressButton;

}
