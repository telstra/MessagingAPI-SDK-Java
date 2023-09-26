# HealthCheckApi

All URIs are relative to *https://products.api.telstra.com/messaging/v3*

Method | HTTP request | Description
------------- | ------------- | -------------
[**healthCheck**](HealthCheckApi.md#healthCheck) | **GET** /health-check | health check

<a name="healthCheck"></a>
# **healthCheck**
> InlineResponse2006 healthCheck(authorization, telstraApiVersion)

health check

Use this endpoint to check the operational status of the messaging service. A 200 OK response means the service is up. If you receive a 504 response, the service is temporarily down. Check the [API Live Status page] (https://dev.telstra.com/api/status) to see if there&#x27;s an active incident.

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.HealthCheckApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

HealthCheckApi apiInstance = new HealthCheckApi();
String authorization = "authorization_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    InlineResponse2006 result = apiInstance.healthCheck(authorization, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HealthCheckApi#healthCheck");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**|  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**InlineResponse2006**](HealthCheck200Response.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

