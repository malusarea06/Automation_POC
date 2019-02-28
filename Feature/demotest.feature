Feature: DemoTest

  @ORPHAN
  Scenario: LoginScena
    Given open application in Chrome
    When i enter firstname
    Then display name
