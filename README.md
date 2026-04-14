# 🧪 Selenium Cucumber Automation Framework

This project is a **test automation framework** built using **Selenium WebDriver, Cucumber (BDD), and TestNG**.  
It follows the **Page Object Model (POM)** design pattern and demonstrates real-world UI test scenarios.

----------

## 🚀 Features

-   ✅ Behavior-Driven Development using Cucumber (Gherkin)
    
-   ✅ Page Object Model (POM) for maintainability
    
-   ✅ TestNG runner integration
    
-   ✅ Explicit waits and stable interaction handling
    
-   ✅ Custom drag-and-drop solution (works reliably in Chrome)
    
-   ✅ Clean separation of concerns (Pages, Steps, Features)
    

----------

## 📁 Project Structure

```
src
 ├── test
 │   ├── java
 │   │   ├── Pages
 │   │   │   ├── LoginPage.java
 │   │   │   ├── RadioButtonPage.java
 │   │   │   └── DragNDropPage.java
 │   │   │
 │   │   ├── Steps
 │   │   │   └── StepDefinitions.java
 │   │   │
 │   │   └── Runner
 │   │       └── TestRunner.java
 │   │
 │   └── resources
 │       ├── login.feature
 │       ├── radio-buttons.feature
 │       └── drag-n-drop.feature

```

----------

## 🧩 Test Scenarios

### 🔐 Login Test

-   Valid login
    
-   Invalid login
    
-   Message validation
    

### 🔘 Radio Button Test

-   Selecting different radio buttons
    
-   Validating selected states
    
-   Handling disabled elements (e.g. Green button)
    

### 🔄 Drag and Drop Test

-   Drag element A → B
    
-   Drag element B → A
    
-   Custom implementation to handle Chrome limitations
    

----------

## 🛠️ Technologies Used

-   Java
    
-   Selenium WebDriver
    
-   Cucumber (Gherkin)
    
-   TestNG
    
-   Maven
    

----------

## ▶️ How to Run Tests

### 1. Clone the repository

```
git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git

```

### 2. Navigate to project

```
cd YOUR_REPO

```

### 3. Run tests

```
mvn test

```

----------

## ⚠️ Notes

-   Drag & Drop uses a custom implementation due to known Selenium limitations in Chrome.
    
-   Explicit waits are used for better stability.
    
-   Some elements require scrolling before interaction.
    

----------

## 📌 Future Improvements

-   CI/CD integration with GitHub Actions
    
-   Allure reporting
    
-   Parallel test execution
    
-   Cross-browser testing
    

----------

## 👨‍💻 Author

Your Name

----------

## ⭐ Why this project matters

This project demonstrates:

-   Real automation framework structure
    
-   Problem-solving (e.g. drag-and-drop issues)
    
-   Clean and scalable test design
    

It is suitable as a **portfolio project for QA Automation roles**.~~strikethrough text~~
