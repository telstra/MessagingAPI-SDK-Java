# ProvisioningApi

All URIs are relative to *https://tapi.telstra.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSubscription**](ProvisioningApi.md#createSubscription) | **POST** /messages/provisioning/subscriptions | Create Subscription
[**deleteSubscription**](ProvisioningApi.md#deleteSubscription) | **DELETE** /messages/provisioning/subscriptions | Delete Subscription
[**getSubscription**](ProvisioningApi.md#getSubscription) | **GET** /messages/provisioning/subscriptions | Get Subscription


<a name="createSubscription"></a>
# **createSubscription**
> ProvisionNumberResponse createSubscription(body)

Create Subscription

Invoke the provisioning API to get a dedicated mobile number for an account or application.  Note that Free Trial apps will have a 30-Day Limit for their provisioned number. If the Provisioning call is made several times within that 30-Day period, it will return the &#x60;expiryDate&#x60; in the Unix format and will not add any activeDays until after that &#x60;expiryDate&#x60;. After the &#x60;expiryDate&#x60;, you may make another Provisioning call to extend the activeDays by another 30-Days.  For paid apps, a provisioned number can be allotted for a maximum of 5 years. If a Provisioning call is made which will result to activeDays &gt; 1825, a 409 &#x60;Active Days Max&#x60; response will be returned to indicate that the provisioned number is already valid for more than 5 years and that no update to activeDays has been made. 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.ProvisioningApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    ProvisioningApi apiInstance = new ProvisioningApi(defaultClient);
    ProvisionNumberRequest body = new ProvisionNumberRequest(); // ProvisionNumberRequest | A JSON payload containing the required attributes
    try {
      ProvisionNumberResponse result = apiInstance.createSubscription(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProvisioningApi#createSubscription");
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
 **body** | [**ProvisionNumberRequest**](ProvisionNumberRequest.md)| A JSON payload containing the required attributes |

### Return type

[**ProvisionNumberResponse**](ProvisionNumberResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Invalid or missing request parameters |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission  SpikeArrest-The API call rate limit has been exceeded |  -  |
**404** | The requested URI does not exist  RESOURCE-NOT-FOUND  |  -  |
**409** | Active Days Max. You can no longer update or add to activeDays because it already exceeds more than 5 years. |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="deleteSubscription"></a>
# **deleteSubscription**
> deleteSubscription(body)

Delete Subscription

Delete a mobile number subscription from an account 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.ProvisioningApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    ProvisioningApi apiInstance = new ProvisioningApi(defaultClient);
    DeleteNumberRequest body = new DeleteNumberRequest(); // DeleteNumberRequest | EmptyArr
    try {
      apiInstance.deleteSubscription(body);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProvisioningApi#deleteSubscription");
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
 **body** | [**DeleteNumberRequest**](DeleteNumberRequest.md)| EmptyArr |

### Return type

null (empty response body)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | No Content |  -  |
**400** | Invalid or missing request parameters |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission  SpikeArrest-The API call rate limit has been exceeded |  -  |
**404** | The requested URI does not exist  RESOURCE-NOT-FOUND |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="getSubscription"></a>
# **getSubscription**
> GetSubscriptionResponse getSubscription()

Get Subscription

Get mobile number subscription for an account 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.ProvisioningApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    ProvisioningApi apiInstance = new ProvisioningApi(defaultClient);
    try {
      GetSubscriptionResponse result = apiInstance.getSubscription();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProvisioningApi#getSubscription");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetSubscriptionResponse**](GetSubscriptionResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | Invalid or missing request parameters |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission  SpikeArrest-The API call rate limit has been exceeded |  -  |
**404** | The requested URI does not exist  RESOURCE-NOT-FOUND |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue |  -  |
**0** | An internal error occurred when processing the request |  -  |

