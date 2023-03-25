package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import javax.swing.UIClientPropertyKey;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.pages.RetailAccountPage;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class RetailAccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("user clicked on Account option");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
		clearTextUsingSendKeys(factory.accountPage().profileNameInputField);
		sendText(factory.accountPage().profileNameInputField, nameValue);
		clearTextUsingSendKeys(factory.accountPage().profilePhoneNumberField);
		sendText(factory.accountPage().profilePhoneNumberField, phoneValue);
		logger.info("user updated Name and Phone values ");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().profileUpdateButton);
		logger.info("user clicked on Update button");
	}

	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateSuccessMessage));
		logger.info("user profile information updated");
	}

	@When("User click on  Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressOption);
		logger.info("user clicked on Add address option");

	}

	@When("User fill new address form with below information")
	public void userFllNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<List<String>> addressInfo = dataTable.asLists(String.class);
		selectByVisibleText(factory.accountPage().country, DataGeneratorUtility.data(addressInfo.get(0).get(0)));
		sendText(factory.accountPage().fullNameField, DataGeneratorUtility.data(addressInfo.get(0).get(1)));
		sendText(factory.accountPage().phoneNumberField, DataGeneratorUtility.data(addressInfo.get(0).get(2)));
		sendText(factory.accountPage().streetAddressField, DataGeneratorUtility.data(addressInfo.get(0).get(3)));
		sendText(factory.accountPage().apartmentNumber, DataGeneratorUtility.data(addressInfo.get(0).get(4)));
		sendText(factory.accountPage().cityField, DataGeneratorUtility.data(addressInfo.get(0).get(5)));
		selectByVisibleText(factory.accountPage().stateDropDown, DataGeneratorUtility.data(addressInfo.get(0).get(6)));
		sendText(factory.accountPage().zipCodeField, DataGeneratorUtility.data(addressInfo.get(0).get(7)));
		logger.info("user filled the new address form with information provided in data table");

	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().addYourAddressButton);
		logger.info("user clicked on Add your Address button");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMessage) {
		waitTillPresence(factory.accountPage().addressAddedSuccessfullyMessage);
		Assert.assertEquals(expectedMessage, factory.accountPage().addressAddedSuccessfullyMessage.getText());
	}

	@When("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		List<Map<String, String>> newPasswordInfo = dataTable.asMaps(String.class, String.class);

		sendText(factory.accountPage().previousPassword, newPasswordInfo.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPassword, newPasswordInfo.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmNewPassword, newPasswordInfo.get(0).get("confirmPassword"));
		logger.info("User entered new password info");
	}

	@When("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		waitTillPresence(factory.accountPage().changePassword);
		waitTillClickable(factory.accountPage().changePassword);
		click(factory.accountPage().changePassword);
		logger.info("User click on Change Password button");
	}

	@Then("a password message should be displayed {string}")
	public void aPasswordMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.accountPage().passwordUpdatedSuccessfully);
		Assert.assertEquals(factory.accountPage().passwordUpdatedSuccessfully.getText(),
				"Password Updated Successfully");
	}

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentMethod);
		logger.info("User click on Add Payment Method");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> addPaymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberInput, addPaymentInfo.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInput, addPaymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthInput, addPaymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearInput, addPaymentInfo.get(0).get("expirationYear"));
		sendText(factory.accountPage().ccvInput, addPaymentInfo.get(0).get("securityCode"));
		logger.info("User entered card Info");

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addCardButton);
		logger.info("User click add card button");
	}

	@Then("a payment message should be displayed {string}")
	public void aPaymentMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.accountPage().paymentMethodAddedMessage);
		Assert.assertEquals(factory.accountPage().paymentMethodAddedMessage.getText(),
				"Payment Method added sucessfully");

	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() throws InterruptedException {
		click(factory.accountPage().editPaymentMethod);
		click(factory.accountPage().editPaymentButton);
		click(factory.accountPage().editCardNumberInput);
		clear(factory.accountPage().editCardNumberInput);
		click(factory.accountPage().editCardNameOnCardInput);
		clear(factory.accountPage().editCardNameOnCardInput);
		click(factory.accountPage().editCardCcvInput);
		clear(factory.accountPage().editCardCcvInput);
		Thread.sleep(7000);
		logger.info("User Clicked on the Edit Payment field and button");
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> editCardInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().editCardNumberInput, editCardInfo.get(0).get("editCardNumber"));
		click(factory.accountPage().editCardNameOnCardInput);
		clear(factory.accountPage().editCardNameOnCardInput);
		sendText(factory.accountPage().editCardNameOnCardInput, editCardInfo.get(0).get("editNameOnCard"));
		selectByVisibleText(factory.accountPage().editCardExpirationMonth,
				editCardInfo.get(0).get("editExpirationMonth"));
		selectByVisibleText(factory.accountPage().editCardExpirationYearInput,
				editCardInfo.get(0).get("editExpirationYear"));
		click(factory.accountPage().editCardCcvInput);
		clear(factory.accountPage().editCardCcvInput);
		sendText(factory.accountPage().editCardCcvInput, editCardInfo.get(0).get("editSecurityCode"));
		logger.info("User updated card Info");
	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().updateYourCardButton);
		logger.info("User click on update your card Button");
	}

	@Then("a update message should be displayed {string}")
	public void aUpdateMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.accountPage().paymentMethodUpdatedMessage);
		Assert.assertEquals(factory.accountPage().paymentMethodUpdatedMessage.getText(),
				"Payment Method updated Successfully");

	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() throws InterruptedException {
		click(factory.accountPage().editPaymentMethod);
		click(factory.accountPage().removeCardButton);
		logger.info("User clicked on remove card button");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		takeScreenShotAsBytes();

	}

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() throws InterruptedException {
		click(factory.accountPage().editAddressButton);
		click(factory.accountPage().fullNameField);
		clearTextUsingSendKeys(factory.accountPage().fullNameField);
		click(factory.accountPage().phoneNumberField);
		clearTextUsingSendKeys(factory.accountPage().phoneNumberField);
		click(factory.accountPage().streetAddressField);
		clearTextUsingSendKeys(factory.accountPage().streetAddressField);
		click(factory.accountPage().apartmentNumber);
		clearTextUsingSendKeys(factory.accountPage().apartmentNumber);
		click(factory.accountPage().cityField);
		clearTextUsingSendKeys(factory.accountPage().cityField);
		click(factory.accountPage().zipCodeField);
		clearTextUsingSendKeys(factory.accountPage().zipCodeField);
		Thread.sleep(3000);
		logger.info("user click on edit Address Button ");
	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> updateAddress = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().country, updateAddress.get(0).get("country"));
		click(factory.accountPage().fullNameField);
		clearTextUsingSendKeys(factory.accountPage().fullNameField);
		sendText(factory.accountPage().fullNameField, updateAddress.get(0).get("fullName"));
		click(factory.accountPage().phoneNumberField);
		clearTextUsingSendKeys(factory.accountPage().phoneNumberField);
		sendText(factory.accountPage().phoneNumberField, updateAddress.get(0).get("phoneNumber"));
		click(factory.accountPage().streetAddressField);
		clearTextUsingSendKeys(factory.accountPage().streetAddressField);
		sendText(factory.accountPage().streetAddressField, updateAddress.get(0).get("streetAddress"));
		click(factory.accountPage().apartmentNumber);
		clearTextUsingSendKeys(factory.accountPage().apartmentNumber);
		sendText(factory.accountPage().apartmentNumber, updateAddress.get(0).get("apt"));
		click(factory.accountPage().cityField);
		clearTextUsingSendKeys(factory.accountPage().cityField);
		sendText(factory.accountPage().cityField, updateAddress.get(0).get("city"));
		selectByVisibleText(factory.accountPage().stateDropDown, updateAddress.get(0).get("state"));
		click(factory.accountPage().zipCodeField);
		clearTextUsingSendKeys(factory.accountPage().zipCodeField);
		sendText(factory.accountPage().zipCodeField, updateAddress.get(0).get("zipCode"));
		logger.info("user updated the address form with information provided in data table");
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().updateAddressButton);
	}

	@Then("a address update message should be displayed {string}")
	public void aAddressUpdateMessageShouldBeDisplayedAddressUpdatedSuccessfully(String string) {
		waitTillPresence(factory.accountPage().AddressUpdatedMessage);
		Assert.assertEquals(factory.accountPage().AddressUpdatedMessage.getText(), "Address Updated Successfully");
	}

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() throws InterruptedException{
		scrollPageDownWithJS();
		waitTillClickable(factory.accountPage().removeAddressButton);
		click(factory.accountPage().removeAddressButton);
		Thread.sleep(3000);
		logger.info("user click on remove address button");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		takeScreenShotAsBytes();
	}

}