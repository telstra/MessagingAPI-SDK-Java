# FreeTrialNumbersApi

All URIs are relative to *https://products.api.telstra.com/messaging/v3*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTrialNumbers**](FreeTrialNumbersApi.md#createTrialNumbers) | **POST** /free-trial-numbers | create free trial number list
[**getTrialNumbers**](FreeTrialNumbersApi.md#getTrialNumbers) | **GET** /free-trial-numbers | get all free trial numbers

<a name="createTrialNumbers"></a>
# **createTrialNumbers**
> FreeTrialNumbers createTrialNumbers(body, contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion)

create free trial number list

Your Free Trial Numbers are the 10 recipient mobile numbers that you can message during the Free Trial. The first five numbers you send an SMS/MMS to will automatically be added to your Free Trial Numbers list. After that, you can use this endpoint to register another five. Alternatively, you can use this endpoint to register all 10 numbers.    Use this endpoint to register a Free Trial Number to your account. To test out all the features that the trial has to offer, we recommend registering your own mobile number to your Free Trial Numbers list.   Note that you can only message mobile numbers that have been added to your Free Trial list and once registered, a Free Trial Number cannot be removed or replaced. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.FreeTrialNumbersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

FreeTrialNumbersApi apiInstance = new FreeTrialNumbersApi();
Object body = null; // Object | 
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    FreeTrialNumbers result = apiInstance.createTrialNumbers(body, contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FreeTrialNumbersApi#createTrialNumbers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Object**](Object.md)|  |
 **contentLanguage** | **String**|  |
 **authorization** | **String**|  |
 **accept** | **String**|  |
 **acceptCharset** | **String**|  |
 **contentType** | **String**|  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**FreeTrialNumbers**](FreeTrialNumbers.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTrialNumbers"></a>
# **getTrialNumbers**
> FreeTrialNumbers getTrialNumbers(contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion)

get all free trial numbers

Use this endpoint to fetch the Free Trial Number(s) currently assigned to your account. These are the mobile numbers that you can message during the Free Trial.  If you&#x27;re using a paid plan, there&#x27;s no limit to the number of recipients that you can message, so you don&#x27;t need to register Free Trial Numbers. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.FreeTrialNumbersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

FreeTrialNumbersApi apiInstance = new FreeTrialNumbersApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    FreeTrialNumbers result = apiInstance.getTrialNumbers(contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FreeTrialNumbersApi#getTrialNumbers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentLanguage** | **String**|  |
 **authorization** | **String**|  |
 **accept** | **String**|  |
 **acceptCharset** | **String**|  |
 **contentType** | **String**|  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**FreeTrialNumbers**](FreeTrialNumbers.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

