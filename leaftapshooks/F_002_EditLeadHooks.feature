Feature: Leaftaps Lead Edit Functioanlity

@SanityTest @EditLead
Scenario Outline: Test Edit Lead Functioanlity with various datas
Given Click on Find Leads Page
And Give First name as <FirstName>
And Give Last name as <LastName>
And Give Company name as <CompanyName>
And Click on Find Leads Button
And Click on First LeadID in the Lead List
Given Click on Edit Button
And Edit Company name as <EditedCompanyName>
And Edit Last name as <EditedLastName>
And Click on Update Button
Then Updated View Lead Page is shown

Examples: 
|FirstName|LastName|CompanyName|EditedCompanyName|EditedLastName|
|'Siva'|'S'|'Testleaf'|'Infosys'|'SS'|
|'S_i_v_a'|'S'|'TCS'|'Google'|'SKS'|