Feature:
  Background: User has a registered account

    Scenario: User can log in
      Given user is on login page
      When user inputs username "practice"
      And user inputs password "SuperSecretPassword!"
      And user clicks on submit button
      Then user is logged in

  Scenario Outline: User login with different credentials
    Given user is on login page
    When user inputs username "<username>"
    And user inputs password "<password>"
    And user clicks on submit button
    Then login message should be "<result>"

    Examples:
      | username | password             | result                         |
      | practice | SuperSecretPassword! | You logged into a secure area! |
      | practice | wrongPassword        | Your password is invalid!      |
      | random   | SuperSecretPassword! | Your password is invalid!      |
      |          |                      | Your username is invalid!      |