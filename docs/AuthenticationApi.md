# AuthenticationApi

All URIs are relative to *https://tapi.telstra.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authToken**](AuthenticationApi.md#authToken) | **POST** /oauth/token | Generate OAuth2 token


<a name="authToken"></a>
# **authToken**
> OAuthResponse authToken(clientId, clientSecret, grantType, scope)

Generate OAuth2 token

To generate an OAuth2 Authentication token, pass through your &#x60;Client key&#x60; and &#x60;Client secret&#x60; that you received when you registered for the **API Free Trial** Product.  The grant_type should be left as &#x60;client_credentials&#x60; and the scope as &#x60;NSMS&#x60;.  The token will expire in one hour. 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.models.*;
import com.telstra.messaging.AuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");

    AuthenticationApi apiInstance = new AuthenticationApi(defaultClient);
    String clientId = "clientId_example"; // String | 
    String clientSecret = "clientSecret_example"; // String | 
    String grantType = "\"client_credentials\""; // String | 
    String scope = "scope_example"; // String | NSMS
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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **String**|  |
 **clientSecret** | **String**|  |
 **grantType** | **String**|  | [default to &quot;client_credentials&quot;]
 **scope** | **String**| NSMS | [optional]

### Return type

[**OAuthResponse**](OAuthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | unsupported_grant_type |  -  |
**401** | invalid_client |  -  |
**404** | The requested URI does not exist |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

