Feature: Search and place the order for products

Scenario: Search experience for product search in both home and offer page

Given user is on the Greenkart login page
When user searched with the keyword "tom" in the home page and extracted the actual product
Then user searched the "tom" keyword in the offers page to check the same product is available 
And Compare both product name from home and offer page