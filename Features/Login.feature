Feature: Login

  Scenario: Successful Login with Valid Credentials

    Given User Launch Chrome browser

    When User opens URL "https://the-internet.herokuapp.com/login"

    And User enters Email as "tomsmith" and Password as "SuperSecretPassword!"

    And Click on Login

    Then Page Title should be "The Internet"

    When User click on Log out link

    Then Page Title should be "The Internet"

    And close browser

    

  Scenario Outline: Login Data Driven

    Given User Launch Chrome browser

    When User opens URL "https://the-internet.herokuapp.com/login"

    And User enters Email as "<email>" and Password as "<password>"

    And Click on Login

    Then Page Title should be "The Internet"

    When User click on Log out link

    Then Page Title should be "The Internet"

    And close browser
    Examples:
        | email | password |
        | tomsmith   | Value 2  |
        |tomsmith1 | SuperSecretPassword!1 |