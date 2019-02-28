#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Demo Website Testing
  @Newtest
  Scenario: Verify Full Name 
  	Given  open application in "Chrome"
  	When  i enter firstname and middlename and lastname
  	Then  full Name is displayed
  
  @Oldtest
  Scenario Outline: Verify full name concatination
  	Given  open application in "Chrome"
  	When i enter "<firstname>" and "<middlename>" and"<lastname>"
  	Then full name is displayed
  	
  	Examples:
  	| firstname | middlename | lastname |
  	|Aniket | Satyawan | Malusare |
  	| Karan | Rajesh | Patil |
  	| Swapnil | Prakash |Hire |
  	|Tejal | Shivaji | Thorve |
  	
  	

  	
  	

  
