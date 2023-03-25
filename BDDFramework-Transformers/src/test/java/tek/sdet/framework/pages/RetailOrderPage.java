package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// syntax for finding UI elements and storing them in POM classes
	/**
	 * @FindBy(locatorType = "value") public WebElement nameOfElement
	 */

	@FindBy(xpath = "//a[@id='orderLink']")
	public WebElement orders;

	@FindBy(xpath = "//span[contains(text(),'Arriving')]")
	public WebElement firstOrder;

	@FindBy(xpath = "//button[@id='cancelBtn']")
	public WebElement cancelOrderButton;

	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelConfirmButton;

	@FindBy(xpath = "//select[@id='reasonInput']")
	public WebElement CancellationreasonInput;

	@FindBy(xpath = "//option[contains(text(),'Bought wrong item')]")
	public WebElement boughtWrongItem;

	@FindBy(xpath = "//p[contains(text(),'Your Order Has Been Cancelled')]")
	public WebElement cancellationMessage;

	@FindBy(xpath = "//button[@id='returnBtn']")
	public WebElement returnItemButton;

	@FindBy(xpath = "//select[@id='reasonInput']")
	public WebElement reasonInput;

	@FindBy(xpath = "//option[contains(text(),'Item damaged')]")
	public WebElement itemDamaged;

	@FindBy(xpath = "//select[@id='dropOffInput']")
	public WebElement dropOffInput;

	@FindBy(xpath = "//option[contains(text(),'FedEx')]")
	public WebElement fedEx;

	@FindBy(xpath = "//button[@id='orderSubmitBtn']")
	public WebElement returnOrderButton;

	@FindBy(xpath = "//p[contains(text(),'Return was successfull')]")
	public WebElement returnSuccessfullMessage;

	@FindBy(xpath = "//button[@id='reviewBtn']")
	public WebElement reviewButton;

	@FindBy(xpath = "//input[@id='headlineInput']")
	public WebElement headlineInput;

	@FindBy(xpath = "//textarea[@id='descriptionInput']")
	public WebElement reviewInput;

	@FindBy(xpath = "//button[@id='reviewSubmitBtn']")
	public WebElement addReviewButton;

	@FindBy(xpath = "//div[contains(text(),'Your review was added successfully')]")
	public WebElement reviewSuccessMessage;

}
