Feature: DisplayMiddleName

  @ORPHAN
  Scenario Outline: To Verify concatination of full name 
    Given User is on Demo Application 
    When User enters "<firstname>" and "<lastname>"
    And User submits the form
    Then Full name is displayed
      	
      	Examples:
      	| firstname | lastname |
      	|Aniket | Malusare |
      	| Dhiresh | Mundada |
      	| Swapnal | Hingane |
      	|Tejal | Thorve |
