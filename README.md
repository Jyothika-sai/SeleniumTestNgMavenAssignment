# Selenium_Testng_Java_Maven_AUT

In this assignment as a team, we have done automation testing using Selenium on #facebook.com.
The operations done are:

1. User creation
2. Validating and Verifying
3. Creating multiple users
4. Update User Details
5. Delete user details
6. Valid or Invalid user credentials using Data Provider
7. Assertions
8. Allure results

* Steps:
1. Create a maven project
2. Add dependencies to pom.xml file
3. Build the project
4. Create json files in src/main/resources for LoginData and ValidData
5. Create a java class in src/main/java/pages as Homepage which has all the neccessary locators and functions
6. Create multiple java classes in src/test/java and name them accordingly
7. Write required testcases for each class
8. Run each java class to do the specific operation on facebook.com
9. One can change the testcases and userLoginCredentials by changing it in their specific java classes 

* Steps for Allure report
1. Download allure in your system and add it to the system environment
2. Create testng.xml in .idea 
3. After completely running the above project, run the below maven commands
   1. mvn clean
   2. mvn test
4. After successfully running mvn test allure-report folder should be created
5. Go to the source project folder in file explorer
6. open command prompt by typing cmd in the windows search
7. type command: allure serve
8. This opens the allure report of the project

In this project, all the operations, assertions and allure report is present


