Feature: Filter Cryptocurrencies by Algorithm and Price Range

  Scenario: Filter cryptocurrencies by PoW algorithm and price range
    Given I am on the CoinMarketCap website
    When I show rows by 20
    And I capture all the cryptocurrency information
    And I filter by Algorithm - "PoW"
    And I click on +Add Filter
    And I toggle Mineable
    And I select All Cryptocurrencies
    And I select Coins
    And I select price and set minimum value to 100 and maximum to 10000
    Then the page content should be compared to the content

