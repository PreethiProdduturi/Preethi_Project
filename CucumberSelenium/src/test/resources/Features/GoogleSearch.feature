
Feature: test google search functionality
 

  @tag1
  Scenario: test google search functionality
    Given browser is open
    When navigates to google
    And enters a text in search box and hits enter
    Then user should navigate to search results
   

  