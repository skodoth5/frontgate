# frontgate


Need eclipse with java to run this project
Automation platform — Used eclipse IDE and selenium WebDriver with scripts in Java.
qa.ticket.testcases — This package has all the below testcases


Attaching a video of the script run with the email.

	Testcases 1,2,3 are in HomePageVerify.java
	Testcase 4 in TicketPurchase.java


TestBase.java have the initial setup for launching chromedriver.
Please change the chrome driver location according to the location of your systems chrome driver.(in config.properties file “driver_path”)

qa.ticket.pages — This package has all the classes for each webpage.



 other validations/verifications you feel would be beneficial and would want to add if you were automating this for real.——

	•	I would add screenshots for every failed test cases by adding Listeners.
	•	Negative scenarios need to be covered
	•	read input from excel

Prerequisite -
For every run new email id is needed for Testcase 4 since create account won’t work with existing email.

Userflow to automate and test:
go to qatest.frontgatetickets.com
VERIFICATIONS (include automated test assertions):
Testcase 1 -  'edc test event' is displayed on page
Testcase 2 -  the event venue is displayed -> 'South Austin Recreation Centah (Park)'
Testcase 3 - report all Ticket names showing as 'SOLD OUT'
Testcase 4 - select 'Select Tickets' for 'edc test event' 
add to cart quantity 1 of Ticket 'GA pass GA'
select 'add to cart'
proceed to checkout
create a new account using email '<someuniquestring>@testtest.net'
fill out all the required checkout information 
On Payment Information, select Credit Card (see note above about test card) 
Decline Secure Ticket — exclude step
Complete the purchase
VERIFICATION: include a test assertion that proves purchase was successful (or fails test if purchase fails)
