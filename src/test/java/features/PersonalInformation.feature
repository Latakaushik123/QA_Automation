Feature: Update Personal Information

  Scenario: Update Personal Information
    When Update Name
    Then Success Message
    And Exit browser
