Feature: Leaftaps Lead Delete Functionality

@SmokeTest @DeleteLead
Scenario Outline: Test Delete Lead Functionality with various datas
Given Click on Find Leads Page
And Click on Phone Tab under Find by
And Enter Phone number as <Phone>
And Click on Find Leads Button
And Get the First LeadID number in the List and Click on it
And Click on Delete Button
And Check Deleted Lead using LeadID

Examples:
|Phone|
|'976542'|
|'976431'|
