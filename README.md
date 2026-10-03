Paste the following **exactly** into `README.md` on GitHub:

````markdown
# E-Commerce Hybrid Automation Framework

A hybrid test automation framework built using **Java, Selenium WebDriver, TestNG, Cucumber, REST Assured, and Maven** for automating both **UI workflows and REST APIs** of an e-commerce application.

The framework follows the **Page Object Model (POM)** and supports **Behavior-Driven Development (BDD)** using Cucumber and Gherkin, along with API automation using REST Assured.

---

## Project Overview

The objective of this project is to develop a reusable and maintainable automation framework for testing an e-commerce application through multiple testing layers.

The framework currently provides:

- UI automation using Selenium WebDriver
- Test execution using TestNG
- Page Object Model architecture
- BDD automation using Cucumber and Gherkin
- REST API automation using REST Assured
- JSON and JSONPath response validation
- Maven-based build and test execution
- Cucumber HTML reporting
- Git and GitHub version control

---

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver | Web UI automation |
| TestNG | Test execution and assertions |
| Cucumber | BDD test automation |
| Gherkin | Human-readable test scenarios |
| REST Assured | REST API automation |
| Maven | Build and dependency management |
| JSON / JSONPath | API response validation |
| Google Chrome | Browser for UI automation |
| Git | Version control |
| GitHub | Source code hosting |

---

## Applications Under Test

### UI Application

**SauceDemo**

URL:

```text
https://www.saucedemo.com/
````

The UI automation covers:

* Valid login
* Invalid login
* Product selection
* Add product to cart
* Cart validation
* Checkout workflow
* Order completion

### API Application

**DummyJSON**

Base URL:

```text
https://dummyjson.com
```

The API automation covers:

* Get all products
* Get product by ID
* Search products
* Add product
* Update product
* Delete product

> Note: DummyJSON simulates several write operations, so POST, PUT and DELETE tests validate the API responses rather than expecting permanent changes to server-side data.

---

# Framework Architecture

The project follows a layered hybrid automation architecture.

```text
                 E-COMMERCE HYBRID AUTOMATION FRAMEWORK
                                  |
              +-------------------+-------------------+
              |                                       |
              v                                       v
        UI AUTOMATION                            API AUTOMATION
              |                                       |
          Selenium                              REST Assured
              |                                       |
           TestNG                              API Classes
              |                                       |
      Page Object Model                       JSON / JSONPath
              |                                       |
              +-------------------+-------------------+
                                  |
                                  v
                           TEST EXECUTION
                                  |
                                Maven
                                  |
                                  v
                             TEST REPORTS
```

---

# UI Automation Architecture

The UI automation layer follows the **Page Object Model**.

```text
LoginTest
    |
    v
LoginPage
    |
    v
ProductsPage
    |
    v
CartPage
    |
    v
CheckoutPage
    |
    v
Selenium WebDriver
    |
    v
Chrome Browser
```

The Page Object Model separates page-specific locators and actions from test classes.

---

# API Automation Architecture

The API automation layer uses REST Assured.

```text
ProductApiTest
       |
       v
   ProductApi
       |
       v
 REST Assured
       |
       v
 DummyJSON API
       |
       v
 JSON Response
       |
       v
 Assertions / JSONPath
```

This separation keeps API request handling independent from API test validation.

---

# BDD / Cucumber Architecture

The framework also supports Behavior-Driven Development using Cucumber and Gherkin.

```text
Feature File
     |
     v
Gherkin Scenario
     |
     v
Step Definitions
     |
     v
Page Objects
     |
     v
Selenium WebDriver
     |
     v
Web Application
```

Example:

```gherkin
Feature: User Login

  Scenario: Successful login with valid credentials

    Given the user is on the login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be redirected to the inventory page
```

---

# Project Structure

```text
ecommerce-hybrid-automation-framework/
│
├── src/
│   │
│   ├── main/
│   │   │
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── wipro/
│   │   │           └── automation/
│   │   │               │
│   │   │               ├── api/
│   │   │               │   └── ProductApi.java
│   │   │               │
│   │   │               ├── pages/
│   │   │               │   ├── LoginPage.java
│   │   │               │   ├── ProductsPage.java
│   │   │               │   ├── CartPage.java
│   │   │               │   └── CheckoutPage.java
│   │   │               │
│   │   │               └── utils/
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       │
│       ├── java/
│       │   └── com/
│       │       └── wipro/
│       │           └── automation/
│       │               │
│       │               ├── base/
│       │               │   └── BaseTest.java
│       │               │
│       │               ├── runners/
│       │               │   └── CucumberTest.java
│       │               │
│       │               ├── steps/
│       │               │   ├── CucumberHooks.java
│       │               │   └── LoginSteps.java
│       │               │
│       │               └── tests/
│       │                   ├── LoginTest.java
│       │                   ├── CheckoutTest.java
│       │                   └── ProductApiTest.java
│       │
│       └── resources/
│           └── features/
│               └── login.feature
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# Main Framework Components

## BaseTest

`BaseTest.java`

Responsible for:

* Launching Chrome
* Configuring Chrome options
* Maximizing the browser
* Configuring waits
* Opening the application
* Closing the browser after test execution

---

## Page Object Model

The UI is divided into separate page classes.

### LoginPage

Handles:

* Username
* Password
* Login button
* Invalid login message

### ProductsPage

Handles:

* Product selection
* Adding products to the cart
* Opening the cart
* Product interactions

