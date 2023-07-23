# PIM-Module
# Automation Test Suite for OrangeHRM

This repository contains the automation test suite for the OrangeHRM web application using the TestNG framework. The test suite covers various scenarios related to the login module, logout module, and the PIM (People Information Management) module.

## Test Cases Covered

### Login Module:
1. **Login With Valid Credentials:** Verify that a user can successfully log in with valid credentials.
2. **Login With Invalid Credentials:** Verify that a user cannot log in with invalid credentials and appropriate error messages are displayed.
3. **Login With Empty Fields:** Verify that the login form cannot be submitted with empty username and password fields, and proper error messages are displayed.

### Logout Module:
1. **Logout:** Verify that a user can successfully log out from the application.

### PIM Module:
1. **Employee Management:** Verify the functionality of adding, editing, and deleting employee records.
2. **Report Management:** Verify the generation of various reports.
3. **Configuration Dropdown:** Verify the options available under the Configuration dropdown.

## Test Data and Locators

Test data for login credentials and other input parameters are stored in a properties file. Locators for web elements are also managed through this file to ensure easy maintenance and flexibility.

The properties file is named `config.properties` and can be found in the `src/test/resources` directory.

## How to Run the Tests

1. Ensure you have the necessary dependencies for running the tests, including TestNG, Selenium WebDriver, and the appropriate browser driver (e.g., ChromeDriver).
2. Clone this repository to your local machine.
3. Open the project in your preferred Java IDE (e.g., IntelliJ, Eclipse).
4. Set up the dependencies and configure the project to use TestNG.
5. Update the `config.properties` file in the `src/test/resources` directory with the required login credentials and other input parameters.
6. Navigate to the `src/test/java` directory and find the test classes for the login and PIM modules (e.g., `LoginTest.java`, `LogoutTest.java`, `PIMEmployeeManagementTest.java`, etc.).
7. Right-click on each test class and select "Run as TestNG Test" to execute the corresponding test cases.

## Test Reports

After running the test suite, TestNG will generate HTML reports with detailed information about the test execution, including pass/fail status, test duration, and more. These reports can be found in the `test-output` directory under the project's root directory.

## Test Data Maintenance

If any changes are required to the test data, update the `config.properties` file with the new values. Make sure to provide valid login credentials and other inputs for successful test execution.

## Note

This test suite is designed to demonstrate the automation of various scenarios for the OrangeHRM application. Ensure you have the necessary access rights and permissions to perform the actions defined in the test cases.

Please feel free to reach out to the QA team or the test automation engineers for any questions or clarifications regarding the test suite or its execution.

# Manual Testing for OrangeHRM

In addition to automated tests, manual testing plays a crucial role in ensuring the quality of the OrangeHRM application. Manual testing allows testers to explore the application, identify issues, and validate functionality that may not be covered by automated tests. Here are the steps to perform manual testing for OrangeHRM:

## Pre-requisites

Before starting manual testing, ensure the following pre-requisites are met:

1. Access to the OrangeHRM application (URL, username, and password).
2. Test scenarios or test cases to be executed.
3. A test environment that mirrors the production environment.

## Steps for Manual Testing

### 1. Login Module:

**Test Scenarios:**

1. Verify that a user can log in successfully with valid credentials.
2. Verify that a user cannot log in with invalid credentials, and appropriate error messages are displayed.
3. Verify that the login form cannot be submitted with empty username and password fields, and proper error messages are displayed.

**Steps to Execute:**

1. Open the OrangeHRM login page using the provided URL.
2. Enter valid credentials (username and password) and click the "Login" button. Verify that the user is redirected to the home page.
3. Enter invalid credentials and click the "Login" button. Verify that the error message matches the expected one.
4. Leave the username and password fields empty and click the "Login" button. Verify that the appropriate error messages are displayed for both fields.

### 2. Logout Module:

**Test Scenario:**

1. Verify that a user can successfully log out from the application.

**Steps to Execute:**

1. Log in to the OrangeHRM application if not already logged in.
2. Locate the "Logout" or "Sign Out" option, typically available in the top-right corner of the application.
3. Click on the "Logout" or "Sign Out" option. Verify that the user is redirected to the login page.

### 3. PIM Module:

**Test Scenarios:**

1. Verify the functionality of adding, editing, and deleting employee records.
2. Verify the generation of various reports.
3. Verify the options available under the Configuration dropdown.

**Steps to Execute:**

1. Access the PIM module from the main menu or navigation bar.
2. Test the functionality of adding a new employee record by entering valid data into the required fields and saving the record. Verify that the new employee record is successfully added to the system.
3. Test the functionality of editing an existing employee record by locating the record, making changes, and saving the updated data. Verify that the changes are reflected in the employee record.
4. Test the functionality of deleting an employee record by locating the record, selecting the delete option, and confirming the deletion. Verify that the employee record is no longer present in the system.
5. Access the report generation feature and test the generation of various reports (e.g., employee list, attendance report). Verify that the reports contain accurate and relevant data.
6. Click on the "Configuration" dropdown and explore the available options. Verify that the options are accessible and functional.

## Bug Reporting

During manual testing, if any defects or issues are identified, follow the organization's bug reporting process to log the issues. Include detailed steps to reproduce the issue, actual results, expected results, and any relevant screenshots or logs.

## Conclusion

Manual testing complements automated testing by providing an opportunity to explore the application, validate user flows, and ensure a positive user experience. By following the above steps and carefully documenting any issues, the quality of the OrangeHRM application can be thoroughly evaluated and improved.

Happy Testing!

