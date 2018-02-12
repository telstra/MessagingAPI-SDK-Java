# AuthApi

All URIs are relative to *https://tapi.telstra.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**oauthTokenPost**](AuthApi.md#oauthTokenPost) | **POST** /oauth/token | AuthGeneratetokenPost


<a name="oauthTokenPost"></a>
# **oauthTokenPost**
> AuthgeneratetokenpostResponse oauthTokenPost(oAuthClientId, oAuthClientSecret)

AuthGeneratetokenPost

generate auth token

### Example
```java
// Import classes:
//import com.telstra.ApiException;
//import com.telstra.messaging.AuthApi;


AuthApi apiInstance = new AuthApi();
String oAuthClientId = "oAuthClientId_example"; // String | 
String oAuthClientSecret = "oAuthClientSecret_example"; // String | 
try {
    AuthgeneratetokenpostResponse result = apiInstance.oauthTokenPost(oAuthClientId, oAuthClientSecret);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthApi#oauthTokenPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **oAuthClientId** | **String**|  |
 **oAuthClientSecret** | **String**|  |

### Return type

[**AuthgeneratetokenpostResponse**](AuthgeneratetokenpostResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

