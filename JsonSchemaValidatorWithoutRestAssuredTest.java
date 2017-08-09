package country;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import io.restassured.response.Response;

public class JsonSchemaValidatorWithoutRestAssuredTest {
	
	@Test
    public void testCountryApiResponseStatus() throws Exception {
        given().
        expect().
        statusCode(200).
        when().
        get("https://restcountries.eu/rest/v2/alpha/IND");
    }
	
	@Test
    public void testCountryProperties() throws Exception {
		Response response = given().when().get("https://restcountries.eu/rest/v2/alpha/IND");
        response.then().body("callingCodes[0]",  equalTo("91"));
    }
	
	@Test
    public void testNumberOfCountries() throws Exception {
		Response response = given().when().get("https://restcountries.eu/rest/v2/all");
		response.then().body("size()",  equalTo(250));
        // assertThat().body(matchesJsonSchemaInClasspath("country.json"));
    }

}
