# AuthenticationApi

All URIs are relative to *https://products.api.telstra.com/messaging/v3*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authToken**](AuthenticationApi.md#authToken) | **POST** /oauth/token | Generate an access token

<a name="authToken"></a>
# **authToken**
> OAuth authToken(clientId, clientSecret, grantType, scope)

Generate an access token

An OAuth 2.0 access token is required to access the API features. To create a token, use the unique &#x60;client_id&#x60; and &#x60;client_secret&#x60; you received when you registered for the API. You can find these credentials [here](https://dev.telstra.com). Note that your access token will expire in 1 hour. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.AuthenticationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

AuthenticationApi apiInstance = new AuthenticationApi();
String clientId = "clientId_example"; // String | 
String clientSecret = "clientSecret_example"; // String | 
String grantType = "grantType_example"; // String | 
String scope = "scope_example"; // String | 
try {
    OAuth result = apiInstance.authToken(clientId, clientSecret, grantType, scope);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationApi#authToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **String**|  |
 **clientSecret** | **String**|  |
 **grantType** | **String**|  |
 **scope** | **String**|  |

### Return type

[**OAuth**](OAuth.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

