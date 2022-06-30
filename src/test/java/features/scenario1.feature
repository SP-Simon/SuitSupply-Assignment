@scenario1


Feature: search for selenium bdd frameworks on google and save the title and url of the results in CSV file
  
 
 Scenario: search selenium bdd frameworks on google

Given user is on google search page "https://www.google.co.in"
And searches for "selenium bdd framework"
When user clicks on search button
Then the results should be displayed and saved in csv file

@Demo
 Scenario Outline: search selenium bdd frameworks on google

  Given user is on google search page "<url>"
  And searches for "<search>"
  When user clicks on search button
  Then the results should be displayed and saved in csv file
  Examples:
   |url| search|
   |https://suitsupply.com/en-nl/custommade?countryCode=NL&mode=CMTM&product=Jacket&client=onLine&sizePassport=true&sessionId=dbf55910-00e4-40d8-8b4e-4ae256376be2&sectionCode=FabricSection| selenium bdd framework|
   |https://www.google.co.in| suitsupply|
