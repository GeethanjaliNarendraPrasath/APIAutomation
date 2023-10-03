Feature: Create Tickets in Jira

Background:
Given Set the endpoint
And Set the Auth

Scenario Outline: Create issue with File
When create issue with file '<fileName>'
Then Validate response code as 201
Examples:
|fileName|
|CreateIssue.json|

Scenario: Update Issue
When Update Issue '{"fields": {"description": "Bug creation Using REST API for testing"}}'
Then Validate response code as 204

Scenario: Get Issue
When Get Ticket
Then Validate response code as 200

Scenario: delete Issue
When Delete Issue
Then Validate response code as 204