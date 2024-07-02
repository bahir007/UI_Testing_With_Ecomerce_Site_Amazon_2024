Feature: Product Search and add to cart at amazon.com
  This is the feature file testing product search and add to cart on amazon.com website.


  Scenario: product search and add to cart on amazon.com
    
    Given I am on amazon.com home page
    And I input "bic pen" as a product in the search box 
    And click on the search button
    When click on Add to cart button
    Then Number of items in cart changes to one