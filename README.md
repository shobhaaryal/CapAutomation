# CapAutomation

## Filtering UI and extracting data for comparison using selenium and cucumber

This project aims to automate the filtering of data on CoinMarketCap and compare the results before and after the filtering. We will be using Selenium and Cucumber to achieve this.

## Requirements
Java 8 or higher

Maven

Selenium WebDriver

Cucumber

ChromeDriver

Setup

## Clone the repository and navigate to the project directory.

Run mvn clean install

 to install all the dependencies.

Download the ChromeDriver executable and add it to your system PATH.

Open the src/test/resources/config.properties file and set the webdriver.chrome.driver property to the path of your ChromeDriver executable.

## Running the tests

To run the tests, execute the following command in the project directory:

mvn test

This will launch the Chrome browser and run the tests. The test results can be viewed in the console or in the target/cucumber-html-reports directory.

# Test Steps

The test steps for this project are as follows:

Navigate to https://coinmarketcap.com.
Show rows by 20.
Capture all page contents.
Filter by Algorithm - "PoW".
Followed by "+ Add Filter".
Toggle "Mineable".
Then select "All Cryptocurrencies".
Select "Coins".
Then select price and set minimum value to 100 and maximum to 10,000.
Compare page content to the content in step 3.

## Conclusion

With this project, we were able to automate the filtering of data on CoinMarketCap and compare the results before and after the filtering. This approach can be extended to other websites and applications that require data filtering and extraction.
