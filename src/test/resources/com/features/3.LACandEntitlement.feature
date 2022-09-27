Feature: LACandEntitlement Feature

Background:
Given user has already logged in to application
|username|password|
|zrajala@ericsson.com|VXNpbGFtcGF0dGlAMTIzNA==|

@LACandEntitlement
Scenario Outline: LACandEntitlement
Then click on postxml icon in home page
Then enter the valid xml file in inputXML text box
And check the availability of created LAC in response xml file
Then provide valid LAC and click on Activation Link
And provide values to HR Resource Name and Fingerprint fields
And provide valid values "<QTY1>" and "<QTY2>" and "<QTY3>" as per Activation Validation Rules
Then click on Next Button
And enter mail id "<MailID>" and click on Finish Button
Then click on view summary and validate "<activation>" name
And click on view details
Then validate view transcation details "<ViewDetails_CurrentValue_QTY1>" and "<ViewDetails_CurrentValue_QTY2>" and "<ViewDetails_CurrentValue_QTY3>" values

Examples: 
        |QTY1|QTY2|QTY3|MailID|activation|ViewDetails_CurrentValue_QTY1|ViewDetails_CurrentValue_QTY2|ViewDetails_CurrentValue_QTY3|
        |16|16|32|alaguraja.r@hcl.com|New activation|32|16|16|