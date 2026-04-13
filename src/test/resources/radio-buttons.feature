Feature: Radio button functionality

  Scenario Outline: User selects a radio button
    Given user is on radio button page
    When user selects "<button>" radio button
    Then "<button>" radio button should be selected

    Examples:
      | button |
      | blue   |
      | red    |
      | yellow |
      | black  |
      | green  |
      | basketball |
      | football   |
      | tennis     |
