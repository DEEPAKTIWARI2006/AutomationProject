@Feature
Feature: Feature AAB
This feature file tests All Possible Scenarios of AAB

@runthis
Scenario Outline:  This is first scenario AAB
	Given This is Step One
	When Login to Website with data "<TestDataID>"
	Then Validate that website has opened
	Examples:
| 	TestDataID 	 |
| 	TestData_1   |

@runthis
Scenario Outline:  This is second scenario AAB
	Given This is Step One
	When Login to Website with data "<TestDataID>"
	Then User should be logged in
	Examples:
| 	TestDataID 	 |
| 	TestData_1   |
	

