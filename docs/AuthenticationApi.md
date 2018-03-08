# AuthenticationApi

All URIs are relative to *https://tapi.telstra.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authToken**](AuthenticationApi.md#authToken) | **POST** /oauth/token | Generate authentication token


<a name="authToken"></a>
# **authToken**
> OAuthResponse authToken(clientId, clientSecret, grantType)

Generate authentication token

Generate authentication token

### Example
```java
// Import classes:
//import com.telstra.ApiException;
//import com.telstra.messaging.AuthenticationApi;


AuthenticationApi apiInstance = new AuthenticationApi();
String clientId = "clientId_example"; // String | 
String clientSecret = "clientSecret_example"; // String | 
String grantType = "client_credentials"; // String | 
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
 **clientId** | **String**|  |
 **clientSecret** | **String**|  |
 **grantType** | **String**|  | [default to client_credentials]

### Return type

[**OAuthResponse**](OAuthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

