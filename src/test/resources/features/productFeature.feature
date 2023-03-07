
Feature: Add to cart Functionality
 

 @Test
  Scenario Outline: Verify if user is navigated to product details page
    Given the user is in products page
    When user clicks on product "<product>"
    Then user is navigated to product details page 
  
    Examples: 
      | product	|
      |	Sauce Labs Backpack	|
      
      
     Scenario Outline: Verify if user can add product to card from products page
    Given the user is in product page
    When user clicks on add to cart button of product "<product>"
    Then product must be added to cart 
  
    Examples: 
      | product  |
      |	Sauce Labs Backpack	|  
      
     Scenario Outline: Verify if user can add product to card from details page
    Given the user is in product details page on clicking product "<product>"
    When user clicks on add to cart button
    Then product must be added to cart 
  
    Examples: 
      | product  |
      |	Sauce Labs Backpack	|
      
      
    Scenario Outline: Verify if user can add multiple products to cart from details page
    Given user is on product details page on clicking product "<products>"
    And user clicks on add to cart button
    And user clicks on product "<products>"
    When user clicks on add to cart button
    Then product must be added to card
  
    Examples: 
      | products  |
      |	Sauce Labs Backpack,Sauce Labs Onesie|   