package tests.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import configreader.FrameworkProperties;
import dto.SearchResultDto;
import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import tests.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchITunes extends BaseTest {

    private String media = "audiobook";

    @Override
    public String getBaseUrl() {
        FrameworkProperties frameworkProperties = ConfigFactory.create(FrameworkProperties.class);
        return frameworkProperties.getUrlITunes();
    }

    @Test
    public void getResultMedia () throws JsonProcessingException {
        JsonPath jsonPath = RestAssured.given()
                .header ("Content-Type", "application/json")
                .baseUri(getBaseUrl())
                .params(Map.of("term", "Nirvana",
                        "country","US",
                        "media", media))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

    SearchResultDto searchResultDto = new ObjectMapper().readValue(jsonPath.prettyPrint(), SearchResultDto.class);
    Assert.assertTrue(searchResultDto.getResults().stream().allMatch(result->result.getWrapperType().equals(media)));
    }

    @Test
    public void getResultWithoutFields () throws JsonProcessingException {
        JsonPath jsonPath = RestAssured.given()
                .header ("Content-Type", "application/json")
                .baseUri(getBaseUrl())
                .params(Map.of("term", "",
                        "country",""))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        SearchResultDto searchResultDto = new ObjectMapper().readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertEquals(searchResultDto.getResultCount(),0);
    }

   @Test
   public void getResultCountry () throws JsonProcessingException {
       JsonPath jsonPath = RestAssured.given()
               .header ("Content-Type", "application/json")
               .baseUri(getBaseUrl())
               .params(Map.of("term", "Океан",
                       "country","UA"))
               .get("/search")
               .then()
               .statusCode(200)
               .extract()
               .body()
               .jsonPath();

       SearchResultDto searchResultDto = new ObjectMapper().readValue(jsonPath.prettyPrint(), SearchResultDto.class);
       Assert.assertTrue(searchResultDto.getResults().stream().allMatch(result->result.getCountry().equals("UKR")));
   }
}
