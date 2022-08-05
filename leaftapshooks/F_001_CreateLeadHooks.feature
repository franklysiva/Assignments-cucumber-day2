Feature: Leaftaps Lead Creation Functionality

@SmokeTest @RegressionTest @CreateLead
Scenario Outline: Test Create Lead Functionlity with various datas
Given Click on Create Lead Page
And Enter Company name as <CompanyName>
And Enter First name as <FirstName>
And Enter Last name as <LastName>
And Give Phone number as <Phone>
And Click on Create Lead Submit Button
Then View Lead Page should be displayed


Examples:
|CompanyName|FirstName|LastName|Phone|
|'Testleaf'|'Siva'|'S'|'986532'|
|'TCS'|'S_i_v_a'|'S'|'976542'|
|'Testleaf'|'Siva'|'SK'|'976431'|
|'Testleaf'|'SK'|'Siva'|'976430'|