# AuthenticationApi

All URIs are relative to *https://tapi.telstra.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authToken**](AuthenticationApi.md#authToken) | **POST** /oauth/token | Generate OAuth2 token


<a name="authToken"></a>
# **authToken**
> OAuthResponse authToken(clientId, clientSecret, grantType)

Generate OAuth2 token

To generate an OAuth2 Authentication token, pass through your &#x60;Client key&#x60; and &#x60;Client secret&#x60; that you received when you registered for the **API Free Trial** Product. The grant_type should be left as &#x60;client_credentials&#x60; and the scope as &#x60;NSMS&#x60;. The token will expire in one hour. 

### Example
```java
// Import classes:
//import com.telstra.ApiException;
//import com.telstra.messaging.AuthenticationApi;


AuthenticationApi apiInstance = new AuthenticationApi();
String clientId = "null"; // String | 
String clientSecret = "null"; // String | 
String grantType = "\"client_credentials\""; // String | 
try {
    OAuthResponse result = apiInstance.authToken(clientId, clientSecret, grantType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationApi#authToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **String**|  | [default to null]
 **clientSecret** | **String**|  | [default to null]
 **grantType** | **String**|  | [default to &quot;client_credentials&quot;]

### Return type

[**OAuthResponse**](OAuthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

