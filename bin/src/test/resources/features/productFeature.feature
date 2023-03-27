
Feature: Add to cart Functionality
 

 
  Scenario Outline: Verify if user is navigated to product details page
    Given the user is in products page
    When user clicks on product "<product>"
    Then user is navigated to product details page 
  
    Examples: 
      | product	|
      |	Sauce Labs Backpack	|
      
     
     Scenario Outline: Verify if user can add product to card from products page
    Given the user is in products page
    When user clicks on add to cart button of product "<product>"
    Then product "<product>" must be added to cart 
  
    Examples: 
      | product	|
      |	Sauce Labs Backpack	|
      |	Sauce Labs Bike Light,Test.allTheThings() T-Shirt (Red)	|
      
      
    Scenario Outline: Verify if user can add multiple products to cart from details page
    Given user is on product details page on clicking product "<product>"
    And user clicks on add to cart button 
    And user navigates to product page
    And user clicks on product "<nextproduct>"
    When user clicks on add to cart button
    Then product "<products>" must be added to cart
  
    Examples: 
      | product  |	nextproduct	|	products	|
      |	Sauce Labs Backpack	|	Sauce Labs Onesie|	Sauce Labs Backpack,Sauce Labs Onesie	|   