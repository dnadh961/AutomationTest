Feature: Create Account

@ae @TC-100
Scenario: Validate creation of new account
	Given user opens automation practice url in the browser
	When user clicks on Sign in link
	And enters email address
	And clicks on create account
	And sets Title
	And sets FirstName
	And sets LastName
	And sets Password
	And sets Date of birth
	And sets Address
	And clicks on Register button
	Then user should see My Account page
	