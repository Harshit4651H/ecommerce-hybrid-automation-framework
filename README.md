# E-Commerce Hybrid Automation Framework

A hybrid automation testing framework built with **Java, Selenium WebDriver, TestNG, Cucumber, REST Assured, and Maven** for testing an e-commerce application through both **UI automation** and **REST API automation**.

The framework follows the **Page Object Model (POM)** for maintainable UI automation and uses **Behavior-Driven Development (BDD)** with Cucumber/Gherkin for business-readable scenarios.

---

## 📌 Project Overview

This project demonstrates how a practical automation framework can combine multiple testing approaches in one Maven project.

### What this project automates

**UI Testing**
- Valid user login
- Invalid login validation
- Product selection
- Add product to cart
- Cart validation
- Checkout workflow
- Order completion

**BDD Testing**
- Login scenario using Cucumber
- Gherkin feature file
- Step definitions
- Cucumber hooks
- Cucumber test runner

**API Testing**
- Get all products
- Get product by ID
- Search products
- Add product
- Update product
- Delete product
- HTTP status validation
- JSON response validation

---

# 🌐 Applications Used

## 1. UI Application — SauceDemo

**Application:** SauceDemo  
**URL:** https://www.saucedemo.com/

SauceDemo is used as the e-commerce application under test.

### Main UI workflow

```text
Login
  ↓
Products
  ↓
Add Product
  ↓
Cart
  ↓
Checkout
  ↓
Customer Information
  ↓
Order Overview
  ↓
Order Complete
```

### 📸 UI Screenshots

Screenshots should be captured from the application during your own automation run and stored under:

```text
docs/screenshots/
```

Recommended screenshots:

- Login page
- Invalid login message
- Products page
- Cart page
- Checkout information page
- Order overview page
- Order completion page

Example Markdown image syntax:

```markdown
![SauceDemo Login](docs/screenshots/login-page.png)
![Invalid Login](docs/screenshots/invalid-login.png)
![Products](docs/screenshots/products-page.png)
![Cart](docs/screenshots/cart-page.png)
![Checkout](docs/screenshots/checkout-page.png)
![Order Complete](docs/screenshots/order-complete.png)
```

### Login Page

![Login Page](docs/screenshots/login-page.png)

### Invalid Login

![Invalid Login](docs/screenshots/invalid-login.png)

### Products Page

![Products Page](docs/screenshots/products-page.png)

### Cart Page

![Cart Page](docs/screenshots/cart-page.png)

### Checkout Page

![Checkout Page](docs/screenshots/checkout-page.png)

### Order Complete

![Order Complete](docs/screenshots/order-complete.png)

> The image references above are intentionally stored as repository paths so the README becomes visual and easy to follow after the corresponding screenshots are added to `docs/screenshots/`.

---

## 2. API Application — DummyJSON

**API:** DummyJSON  
**Base URL:** https://dummyjson.com

The API layer is used to demonstrate REST API automation using REST Assured.

### API operations covered

```text
GET     /products
GET     /products/{id}
GET     /products/search?q={query}
POST    /products/add
PUT     /products/{id}
DELETE  /products/{id}
```

> DummyJSON simulates several write operations, so POST, PUT and DELETE tests validate the returned API response rather than expecting permanent server-side changes.

---

# 🧰 Technology Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver | Web UI automation |
| TestNG | Test execution and assertions |
| Cucumber | BDD automation |
| Gherkin | Human-readable test scenarios |
| REST Assured | REST API automation |
| JSON / JSONPath | API response validation |
| Maven | Build and dependency management |
| Google Chrome | Browser for UI automation |
| Git | Version control |
| GitHub | Source code hosting |

---

# 🏗️ Framework Architecture

The project follows a layered hybrid automation architecture.

