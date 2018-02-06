# ProvisioningApi

All URIs are relative to *https://tapi.telstra.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSubscription**](ProvisioningApi.md#createSubscription) | **POST** /messages/provisioning/subscriptions | Create Subscription
[**deleteSubscription**](ProvisioningApi.md#deleteSubscription) | **DELETE** /messages/provisioning/subscriptions | Delete Subscription
[**getSubscription**](ProvisioningApi.md#getSubscription) | **GET** /messages/provisioning/subscriptions | Get Subscription


<a name="createSubscription"></a>
# **createSubscription**
> ProvisionNumberResponse createSubscription(authorization, body)

Create Subscription

Provision a mobile number

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.ProvisioningApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: auth
OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
auth.setAccessToken("YOUR ACCESS TOKEN");

ProvisioningApi apiInstance = new ProvisioningApi();
String authorization = "authorization_example"; // String | An OAUTH bearer token that is entitled to use the 'SUBSCRIPTION' scope.
ProvisionNumberRequest body = new ProvisionNumberRequest(); // ProvisionNumberRequest | A JSON payload containing the required attributes
try {
    ProvisionNumberResponse result = apiInstance.createSubscription(authorization, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvisioningApi#createSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| An OAUTH bearer token that is entitled to use the &#39;SUBSCRIPTION&#39; scope. |
 **body** | [**ProvisionNumberRequest**](ProvisionNumberRequest.md)| A JSON payload containing the required attributes |

### Return type

[**ProvisionNumberResponse**](ProvisionNumberResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteSubscription"></a>
# **deleteSubscription**
> deleteSubscription(authorization)

Delete Subscription

Delete a mobile number subscription from an account

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.ProvisioningApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: auth
OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
auth.setAccessToken("YOUR ACCESS TOKEN");

ProvisioningApi apiInstance = new ProvisioningApi();
String authorization = "authorization_example"; // String | An OAUTH bearer token that is entitled to use the 'SUBSCRIPTION' scope.
try {
    apiInstance.deleteSubscription(authorization);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvisioningApi#deleteSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| An OAUTH bearer token that is entitled to use the &#39;SUBSCRIPTION&#39; scope. |

### Return type

null (empty response body)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSubscription"></a>
# **getSubscription**
> List&lt;ProvisionNumberResponse&gt; getSubscription(authorization)

Get Subscription

Get mobile number subscription for an account

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.ProvisioningApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: auth
OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
auth.setAccessToken("YOUR ACCESS TOKEN");

ProvisioningApi apiInstance = new ProvisioningApi();
String authorization = "authorization_example"; // String | An OAUTH bearer token that is entitled to use the 'SUBSCRIPTION' scope.
try {
    List<ProvisionNumberResponse> result = apiInstance.getSubscription(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvisioningApi#getSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| An OAUTH bearer token that is entitled to use the &#39;SUBSCRIPTION&#39; scope. |

### Return type

[**List&lt;ProvisionNumberResponse&gt;**](ProvisionNumberResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
