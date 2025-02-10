# Behavior-Driven Development for Web Application Testing: A Case Study on Gmail Automation

## 📌 Project Overview

This project presents an **automated testing framework** for Gmail, utilizing **Selenium WebDriver** and **Cucumber** under the **Behavior-Driven Development (BDD)** approach. The framework automates essential functionalities such as:

- ✅ **Login and Logout**
- 🚫 **Handling invalid login attempts**
- 📩 **Email content verification**
- 🔐 **Secure credential management** using environment variables

By integrating **data-driven testing**, multiple credential sets are tested without exposing sensitive data. The framework improves **testing efficiency, accuracy, and reliability** while ensuring Gmail’s authentication and email retrieval processes remain stable and secure.

## 📋 Key Features

### 🔹 **Automated Testing Capabilities**

- 📌 **Login Workflow**: Validates successful and unsuccessful logins
- 🛑 **Invalid Credentials Handling**: Ensures Gmail displays appropriate error messages
- 📧 **Email Content Verification**: Retrieves and verifies inbox emails
- 🚀 **Data-Driven Testing**: Enables multiple test scenarios using external data sources

### 🔹 **Behavior-Driven Development (BDD) Implementation**

- Uses **Cucumber & Gherkin syntax** for human-readable test scenarios
- Improves **collaboration** between developers, testers, and non-technical stakeholders
- Test scenarios follow **Given-When-Then** structure for clarity

### 🔹 **Secure & Scalable Architecture**

- 🛡 **Environment variables** used for storing sensitive credentials
- 🔍 **Explicit waits & dynamic element handling** for stable execution
- 🔄 **Modular test components** for reusable and maintainable automation
- 🖥 **Cross-browser compatibility** with Selenium WebDriver

## 🏗 Project Structure

```
📂 Gmail-Automation-BDD
├── 📂 features                 # Gherkin feature files
│   ├── login.feature           # Login test scenarios
│   ├── logout.feature          # Logout test scenarios
│   ├── email_verification.feature  # Email verification scenarios
│
├── 📂 stepDefinitions          # Step definitions for Cucumber tests
│   ├── LoginSteps.java         # Implementation of login steps
│   ├── LogoutSteps.java        # Implementation of logout steps
│   ├── EmailVerificationSteps.java  # Implementation of email verification steps
│
├── 📂 utils                    # Utility classes
│   ├── DriverFactory.java      # WebDriver setup
│   ├── DotenvUtils.java        # Secure credential management
│   ├── GmailUtils.java         # Common Gmail actions
│
├── 📜 pom.xml                   # Maven dependencies
└── 📜 README.md                 # Project documentation
```

## 🔧 Installation & Setup

### 1️⃣ Prerequisites

Ensure you have the following installed:

- **Java (JDK 11 or higher)**
- **Apache Maven**
- **Google Chrome / Firefox**
- **ChromeDriver / GeckoDriver**
- **IntelliJ IDEA / VS Code**

### 2️⃣ Clone Repository

```bash
git clone https://github.com/yourusername/Gmail-Automation-BDD.git
cd Gmail-Automation-BDD
```

### 3️⃣ Install Dependencies

```bash
mvn clean install
```

### 4️⃣ Set Up Environment Variables

Before running the tests, configure **.env** file or set the environment variables:

```bash
VALID_EMAIL=your-email@gmail.com
VALID_PASSWORD=your-secure-password
INBOX_EMAIL_CONTENT="The email content you want to test"
CHROME_DRIVER_LOCATION="Chrome driver location on your local machine"
```

### 5️⃣ Run Tests

Run all Cucumber test scenarios using Maven:

```bash
mvn test
```

Run specific test features:

```bash
mvn test -Dcucumber.options="src/test/resources/features/login.feature"
```

## 📌 Example Test Scenario (Gherkin Syntax)

```gherkin
Feature: Gmail Login
  Scenario: Login with valid credentials
    Given I am on the Gmail login page
    When I enter a valid email
    And I enter a valid password
    And I click the "Next" button
    Then I should see my inbox
```


## 📜 License

This project is licensed under the **MIT License** - feel free to use it!
