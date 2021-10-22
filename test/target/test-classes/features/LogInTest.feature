Feature: Login Action
Background:
Given User is on login page

# Positive test cases
Scenario Outline: Login with Valid Credentials
	When User enters UserName as "<userName>" and Password as "<password>" and login
	Then Message displayed Login Successfully
	Examples:
						|userName								| password |
						|test@qa-experience.com	| Password1|
						|aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aB@qa.cm	| Password1|
						|aB@c1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBqa.cm	| Password1|	
						|aB@qa.AbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAb	| Password1|
						|test@qa-experience.com	| P8P8P8P% |
						|test@qa-experience.com	| Ab@6Ab@6Ab@6Ab@6|
						
# Negative test cases
Scenario Outline: Login with Invalid UserName format
	When User enters UserName as "<userName>" and Password as "<password>"
	Then Error Message is displayed for UserName
	Examples:
						|userName								| password |
						|t@qa.cm								| Password1|
						|aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc@qa.cm	| Password1|	 
						|te@q.cm								| Password1|	 
						|te@aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc1aBc.cm	| Password1|	 
						|te@qa.c								| Password1|	
						|te@qa.AbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbAbA	| Password1|	
						
Scenario Outline: Login with Invalid Password format
	When User enters UserName as "<userName>" and Password as "<password>"
	Then Error Message is displayed for Password
	Examples:
						|userName								| password |
						|test@qa-experience.com	| Passw&2  |
						|test@qa-experience.com	| Ab@6Ab@6Ab@6Ab@64  |
						
Scenario Outline: Login with Invalid UserName and Password format
	When User enters UserName as "<userName>" and Password as "<password>" and login
	Then Error Message is displayed for invalid Username and Password
	Examples:
						|userName								| password |
						|test@qa-experience.c		| Passw&2  |
						|test										| Ab@6Ab@6Ab@6Ab@64  |
						
Scenario Outline: Login with null UserName and Password format
	When User enters UserName as "<userName>" and Password as "<password>" and login
	Then Login button is disabled
	Examples:
						|userName								| password |
						|												| Password1|
						|test@qa-experience.com	| 				 |
						|												|					 |
						