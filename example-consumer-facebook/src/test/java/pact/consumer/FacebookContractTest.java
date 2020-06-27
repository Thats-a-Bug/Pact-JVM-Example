package pact.consumer;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javax.ws.rs.HttpMethod;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.hamcrest.core.IsInstanceOf.any;

public class FacebookContractTest
{
    private final String informationURI = "/information";

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule(
        "userinfo", "localhost", 9000,
        PactSpecVersion.V3, this);

    @Pact(consumer = "facebook")
    public RequestResponsePact facebookInfoPact(final PactDslWithProvider builder)
    {
        return builder
            .uponReceiving("Get facebook info")
            .path(informationURI)
            .method(HttpMethod.GET)
            .query("name=bob")
            .willRespondWith()
            .status(HttpStatus.OK.value())
            .body(getFacebookInfoResponse())
            .toPact();
    }

    @NotNull
    private DslPart getFacebookInfoResponse()
    {
        return LambdaDsl.newJsonBody(
            (o) -> {
                o.stringType("name");
                o.stringType("age");
                o.stringType("relatives");
            }
        ).build();
    }

    @Test
    @PactVerification(fragment = "facebookInfoPact" )
    public void checkFacebookData()
    {
        Response response = RestAssured
            .given()
            .port(mockProvider.getConfig().getPort())
            .contentType(ContentType.JSON)
            .queryParam("name", "bob")
            .get(informationURI);

        response.then().assertThat()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body("name", any(String.class))
            .body("age", any(String.class))
            .body("relatives", any(String.class));

    }
}
