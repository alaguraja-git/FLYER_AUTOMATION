Feature: MMS DWI Viewer Fail Feature

@MMS_DWI_Viewer
Scenario Outline: MMS DWI Viewer Fail Scenario
Given user is on MMS_DWI Viewer Page
Then user gets the title of the page
And page title should be "MMS DWI VIEWER"
When I Select Site Value "<SiteValue>" under drop down box
When I Select Product Area "<ProductArea>" under drop down box
When I Select Product Family "<ProductFamily>" under drop down box
When I Select Location Value "<LocationValue>" under drop down box
When I click on LoadInstructionButton in the bottom
Then I check the title "<title>" of the Fail doanloaded page

Examples:
|SiteValue|ProductArea|ProductFamily|LocationValue|title|
|ESS_Nanjing|ASDSAW|DTM|EN|GetInstructionFile|