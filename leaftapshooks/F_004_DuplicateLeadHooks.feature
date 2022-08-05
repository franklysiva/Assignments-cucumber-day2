Feature: Leaftaps Lead Duplicate Functionality

@SanityTest @DuplicateLead
Scenario Outline: Test Duplicate Lead Functionality with various datas
Given Click on Find Leads Page
And Click on Phone Tab under Find by
And Enter Phone number as <Phone>
And Click on Find Leads Button
And Click on First LeadID in the Lead List
And Click on Duplicate Lead Button

Examples:
|Phone|
|'986532'|
|'976430'|