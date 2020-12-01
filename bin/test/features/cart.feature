Feature: Cart

@flipkart @TC-104
Scenario: Validate Add to Cart option
	When user searches for "Samsung" phones
	And clicks on the first mobile in the search results
	And clicks on 'Add to Cart' button
	And opens cart page by clicking on "VIEW CART" link
	Then the selected mobile should appear in the cart page.