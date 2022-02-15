Feature: Validate all types of API requests

Scenario: Validate Post Request

Given User sends the API request
When Submit user details to create new user
Then User validate the response with status code as 200

Scenario: Validate Get Request

Given User sends the request
When Fetch the details of created user with username as "klash"
Then Validate the respose with status code as 200


Scenario: Validate Put Request

Given I Set PUT user api endpoint
When Update the details of created user with username as "kool"
Then Get respose with status code as 200

@now
Scenario: Validate Delete Request

Given I Set Delete api endpoint
When Delete the details from the server
Then Validate with status code as 200