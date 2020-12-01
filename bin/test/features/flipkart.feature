Feature: flipkart home page

@flipkart @TC-100
Scenario: Validate Login for valid credentials
	Given user opens flipkart url in the browser
	When user logs in with given user name "9100826115" and password "laxman"
	Then My Account link should appear at top corner of the page

	
@flipkart @TC-101
Scenario: Validate Login for invalid credentials
	Given user opens flipkart url in browser
	When user logs in with the user name "9100826115" and password "dev"
	Then 'Invalid details. Please try again.' erorr message should appear