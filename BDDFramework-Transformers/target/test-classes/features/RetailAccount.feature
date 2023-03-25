@JenkinsTriggerTest
Feature: Retail Application Account Feature

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'test.shaiq@tek.com' and password 'Tek@12345'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option

  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'transformers' and Phone '1012023855'
    And User click on Update button
    Then User profile information should be updated

  @addAddress
  Scenario: Verify User can add  an Address
    When User click on Account option
    And User click on  Add address option
    And User fill new address form with below information
      | country | fullName | PhoneNumber | StreetAddress | apt | city | state | zipCode |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  
  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Tek@12345        | Tek@12346  | Tek@123456      |
    And User click on Change Password button
    Then a password message should be displayed 'Password Updated Successfully'

  @addPayment
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard   | expirationMonth | expirationYear | securityCode |
      | 1234106443214321 | Ahmad Dashty |               7 |           2027 |          223 |
    And User click on Add your card button
    Then a payment message should be displayed 'Payment Method added sucessfully'

  @editPayment
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And user edit information with below data
      | editCardNumber   | editNameOnCard | editExpirationMonth | editExpirationYear | editSecurityCode |
      | 1234567887654355 | Transformers   |                   9 |               2026 |              322 |
    And user click on Update Your Card button
    Then a update message should be displayed 'Payment Method updated Successfully'

  @removeCard
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed

  @updateAddress
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country | fullName  | phoneNumber | streetAddress | apt | city    | state   | zipCode |
      | Canada  | Ahmad Jan |  1237074422 | 100 14th NW   | A   | NewCity | Alberta |   20002 |
    And User click update Your Address button
    Then a address update message should be displayed 'Address Updated Successfully'

  @removeAddress
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed

 
   