package apiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
public class CoinMarketCapApiExample {

    private static final String API_KEY = "6dbd7cda-08cd-4ef0-a5a7-4c6420c07919";
    private static final String API_BASE_URL = "https://pro-api.coinmarketcap.com";

    @Test
    public void testcase1(){
        String quetzalAmount = "10000000";
        String fromSymbol = "GTQ";
        String toSymbol = "GBP";

        Response response = RestAssured
                .given()
                .header("X-CMC_PRO_API_KEY", API_KEY)
                .queryParam("amount", quetzalAmount)
                .queryParam("symbol", fromSymbol)
                .queryParam("convert", toSymbol)
                .when()
                .get(API_BASE_URL + "/v1/tools/price-conversion");

        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);
    }
    @Test
    public void testcase2(){

                String apiKey = "6dbd7cda-08cd-4ef0-a5a7-4c6420c07919";
                String endpointUrl = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
                String symbol = "DOGE";
                String convert = "GBP";

                // Set API key as a header
                RestAssured.given()
                        .header("X-CMC_PRO_API_KEY", apiKey)
                        .param("symbol", symbol)
                        .param("convert", convert)
                        .when()
                        .get(endpointUrl)
                        .then()
                        .assertThat()
                        .statusCode(200);

                // Extract the price information from the response
                Response response = RestAssured.given()
                        .header("X-CMC_PRO_API_KEY", apiKey)
                        .param("symbol", symbol)
                        .param("convert", convert)
                        .when()
                        .get(endpointUrl)
                        .then()
                        .extract()
                        .response();

                double priceInGBP = response.jsonPath().get("data.DOGE.quote.GBP.price");

                // Convert the price to Dogecoin
                double priceInDOGE = priceInGBP / getDOGEGBPPrice();

                System.out.println("Price of 1 DOGE in GBP: " + getDOGEGBPPrice());
                System.out.println("Price of 1 GBP in DOGE: " + priceInDOGE);
            }

            private static double getDOGEGBPPrice() {
                // This method would retrieve the current DOGE/GBP price from a separate API
                // implementation is outside the scope of this example
                return 0.008; // Example value
            }
        }



