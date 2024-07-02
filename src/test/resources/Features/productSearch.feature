Feature: Product Search at amazon.com
  This is the feature file testing multi product search on amazon.com website


  Scenario Outline: multi product search on amazon.com
    
    Given I am on amazon.com home page
    When I input <productName> as a product in the search box 
    And click on the search button
    Then search result page is displayed as <productName>
    And search result total is <searchResult>

    Examples: 
      | productName     |searchResult                                    |                         
      | "bic pen"       |"1-48 of over 1,000 results for \"bic pen\""    |
      | "Sharpie pen"   |"1-48 of over 2,000 results for \"Sharpie pen\""|