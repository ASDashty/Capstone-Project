package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();
	// create object Retailapage
	// creat

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekSchoolLogo));
		logger.info("user is on retail website");
		logger.info("Actual Title " + actualTitle + " Equals " + " ExpectedTitle " + expectedTitle);

	}

	@When("User search for {string} product")
	public void userSearchForProduct(String productValue) {
		sendText(factory.homePage().searchBar, productValue);
		click(factory.homePage().searchButton);
		logger.info("user searched for product " + productValue);
	}

	@Then("The product should be displayed")
	public void theProductShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemanProductImage));
		logger.info("the Product is displayed on home page");

	}

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allIcon);
		logger.info("user clicked on All section");

	}

	@Then("below options are present in shop by department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> expectedSideBar = dataTable.asLists(String.class);

		List<WebElement> actualSideBar = factory.homePage().sideBarElements;

		for (int i = 0; i < expectedSideBar.get(0).size(); i++) {
			Assert.assertEquals(actualSideBar.get(i).getText(), expectedSideBar.get(0).get(i));
			logger.info(actualSideBar.get(i).getText() + " is equal to " + expectedSideBar.get(0).get(i));
		}
//		Assert.assertEquals(expectedSideBar.get(0).get(0), factory.homePage().electronicsSideBar.getText());
//		Assert.assertEquals(expectedSideBar.get(0).get(1), factory.homePage().computersSideBar.getText());
//		Assert.assertEquals(expectedSideBar.get(0).get(2), factory.homePage().smartHomeSideBar.getText());
//		Assert.assertEquals(expectedSideBar.get(0).get(3), factory.homePage().sportsSideBar.getText());
//		Assert.assertEquals(expectedSideBar.get(0).get(4), factory.homePage().automativeSideBar.getText());
//		logger.info("actual is equal to expected");

	}

	@When("User on {string}")
	public void userOnElectronics(String department) {
		List<WebElement> sideBarOptions = factory.homePage().sideBarElements;
		for (WebElement option : sideBarOptions) {
			if (option.getText().equals(department)) {
				click(option);
				try {
					logger.info(option.getText() + " is present ");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {

		List<List<String>> expectedDepartmentOptions = dataTable.asLists(String.class);
		List<WebElement> actualDepartmentOptions = factory.homePage().sideBarOptionElements;

		for (int i = 0; i < expectedDepartmentOptions.get(0).size(); i++) {
			for (WebElement dept : actualDepartmentOptions) {
				if (dept.getText().equals(expectedDepartmentOptions.get(0).get(i))) {
					Assert.assertTrue(isElementDisplayed(dept));
					logger.info(dept.getText() + " is present ");
				}
			}

		}

	}

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String string) {
		click(factory.homePage().allDepartmentDropDown);
		selectByVisibleText(factory.homePage().allDepartmentDropDown, "Smart Home");
		logger.info("user click on all dept and selected Smart Home");

	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String string) {
		sendText(factory.homePage().searchBar, "kasa outdoor smart plug");
		logger.info("User search for Smart Home");
	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		waitTillClickable(factory.homePage().searchBar);
		click(factory.homePage().searchButton);
		logger.info("User click on Search Button");
	}

	@When("User click on item")
	public void userClickOnItem() {
		scrollPageDownWithJS();
		waitTillClickable(factory.homePage().SmartPlugItem);
		click(factory.homePage().SmartPlugItem);

	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String string) {
		click(factory.homePage().plugItemQty);
	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		waitTillClickable(factory.homePage().addToCardPlugButton);
		click(factory.homePage().addToCardPlugButton);
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String string) {
		takeScreenShotAsBytes();
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.homePage().cartIcon);
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.homePage().proccedButton);
	}

	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.homePage().addNewAddressButton);

	}

	@When("User fills new address form with below information")
	public void userFillsNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> updateAddress = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().country, updateAddress.get(0).get("country"));
		click(factory.homePage().fullNameField);
		sendText(factory.homePage().fullNameField, updateAddress.get(0).get("fullName"));
		click(factory.homePage().phoneNumberField);
		sendText(factory.homePage().phoneNumberField, updateAddress.get(0).get("phoneNumber"));
		click(factory.homePage().streetAddressField);
		sendText(factory.homePage().streetAddressField, updateAddress.get(0).get("streetAddress"));
		click(factory.homePage().apartmentNumber);
		sendText(factory.homePage().apartmentNumber, updateAddress.get(0).get("apt"));
		click(factory.homePage().cityField);
		sendText(factory.homePage().cityField, updateAddress.get(0).get("city"));
		selectByVisibleText(factory.homePage().stateDropDown, updateAddress.get(0).get("state"));
		click(factory.homePage().zipCodeField);
		sendText(factory.homePage().zipCodeField, updateAddress.get(0).get("zipCode"));
		logger.info("user updated the address form with information provided in data table");
	}

	@When("User click Add Your New Address button")
	public void userClickAddYourNewAddressButton() {
		click(factory.homePage().addYourAddressButton);
		logger.info("user click on update your address button");
	}

	@Then("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		click(factory.homePage().addNewCardButton);
		logger.info("user click on add cc or dc for payment method");
	}

	@When("User fills new Debit or credit card information")
	public void userFillsNewDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> updatePaymentInfo = dataTable.asMaps(String.class, String.class);
		click(factory.homePage().cardNumberInput);
		sendText(factory.homePage().cardNumberInput, updatePaymentInfo.get(0).get("cardNumber"));
		sendText(factory.homePage().nameOnCardInput, updatePaymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.homePage().expirationMonthInput, updatePaymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.homePage().expirationYearInput, updatePaymentInfo.get(0).get("expirationYear"));
		sendText(factory.homePage().ccvInput, updatePaymentInfo.get(0).get("securityCode"));
		logger.info("User updated card Info");

	}

	@When("User click on Add your new card button")
	public void userClickOnAddYourNewCardButton() {
		fluientWaitforElement(factory.homePage().addCardButton, 3, 1);
		click(factory.homePage().addCardButton);
		logger.info("user click on add new card button");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		fluientWaitforElement(factory.homePage().placeYourOrder, 5, 1);
		click(factory.homePage().placeYourOrder);
		logger.info("user click on place your order");
	}

	@Then("a new message should be displayed {string}")
	public void aNewMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.homePage().orderPlacedSuccessfully);
		Assert.assertEquals(factory.homePage().orderPlacedSuccessfully.getText(), "Order Placed Successfully");
	}

	@When("User changes the category to 'Electronics")
	public void userChangesTheCategoryToElectronics() {
		click(factory.homePage().allDepartmentDropDown);
		selectByVisibleText(factory.homePage().allDepartmentDropDown, "Electronics");
		logger.info("user click on all dept and selected Electronics");
	}

	@When("User searchs for an item {string}")
	public void userSearchsForAnItem(String string) {
		click(factory.homePage().searchBar);
		sendText(factory.homePage().searchBar, "Apex Legends");
		logger.info("User search for  Apex Legends ");
	}

	@When("User clicks on Search icon")
	public void userClicksOnSearchIcon()  {
		waitTillClickable(factory.homePage().searchButton);
		click(factory.homePage().searchButton);
		logger.info("user click on Serach Button");
	}

	@When("User clicks on item")
	public void userClicksOnItem() {
		waitTillClickable(factory.homePage().apexItem);
		click(factory.homePage().apexItem);
		logger.info("user click on Apex Item");
	}

	@When("User selects quantity ‘{int}’")
	public void userSelectsQuantity(Integer int1) {
	click(factory.homePage().apexQty);
		logger.info("user selects qty");
	}
	
	@When("User clicks add to Cart button")
	public void userClicksAddToCartButton() {
	click(factory.homePage().addToCardPlugButton);
	}


	@Then("the carts icon quantity should change to ‘{int}’")
	public void theCartsIconQuantityShouldChangeTo(Integer int1) {
		Assert.assertEquals(factory.homePage().apexQty.getText(), "5");
		logger.info("qty number changed to 5");
	}

	@Then("User clicks on Cart option")
	public void userClicksOnCartOption() {
	click(factory.homePage().cartIcon);
	}

	@Then("User clicks on Proceed to Checkout button")
	public void userClicksOnProceedToCheckoutButton() {
		click(factory.homePage().proccedButton);
	}

	@Then("User clicks on Place Your Order") 
	public void userClicksOnPlaceYourOrder() {
	click(factory.homePage().placeYourOrder);
	}
	
	@Then("a order placed message should be displayed {string}")
	public void aOrderPlacedMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.homePage().orderPlacedSuccessfully);
		Assert.assertEquals(factory.homePage().orderPlacedSuccessfully.getText(), "Order Placed Successfully");
	}


}
