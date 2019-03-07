Feature: DisplayMiddleName

  @ORPHAN
  Scenario Outline: To Verify concatination of full name 
    Given User is on Demo Application
        When User enter "<firstname>" , "<middlename>" and "<lastname>"
        And User submits the form
        Then full name is displayed
            
            Examples:
            | firstname | middlename | lastname |
            |Thomas | Schmidt | Webber |
            | Jon | De | Potter |
            | Karl | Jakob |Schindler |
