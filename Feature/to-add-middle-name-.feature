Feature: To add Middle Name 

  Full name should have Middle name 

  @ORPHAN
  Scenario: To Concatenate Middle name as part of Full Name 
    Given User is on Demo Application
    When User enters First Name, Middle name and Last name
    And User Submits the form
    Then Full name is displayed with Middle Name 
