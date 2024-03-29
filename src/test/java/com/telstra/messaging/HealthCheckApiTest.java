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
import org.junit.Ignore;
import org.junit.Test;
import static com.telstra.messaging.AuthenticationApi.getAuthToken;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * API tests for HealthCheckApi
 */
public class HealthCheckApiTest {
    private ApiClient defaultClient;

    //@Before
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
     * health check
     * Use this endpoint to check the operational status of the messaging service. A 200 OK response means the service is up. If you receive a 504 response, the service is temporarily down. Check the [API Live Status page]. to see if there&#x27;s an active incident.
     *
     */
    @Ignore
    public void healthCheckTest() {

        try{
            ApiClient apiClient = getAuthToken(defaultClient);
            HealthCheckApi healthCheckApi = new HealthCheckApi(apiClient);

            HealthCheck200Response response = healthCheckApi.healthCheck();
            System.out.println(response);
            assertNotNull(response);
            assertEquals("up", response.getStatus());

        } catch (ApiException e) {
            System.err.println("Exception when calling HealthCheckApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
