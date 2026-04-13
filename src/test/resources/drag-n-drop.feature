Feature: Drag and Drop functionality

  Scenario Outline: User drags items to target
    Given user is on drag and drop page
    When user drags "<item>" to target
    Then "<item>" should be dropped successfully

    Examples:
      | item |
      | A    |
      | B    |