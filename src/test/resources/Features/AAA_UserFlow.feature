@Feature
Feature: Feature AAA
This feature file tests All Possible Scenarios of AAA


Scenario:  This is first scenario AAA
	Given Open ApplicationUrl
	When This is Step One
	Then Validate that website has opened

@runthis
Scenario Outline:  This is first scenario AAA
	Given Open ApplicationUrl
	When This is Step One
	When Login to Website with data "<TestDataID>"
	Then Validate that website has opened
	Examples:
| 	TestDataID 	 |
| 	TestData_1   |

	

