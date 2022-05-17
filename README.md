# PetStore-Cucumber-RestAssured-framework

API Automation test for Pet store API

 - Swagger - https://petstore3.swagger.io/
 - baseURL - https://petstore3.swagger.io/api/v3
 - resource - /pet/findByStatus
 - API Method - GET

### Technology Stack used:

* Language - Java
* Build/Run Tool - Maven
* Test run framework - TestNG
* BDD framework - Cucumber.io
* API Client - Rest-Asssured

### Pre-requisites 

Environment Requirements: 
- Maven (Preferably the latest version), 
- Java 1.8 or later, 
- Eclipse or IntelliJ IDE

### Test Execution

* Source code is available at - [GitHub - PetStore-FindByStatus](https://github.com/vicky2293/PetStore-FindByStatus)
* To clone the project in local - git clone https://github.com/vicky2293/PetStore-FindByStatus.git
* After cloning the project, run command `mvn clean compile`
* To run the tests, follow any one of the below option:
    * Using command line `mvn clean test` from project root directory
    * Open `testng.xml` and click on Run button

###Test Validations

* Response code
* Normal performance response time
* Log and check all the pets are Lions in the result
* Json schema validation

### Test Results

* For Live report - Refer - Terminal window
* For HTML report(Extent Reports) - Refer - /report/AutomationReport.html


## Continuous Integration - GitHub Actions

The project is integrated with GitHub actions for continuous integration

* Configuration file is located [Here](https://github.com/vicky2293/PetStore-FindByStatus/blob/main/.github/workflows/maven.yml)
* GitHub Actions workflow: [GitHub Actions](https://github.com/vicky2293/PetStore-FindByStatus/actions)

## Sonarcloud Integration

The project is integrated with Sonarcloud for quality check

* Sonarcloud: [Sonarcloud Report](https://sonarcloud.io/summary/new_code?id=vicky2293_PetStore-FindByStatus&branch=main)
 