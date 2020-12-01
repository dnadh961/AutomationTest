Feature: Search

@flipkart @TC-103
Scenario: Validate search functionality
	When user searches for "Samsung"
	Then all the search results title should contain 'Samsung'
	