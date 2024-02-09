package firstseleniumpackage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AppApiTests {

    private HttpClient httpClient;
    private final String authEndpoint = "https://account.myapp.com/verifyAccount";
    private final String profileEndpoint = "https://profile.myapp.com/myprofile?encoding=json";
    private final String validAuthToken = "pk1456--__pRjNWufmmdngldnZktkaAcwVhybaqsIkiE3iL";

    @BeforeClass
    public void setUp() {
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void testValidLogin() throws IOException {
        HttpPost request = new HttpPost(authEndpoint);
        StringEntity params = new StringEntity("{\"user\":\"username\",\"pass\":\"password\"}");
        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        Assert.assertEquals(statusCode, 200);
        Assert.assertTrue(responseBody.contains("Authtoken"));
    }

    @Test
    public void testInvalidLoginWithEmptyFields() throws IOException {
        HttpPost request = new HttpPost(authEndpoint);
        StringEntity params = new StringEntity("{\"user\":\"\",\"pass\":\"\"}");
        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();

        Assert.assertNotEquals(statusCode, 200);
    }

    @Test
    public void testValidProfileUpdate() throws IOException {
        HttpGet authRequest = new HttpGet(profileEndpoint);
        authRequest.addHeader("Authorization", "Bearer " + validAuthToken);

        HttpResponse authResponse = httpClient.execute(authRequest);
        int authStatusCode = authResponse.getStatusLine().getStatusCode();

        Assert.assertEquals(authStatusCode, 200);

        HttpPost request = new HttpPost(profileEndpoint);
        request.addHeader("Authorization", "Bearer " + validAuthToken);
        StringEntity params = new StringEntity("{\"name\":\"changedName\",\"surname\":\"mySurname\"," +
                "\"country\":\"MyCountry\",\"dateOfBirht\":\"date\"}");
        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void testInvalidProfileUpdate() throws IOException {
        HttpGet authRequest = new HttpGet(profileEndpoint);
        authRequest.addHeader("Authorization", "Bearer " + validAuthToken);

        HttpResponse authResponse = httpClient.execute(authRequest);
        int authStatusCode = authResponse.getStatusLine().getStatusCode();

        Assert.assertEquals(authStatusCode, 200);

        HttpPost request = new HttpPost(profileEndpoint);
        request.addHeader("Authorization", "Bearer " + validAuthToken);
        StringEntity params = new StringEntity("{\"name\":\"invalidName@\",\"surname\":\"mySurname\"," +
                "\"country\":\"MyCountry\",\"dateOfBirht\":\"date\"}");
        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        Assert.assertNotEquals(statusCode, 200);
        Assert.assertTrue(responseBody.contains("Please remove any special characters."));
    }
}
