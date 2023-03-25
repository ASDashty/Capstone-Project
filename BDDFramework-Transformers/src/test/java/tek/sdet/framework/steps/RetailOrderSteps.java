package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.retailOrderPage().orders);
	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		click(factory.retailOrderPage().firstOrder);
	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.retailOrderPage().cancelOrderButton);
	}

	@When("User select the cancelation Reason ‘Bought wrong item’")
	public void userSelectTheCancelationReasonBoughtWrongItem() {
		selectByVisibleText(factory.retailOrderPage().CancellationreasonInput, "Bought wrong item");
		click(factory.retailOrderPage().boughtWrongItem);
		logger.info("user click cancellation reason and selects Bought wrong item");
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		waitTillClickable(factory.retailOrderPage().cancelConfirmButton);
		click(factory.retailOrderPage().cancelConfirmButton);
	}

	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
	public void aCancelationMessageShouldBeDisplayedYourOrderHasBeenCancelled() {
		isElementEnabled(factory.retailOrderPage().cancellationMessage);
		getText(factory.retailOrderPage().cancellationMessage);
		Assert.assertEquals(factory.retailOrderPage().cancellationMessage.getText(), "Your Order Has Been Cancelled");

	}

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.retailOrderPage().returnItemButton);
		logger.info("User click on return item button");
	}

	@When("User select the Return Reason 'Item damaged’")
	public void userSelectTheReturnReasonItemDamaged() {
		selectByVisibleText(factory.retailOrderPage().reasonInput, "Item damaged");
		click(factory.retailOrderPage().itemDamaged);
		logger.info("user click on reason input and select item damaged");
	}

	@When("User select the drop off service 'FedEx’")
	public void userSelectTheDropOffServiceFedEx() {
		selectByVisibleText(factory.retailOrderPage().dropOffInput, "FedEx");
		click(factory.retailOrderPage().fedEx);
		logger.info("user click on drop off input and select FedEx");
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.retailOrderPage().returnOrderButton);
		logger.info("user click on return order Button");
	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String string) {
		isElementEnabled(factory.retailOrderPage().returnSuccessfullMessage);
		getText(factory.retailOrderPage().returnSuccessfullMessage);
		Assert.assertEquals(factory.retailOrderPage().returnSuccessfullMessage.getText(), "Return was successfull");
		logger.info("Return success message displayed");
	}

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.retailOrderPage().reviewButton);
		logger.info("user click on review button");
	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String string, String string2) {
		sendText(factory.retailOrderPage().headlineInput, "Waste of money");
		sendText(factory.retailOrderPage().reviewInput, "The item is very fragile dont buy");
		logger.info("user add headline and review");

	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.retailOrderPage().addReviewButton);
		fluientWaitforElement(factory.retailOrderPage().addReviewButton, 3, 1);
	}

	@Then("a review message should be displayed 'Your review was added successfully’")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully() {
		waitTillPresence(factory.retailOrderPage().reviewSuccessMessage);
		getText(factory.retailOrderPage().reviewSuccessMessage);
		Assert.assertEquals(factory.retailOrderPage().reviewSuccessMessage.getText(), "Your review was added successfully");
		logger.info("Reivew success message displayed");
	}

}
