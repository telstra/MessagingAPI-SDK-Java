/*
 * Messaging API v3.1.0
 * Send and receive SMS & MMS programmatically, leveraging Australia's leading mobile network. With Telstra's Messaging API, we take out the complexity to allow seamless messaging integration into your app, with just a few lines of code. Our REST API is enterprise grade, allowing you to communicate with engaging SMS & MMS messaging in your web and mobile apps in near real-time on a global scale. 
 *
 * OpenAPI spec version: 3.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.telstra.messaging;
import com.telstra.*;
import org.junit.Before;
import org.junit.Test;
import static com.telstra.messaging.AuthenticationApi.getAuthToken;
import static org.junit.Assert.*;


/**
 * API tests for FreeTrialNumbersApi
 */

public class FreeTrialNumbersApiTest {
    private ApiClient defaultClient;

    @Before
    public void setUp() {

        defaultClient = new ApiClient();

        String clientId = "YOUR CLIENT ID";
        String clientSecret = "YOUR CLIENT SECRET";
        String grantType = "client_credentials";
        String scope = "free-trial-numbers:read free-trial-numbers:write messages:read messages:write virtual-numbers:read virtual-numbers:write reports:read reports:write";

        defaultClient.setAccessSecret(clientId, clientSecret, grantType, scope);
        defaultClient.setBasePath("https://products.api.telstra.com/v2");
        System.out.println("Setting up before each test...");
    }

    /**
     * create free trial number list
     * Your Free Trial Numbers are the 10 recipient mobile numbers that you can message during the Free Trial. The first five numbers you send an SMS/MMS to will automatically be added to your Free Trial Numbers list. After that, you can use this endpoint to register another five. Alternatively, you can use this endpoint to register all 10 numbers.    Use this endpoint to register a Free Trial Number to your account. To test out all the features that the trial has to offer, we recommend registering your own mobile number to your Free Trial Numbers list.   Note that you can only message mobile numbers that have been added to your Free Trial list and once registered, a Free Trial Number cannot be removed or replaced.
     */
    @Test
    public void createTrialNumbersTest() {

        try{
            ApiClient apiClient = getAuthToken(defaultClient);

            CreateTrialNumbersRequest createTrialNumbersRequest = new CreateTrialNumbersRequest();
            createTrialNumbersRequest.addFreeTrialNumbersItem("0400000001");
            createTrialNumbersRequest.addFreeTrialNumbersItem("0400000002");

            FreeTrialNumbersApi freeTrialNumbersApi = new FreeTrialNumbersApi(apiClient);
            FreeTrialNumbers response = freeTrialNumbersApi.createTrialNumbers(createTrialNumbersRequest);
            System.out.println(response);
            assertNotNull(response.getFreeTrialNumbers());

        } catch (ApiException e) {
            System.err.println("Exception when calling FreeTrialNumbersApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }

    }

    /**
     * get all free trial numbers
     * Use this endpoint to fetch the Free Trial Number(s) currently assigned to your account. These are the mobile numbers that you can message during the Free Trial.  If you&#x27;re using a paid plan, there&#x27;s no limit to the number of recipients that you can message, so you don&#x27;t need to register Free Trial Numbers. 
     *
     */
    @Test
    public void getTrialNumbersTest() {

        try{
            ApiClient apiClient = getAuthToken(defaultClient);
            FreeTrialNumbersApi freeTrialNumbersApi = new FreeTrialNumbersApi(apiClient);
            FreeTrialNumbers response = freeTrialNumbersApi.getTrialNumbers();
            System.out.println(response);
            assertNotNull(response.getFreeTrialNumbers());

        } catch (ApiException e) {
            System.err.println("Exception when calling FreeTrialNumbersApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

}
