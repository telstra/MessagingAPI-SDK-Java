/*
 * Telstra Messaging API
 * The API specification for Telstra Messaging API
 *
 * The version of the OpenAPI document: 2.2.9
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.telstra.messaging;

import com.telstra.ApiException;
import com.telstra.models.OAuthResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AuthenticationApi
 */
@Ignore
public class AuthenticationApiTest {

    private final AuthenticationApi api = new AuthenticationApi();

    
    /**
     * Generate OAuth2 token
     *
     * To generate an OAuth2 Authentication token, pass through your &#x60;Client key&#x60; and &#x60;Client secret&#x60; that you received when you registered for the **API Free Trial** Product.  The grant_type should be left as &#x60;client_credentials&#x60; and the scope as &#x60;NSMS&#x60;.  The token will expire in one hour. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void authTokenTest() throws ApiException {
        String clientId = null;
        String clientSecret = null;
        String grantType = null;
        String scope = null;
        OAuthResponse response = api.authToken(clientId, clientSecret, grantType, scope);

        // TODO: test validations
    }
    
}
