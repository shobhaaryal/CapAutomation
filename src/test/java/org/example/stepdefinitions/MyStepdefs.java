package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CoinMarketCapAutomation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.example.CoinMarketCapAutomation;
import java.util.List;

public class MyStepdefs {
    WebDriver driver;
    List<WebElement> captureAllInformation;
    @Given("I am on the CoinMarketCap website")
    public void iAmOnTheCoinMarketCapWebsite() {
        driver =  CoinMarketCapAutomation.navigateToCoinMarketCap();
    }

    @When("I show rows by {int}")
    public void iShowRowsBy(int arg0) throws InterruptedException {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        coinMarketCapAutomation.showRows(arg0);
    }

    @And("I capture all the cryptocurrency information")
    public void iCaptureAllTheCryptocurrencyInformation() {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        captureAllInformation=coinMarketCapAutomation.captureAllInformation();
    }

    @And("I filter by Algorithm - {string}")
    public void iFilterByAlgorithm(String arg0) throws InterruptedException {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        coinMarketCapAutomation.filterByAlgorithm(arg0);
    }

    @And("I click on +Add Filter")
    public void iClickOn() {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        coinMarketCapAutomation.applyfilter();
    }

    @And("I toggle Mineable")
    public void iToggle() {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        coinMarketCapAutomation.toggleMineable();
    }

    @And("I select All Cryptocurrencies")
    public void iSelect() throws InterruptedException {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        coinMarketCapAutomation.selectAllCryptocurrencies();

    }

    @And("I select Coins")
    public void iSelectcoins() throws InterruptedException {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        coinMarketCapAutomation.selectCoins();
    }
    @And("I select price and set minimum value to {int} and maximum to {int}")
    public void iSelectPriceAndSetMinimumValueToAndMaximumTo(int arg0, int arg1) throws InterruptedException {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        coinMarketCapAutomation.selectPriceRange(arg0, arg1);
    }

    @Then("the page content should be compared to the content")
    public void thePageContentShouldBeComparedToTheContent() {
        CoinMarketCapAutomation coinMarketCapAutomation = new CoinMarketCapAutomation(driver);
        coinMarketCapAutomation.comparePageContent(captureAllInformation);
    }

}

