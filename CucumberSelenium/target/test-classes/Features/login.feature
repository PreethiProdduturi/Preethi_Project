
#@Smoketest
Feature: feature to test login functionality
 
  Scenario Outline: verify login with credentials
    Given launch facebook url  <url>
    When enter username <username> and password <password>
    And  click on login button
    Then verify the login from username <username>
 

    Examples: 
      | url                       | username              | password   |
      | https://www.facebook.com/ |  | |