```text
                 E-COMMERCE HYBRID AUTOMATION FRAMEWORK
                                  │
                 ┌────────────────┴────────────────┐
                 │                                 │
                 ▼                                 ▼
          UI AUTOMATION                       API AUTOMATION
                 │                                 │
             Selenium                         REST Assured
                 │                                 │
              TestNG                         ProductApi
                 │                                 │
         Page Object Model                  JSON / JSONPath
                 │                                 │
                 └────────────────┬────────────────┘
                                  │
                                  ▼
                           Maven Test Execution
                                  │
                                  ▼
                              Test Reports
```

---

# 🖥️ UI Automation Architecture

The UI layer follows the **Page Object Model (POM)**.

```text
LoginTest
    │
    ▼
LoginPage
    │
    ▼
ProductsPage
    │
    ▼
CartPage
    │
    ▼
CheckoutPage
    │
    ▼
Selenium WebDriver
    │
    ▼
Chrome Browser
    │
    ▼
SauceDemo
```

### Page Objects

| Page Object | Responsibility |
|---|---|
| `LoginPage` | Username, password, login action and invalid-login validation |
| `ProductsPage` | Product selection, add-to-cart and cart navigation |
| `CartPage` | Cart validation and checkout navigation |
| `CheckoutPage` | Customer details, checkout navigation and order completion |

---

# 🔄 BDD / Cucumber Architecture

Cucumber is used to describe business scenarios in Gherkin syntax.

```text
Feature File
     │
     ▼
Gherkin Scenario
     │
     ▼
Step Definitions
     │
     ▼
Page Object
     │
     ▼
Selenium WebDriver
     │
     ▼
Web Application
```

### Example Scenario

```gherkin
Feature: User Login

  Scenario: Successful login with valid credentials

    Given the user is on the login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be redirected to the inventory page
```

### Cucumber components

```text
login.feature
     │
     ├── LoginSteps.java
     ├── CucumberHooks.java
     └── CucumberTest.java
```

---

# 🔌 API Automation Architecture

The API layer separates API request logic from API test cases.

```text
ProductApiTest
       │
       ▼
   ProductApi
       │
       ▼
 REST Assured
       │
       ▼
 DummyJSON API
       │
       ▼
 JSON Response
       │
       ▼
 Assertions / JSONPath
```

### API validation includes

- HTTP status code
- Response body
- Product ID
- Product title
- Search results
- Delete confirmation
- JSON fields

---

# 📁 Project Structure

```text
ecommerce-hybrid-automation-framework/
│
├── src/
│   │
│   ├── main/
│   │   ├── java/
│   │   │   └── com.wipro.automation/
│   │   │       ├── api/
│   │   │       │   └── ProductApi.java
│   │   │       │
│   │   │       ├── pages/
│   │   │       │   ├── LoginPage.java
│   │   │       │   ├── ProductsPage.java
│   │   │       │   ├── CartPage.java
│   │   │       │   └── CheckoutPage.java
│   │   │       │
│   │   │       └── utils/
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       ├── java/
│       │   └── com.wipro.automation/
│       │       ├── base/
│       │       │   └── BaseTest.java
│       │       │
│       │       ├── runners/
│       │       │   └── CucumberTest.java
│       │       │
│       │       ├── steps/
│       │       │   ├── CucumberHooks.java
│       │       │   └── LoginSteps.java
│       │       │
│       │       └── tests/
│       │           ├── LoginTest.java
│       │           ├── CheckoutTest.java
│       │           └── ProductApiTest.java
│       │
│       └── resources/
│           └── features/
│               └── login.feature
│
├── docs/
│   └── screenshots/
│       ├── login-page.png
│       ├── invalid-login.png
│       ├── products-page.png
│       ├── cart-page.png
│       ├── checkout-page.png
│       └── order-complete.png
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# 🧪 Automated Test Coverage

The current framework executes **10 automated tests**.

## UI / TestNG

| Test ID | Test Case |
|---|---|
| UI-01 | Valid Login |
| UI-02 | Invalid Login |
| UI-03 | Complete Checkout Flow |

## Cucumber

| Test ID | Scenario |
|---|---|
| BDD-01 | Successful Login with Valid Credentials |

## API / REST Assured

| Test ID | Test Case |
|---|---|
| API-01 | Get All Products |
| API-02 | Get Product by ID |
| API-03 | Search Products |
| API-04 | Add Product |
| API-05 | Update Product |
| API-06 | Delete Product |

---

# ▶️ Test Execution

The full automation suite can be executed using Maven.

## Compile

```bash
mvn compile
```

## Run Tests

```bash
mvn test
```

## Package Project

```bash
mvn package
```

---

# ✅ Current Test Result

Latest successful execution:

```text
Tests run: 10
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

