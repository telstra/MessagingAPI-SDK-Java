package com.telstra.messaging;

import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.models.*;
import com.telstra.messaging.AuthenticationApi;

public class BackwardCompatibilityIT {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");

    AuthenticationApi apiInstance = new AuthenticationApi(defaultClient);
    String clientId = System.getenv("CLIENT_ID"); // String | 
    String clientSecret = System.getenv("CLIENT_SECRET"); // String | 
    String grantType = "\"client_credentials\""; // String | 
    String scope = "NSMS"; // String | NSMS
    try {
      OAuthResponse result = apiInstance.authToken(clientId, clientSecret, grantType, scope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#authToken");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}