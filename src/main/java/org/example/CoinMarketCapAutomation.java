package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CoinMarketCapAutomation {

    public static WebDriver driver;

    public CoinMarketCapAutomation(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver navigateToCoinMarketCap() {
        // Set the Chrome driver executable path
        
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Create a new Chrome driver instance
        driver = new ChromeDriver(options);

        // Navigate to the CoinMarketCap website
        driver.get("https://coinmarketcap.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.cssSelector("svg.sc-aef7b723-0.fKbUaI.close-button")).click();
        return driver;

    }

    public void showRows(int rowCount) throws InterruptedException {
        // Click on the "Show Rows" dropdown menu
        WebElement showRowsDropdown = driver.findElement(By.cssSelector("div[class='sc-aef7b723-0 jPLKhd table-control-page-sizer'] div[class='sc-aef7b723-0 sc-fc8e4bda-0 dBikMg']"));
        showRowsDropdown.click();
       Thread.sleep(2000);
        // Select the desired number of rows to display
        String rowOptionLocator = String.format("//button[@class='sc-44910c32-0 kppgZc' and text()='%d']", rowCount);
        WebElement rowOption = driver.findElement(By.xpath(rowOptionLocator));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",rowOption);

    }

    public List<WebElement> captureAllInformation() {
        // Find all the cryptocurrency rows in the table
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        return rows;
    }

    public void filterByAlgorithm(String algorithm) throws InterruptedException {
        // Click on the "Filter" button
        WebElement filterButton = driver.findElement(By.cssSelector("div[class='sc-c5240b15-4 cFzkbZ hide_on_mobile_wrapper'] button[class='sc-44910c32-0 joPzXo sc-c97dd8af-0 kHBmSh table-control-filter']"));
        filterButton.click();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        WebElement algorithmbutton = driver.findElement(By.xpath("//button[normalize-space()='Algorithm']"));
        algorithmbutton.click();
        // Enter the algorithm in the search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox.sendKeys(algorithm);

        // Select the algorithm from the dropdown
        String algorithmLocator = String.format("//li[@class='optionGroupItem' and text()='%s']", algorithm);
        WebElement algorithmOption = driver.findElement(By.xpath(algorithmLocator));
        algorithmOption.click();
    }

    public void applyfilter(){
        // Apply the filter
        WebElement applyButton = driver.findElement(By.xpath("//button[normalize-space()='+ Add Filter']"));
        applyButton.click();
    }

    public void toggleMineable() {
        // Click on the "Mineable" filter toggle
        WebElement mineableToggle = driver.findElement(By.xpath("//label[@id='mineable']"));
        mineableToggle.click();
    }

    public void selectAllCryptocurrencies() throws InterruptedException {
        // Click on the "All Cryptocurrencies" filter
        WebElement allCryptocurrenciesFilter = driver.findElement(By.xpath("//button[normalize-space()='All Cryptocurrencies']"));
        Actions a=new Actions(driver);
        a.clickAndHold(allCryptocurrenciesFilter).release().build().perform();


    }

    public void selectCoins() throws InterruptedException {
        // Click on the "Coins" filter

        WebElement coinsFilter = driver.findElement(By.xpath("//button[normalize-space()='Coins']"));
        WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(10));
        waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[normalize-space()='Coins']")));

        coinsFilter.click();

    }

    public void selectPriceRange(int minValue, int maxValue) throws InterruptedException {
        // Click on the "Price" filter dropdown
        WebElement priceFilterDropdown = driver.findElement(By.xpath("//button[normalize-space()='Price']"));
        priceFilterDropdown.click();

        // Enter the minimum price value
        WebElement minPriceInput = driver.findElement(By.xpath("//input[@placeholder='$0']"));
        minPriceInput.sendKeys(String.valueOf(minValue));

        // Enter the maximum price value
        WebElement maxPriceInput = driver.findElement(By.xpath("//input[@placeholder='$99,999']"));
        maxPriceInput.sendKeys(String.valueOf(maxValue));
        Thread.sleep(1000);
        // Apply the filter
        WebElement html = driver.findElement(By.tagName("html"));
        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
        WebElement applyButton = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M18 6L6 18')]"));
        Actions a=new Actions(driver);
        a.click(applyButton).build().perform();

    }

    public void comparePageContent(List<WebElement> originalRows) {
        // Find all the cryptocurrency rows in the filtered table
        List<WebElement> filteredRows = driver.findElements(By.xpath("//table/tbody/tr"));
        // Verify that the filtered table has fewer or equal rows than the original table
        assert (filteredRows.size() <= originalRows.size());
        // Close the browser
        driver.quit();
    }
}