# 📊 Reporting

The project uses Maven/Surefire for test execution and Cucumber HTML reporting.

### Cucumber HTML report

```text
target/cucumber-report.html
```

### Surefire reports

```text
target/surefire-reports/
```

These reports help identify:

- Total tests
- Passed tests
- Failed tests
- Skipped tests
- Execution details
- Cucumber scenario results

---

# ⏳ Synchronization

The framework uses Selenium synchronization mechanisms to improve test stability.

Current techniques include:

- Implicit waits
- Explicit waits
- `WebDriverWait`
- Expected Conditions

These are used for page navigation, element visibility and dynamic page updates.

---

# 🧱 Framework Design Principles

## Separation of Concerns

Test logic, page interactions and API request handling are maintained in separate classes.

## Reusability

Common browser setup and reusable page methods are shared between tests.

## Maintainability

Locators and page actions are kept inside Page Object classes.

## Readability

BDD feature files describe scenarios in business-readable Gherkin syntax.

## Scalability

Additional pages, API modules and feature files can be added without redesigning the complete framework.

---

# ⚙️ Configuration

Application configuration is maintained separately in:

```text
src/main/resources/config.properties
```

Example:

```properties
browser=chrome
ui.base.url=https://www.saucedemo.com/
api.base.url=https://dummyjson.com
```

---

# 🚀 How to Run the Project

## Prerequisites

Install:

- Java JDK
- Maven
- Eclipse IDE or another Java IDE
- Google Chrome
- Git

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

## Clone the Repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Navigate into the project:

```bash
cd ecommerce-hybrid-automation-framework
```

---

## Execute Tests

```bash
mvn test
```

---

# 📚 Wipro Training Curriculum Alignment

This project is aligned with the major automation topics covered in the training curriculum:

- Selenium WebDriver
- Browser and navigation commands
- WebElement identification
- CSS selectors and XPath
- Synchronization strategies
- TestNG framework
- Automation framework design
- Page Object Model
- Maven lifecycle
- Cucumber
- Gherkin
- Behavior-Driven Development
- API and Web Service concepts
- HTTP methods and status codes
- REST Assured
- JSONPath
- API assertions
- Reporting

---

# 🔮 Future Enhancements

Possible future improvements include:

- Parallel test execution
- Cross-browser testing
- Data-driven testing
- Additional Cucumber scenarios
- API authentication testing
- Additional API coverage
- Screenshot capture on test failure
- Advanced HTML reporting
- Jenkins CI/CD integration
- Multiple environment support
- Mobile automation using Appium

---

# 🎓 Learning Outcomes

This project demonstrates practical knowledge of:

- Selenium WebDriver
- Java automation
- TestNG
- Page Object Model
- Cucumber / Gherkin
- Behavior-Driven Development
- REST API testing
- REST Assured
- JSONPath
- Maven
- Git and GitHub
- Test reporting
- Test synchronization

---

# 📌 Project Status

| Module | Status |
|---|---|
| Selenium UI Automation | ✅ Completed |
| TestNG | ✅ Completed |
| Page Object Model | ✅ Completed |
| Cucumber / BDD | ✅ Completed |
| REST API Testing | ✅ Completed |
| Maven | ✅ Completed |
| Test Reporting | ✅ Completed |
| GitHub Repository | ✅ Completed |
| Documentation | ✅ Completed |

---

# 👨‍💻 Author

**Harshit Tyagi**  
B.Tech Computer Science & Engineering (AI & ML)

---

## Disclaimer

This project is developed for educational and automation-testing purposes. SauceDemo and DummyJSON are used as demo/testing applications and APIs.
