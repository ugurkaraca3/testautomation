Feature: Petclinic Test

	
	Scenario: Verification of successful owner find
	Given Browser is opened
	When Petclinic is opened
	And Find Owner is clicked
	And Search LastName
	|LastName|
	|karaca|	
	And Search is clicked
	Then Owner Verified
	
	

	