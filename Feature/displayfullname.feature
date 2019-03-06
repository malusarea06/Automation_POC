Feature: DisplayFullName

  Scenario Outline: Full Name to have First and Last Name 
      	Given User is on Demo Application 
      	When User enters "<firstname>" and "<lastname>"
      	And User submits the form
      	Then Full name is displayed
      	
      	Examples:
      	| firstname | lastname |
      	|James | Bond |
      	| Mary | Jones |
      	| Alex | J |
  
