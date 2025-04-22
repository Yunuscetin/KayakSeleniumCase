# 🧪 Kayak Flight Booking Automation Project

This project is a UI automation test suite developed using Java, Selenium WebDriver and Cucumber aimed at testing the flight search and filtering functionality on https://www.kayak.com.tr It follows the Page Object Model (POM) design pattern and BDD (Behavior Driven Development) principles.

---
Technology	Purpose
Java	Programming language
Selenium WebDriver	Browser automation
Cucumber	BDD framework using Gherkin syntax
Maven	Dependency management and build tool
JUnit	Test runner
WebDriverManager	Automatically manages browser drivers
## 🚀 Objective

---

To automate the following scenario on Kayak:

- Navigate to the website
- Search for a flight from **Doha (DOH)** to **Narita (NRT)**
- Use specific **passenger configurations** (2 adults, 1 student, 1 child)
- Apply **filters** (e.g., Book on KAYAK, one stop, departure after 12:00)
- Verify **flight details** and pricing

---

## 📜 Feature Scenario
Feature: Flight booking on Kayak

  Scenario: Book a flight from Doha to Narita with specific passenger details and filters
    Given User navigates to the Kayak website
    When User selects flight from Doha to Narita
    And User selects 2 adults, 1 student and 1 child
    And User clicks Search
    And User filters results by Book on KAYAK
    And User clicks Quickest
    And User loads 50 or more flight results by clicking Show more results
    Then User finds the cheapest flight with one stop and departure after twelve in both directions
    And User verifies the dates, passenger count and stop count
    And User verifies the list price matches with the View Deal page

How to Run the Tests 

>>>> git clone https://github.com/your-username/kayak-automation.git
>>>> cd kayak-automation
>>>> mvn test


Notes:
Tests are designed for Chrome using WebDriverManager.
Dynamic web elements are handled with explicit waits and JavaScript click events.
Locators are separated and maintained in the locators package for maintainability.
Page actions are abstracted using the Page Object Model.


Yunus Çetin 
https://www.linkedin.com/in/yunuscetin/
