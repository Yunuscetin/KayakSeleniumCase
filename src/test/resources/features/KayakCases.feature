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