@JenkinsTriggerTest
Feature: This feature is use for testing UI of Retail page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'test.shaiq@tek.com' and password 'Tek@12345'
    And User click on login button
    And User should be logged in into Account

  Scenario: Verify user can search a product
    Given User is on retail website
    When User search for "pokemon" product
    Then The product should be displayed

  Scenario: Verify Shop by Department sidebar
    Given User is on retail website
    When User click on All section
    Then below options are present in shop by department sidebar
      | Electronics | Computers | Smart Home | Sports | Automative |

  Scenario Outline: Verify Department sidebar options
    Given User is on retail website
    When User click on All section
    And User on '<department>'
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department  | optionOne                      | optionTwo                |
      | Electronics | TV & Video                     | Video Games              |
      | Computers   | Accessories                    | Networking               |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets        |
      | Sports      | Athletic Clothing              | Exercise & Fitness       |
      | Automative  | Automative Parts & Accessories | MotorCycle & Powersports |

  @addItemToCart
  Scenario: Verify User can add an item to cart
    And User change the category to 'Smart Home'
    And User search for an item ' kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'

  @addressAndPaymentCheckout
  Scenario: Verify User can place an order without Shipping address and payment Method on file
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click Add a new address link for shipping address
    When User fills new address form with below information
      | country | fullName | phoneNumber | streetAddress | apt | city | state   | zipCode |
      | Canada  | New Jan  |  3047082253 | 101 QTH NE    | A   | Wash | Alberta |   11234 |
    And User click Add Your New Address button
    When User click Add a credit card or Debit Card for Payment method
    And User fills new Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1234106443214351 | Ahmad Jan  |               9 |           2029 |          312 |
    And User click on Add your new card button
    And User click on Place Your Order
    Then a new message should be displayed 'Order Placed Successfully'

  @orderWithAddress
  Scenario: Verify User can place an order with Shipping address and payment Method on file
    And User changes the category to 'Electronics
    And User searchs for an item '	'
    And User clicks on Search icon
    And User clicks on item
    And User selects quantity ‘5’
    And User clicks add to Cart button
    Then the carts icon quantity should change to ‘5’
    And User clicks on Cart option
    And User clicks on Proceed to Checkout button
    And User clicks on Place Your Order
    Then a order placed message should be displayed 'Order Placed Successfully'