### CartPage

Handles:

* Cart validation
* Checkout navigation
* Continue shopping

### CheckoutPage

Handles:

* Customer information
* Checkout navigation
* Order completion
* Order confirmation

---

# TestNG Layer

TestNG is used for:

* Test execution
* Assertions
* Test lifecycle management
* `@BeforeMethod`
* `@AfterMethod`

Current UI test classes:

```text
LoginTest
CheckoutTest
```

---

# Cucumber Layer

Cucumber is used for BDD-style test automation.

Current components:

```text
features/
└── login.feature
```

Step definitions:

```text
LoginSteps.java
```

Hooks:

```text
CucumberHooks.java
```

Runner:

```text
CucumberTest.java
```

Cucumber HTML report:

```text
target/cucumber-report.html
```

---

# REST API Automation

REST Assured is used for REST API testing.

Current API test class:

```text
ProductApiTest.java
```

Current API operations:

```text
GET     /products
GET     /products/{id}
GET     /products/search?q={query}
POST    /products/add
PUT     /products/{id}
DELETE  /products/{id}
```

The framework validates:

* HTTP status codes
* JSON response fields
* Product IDs
* Product titles
* Search responses
* Delete confirmation

---

# Current Test Coverage

The current framework executes **10 automated tests**.

## UI / TestNG Tests

```text
1. Valid login
2. Invalid login
3. Complete checkout flow
```

## Cucumber Test

```text
4. Successful login using BDD scenario
```

## API / REST Assured Tests

```text
5. Get all products
6. Get product by ID
7. Search products
8. Add product
9. Update product
10. Delete product
```

---

# Test Execution Flow

When the project is executed using Maven:

```text
mvn test
    |
    v
Compile Source Code
    |
    v
Compile Test Code
    |
    v
Execute Automated Tests
    |
    +------------------------+
    |                        |
    v                        v
 UI / TestNG Tests       API Tests
    |                        |
 Selenium                REST Assured
    |
    v
Cucumber Scenarios
    |
    v
Assertions
    |
    v
Test Reports
```

---

# Maven

Maven is used for:

* Dependency management
* Project compilation
* Test execution
* Project packaging

## Compile

```bash
mvn compile
```

Compiles the main source code.

## Run Tests

```bash
mvn test
```

Compiles the project and executes the automated tests.

## Package

```bash
mvn package
```

Builds and packages the project after successful test execution.

---

# Test Execution Result

Current successful execution:

```text
Tests run: 10
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

# Configuration

Application configuration is stored in:

```text
src/main/resources/config.properties
```

Example:

```properties
browser=chrome
ui.base.url=https://www.saucedemo.com/
api.base.url=https://dummyjson.com
```

This keeps application configuration separate from test logic.

---

# Reporting

The project uses Maven/Surefire for test execution and Cucumber HTML reporting.

Cucumber report:

```text
target/cucumber-report.html
```

Surefire reports:

```text
target/surefire-reports/
```

---

# Synchronization

The framework uses Selenium synchronization mechanisms to improve test stability, including:

* Implicit waits
* Explicit waits
* WebDriverWait
* Expected Conditions

Synchronization is particularly useful when elements are dynamically loaded or page transitions take time.

---

# Error Handling

The framework handles common Selenium automation issues such as:

* Dynamic page loading
* Stale element references
* Element visibility
* Element availability
* Navigation timing

Explicit waits are used where required to improve test reliability.

---

# Design Principles

## Separation of Concerns

Test logic, page interactions and API requests are maintained in separate classes.

## Reusability

Common browser setup and reusable page methods are shared across multiple tests.

## Maintainability

Locators and page-specific interactions are kept inside Page Object classes.

## Readability

Cucumber feature files describe business scenarios in readable Gherkin syntax.

## Scalability

Additional pages, API modules and feature files can be added without redesigning the complete framework.

---

# How to Run the Project

## Prerequisites

Install:

* Java JDK
* Eclipse IDE or another Java IDE
* Maven
* Google Chrome
* Git

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

---

# Clone the Repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Navigate to the project:

```bash
cd ecommerce-hybrid-automation-framework
```

---

# Run All Tests

```bash
mvn test
```

---

# Build the Project

```bash
mvn package
```

---

# Git Workflow

The project uses Git for source control.

Typical workflow:

```bash
git add .
git commit -m "Update automation framework"
git push origin main
```

---

# Future Enhancements

The framework can be extended with:

* Parallel test execution
* Cross-browser testing
* Data-driven testing
* Additional Cucumber scenarios
* API authentication scenarios
* Additional API coverage
* Screenshot capture on test failure
* Enhanced HTML reporting
* Jenkins integration
* CI/CD pipeline
* Multiple test environments
* Mobile automation using Appium

---

# Learning Outcomes

This project provides practical implementation of:

* Selenium WebDriver
* Web element identification
* CSS selectors and XPath
* Browser automation
* Synchronization strategies
* TestNG
* Assertions
* Page Object Model
* Maven lifecycle
* Cucumber
* Gherkin
* Behavior-Driven Development
* REST API testing
* HTTP methods
* HTTP status validation
* JSON response validation
* JSONPath
* REST Assured
* Git and GitHub

---

# Author

B.Tech Computer Science & Engineering (AI & ML)

---

## Disclaimer

This project is developed for educational and automation-testing purposes. SauceDemo and DummyJSON are used as publicly available demo/testing applications and APIs.

```
```
