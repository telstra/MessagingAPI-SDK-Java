# VirtualNumbersApi

All URIs are relative to *https://products.api.telstra.com/messaging/v3*

Method | HTTP request | Description
------------- | ------------- | -------------
[**assignNumber**](VirtualNumbersApi.md#assignNumber) | **POST** /virtual-numbers | assign a virtual number
[**deleteNumber**](VirtualNumbersApi.md#deleteNumber) | **DELETE** /virtual-numbers/{virtual-number} | delete a virtual number
[**getNumbers**](VirtualNumbersApi.md#getNumbers) | **GET** /virtual-numbers | fetch all virtual numbers
[**getRecipientOptouts**](VirtualNumbersApi.md#getRecipientOptouts) | **GET** /virtual-numbers/{virtual-number}/optouts | Get recipient optouts list
[**getVirtualNumber**](VirtualNumbersApi.md#getVirtualNumber) | **GET** /virtual-numbers/{virtual-number} | fetch a virtual number
[**updateNumber**](VirtualNumbersApi.md#updateNumber) | **PUT** /virtual-numbers/{virtual-number} | update a virtual number

<a name="assignNumber"></a>
# **assignNumber**
> VirtualNumber assignNumber(body, contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion)

assign a virtual number

When a recipient receives your message, you can choose whether they&#x27;ll see a privateNumber, Virtual Number or senderName (paid plans only) in the **from** field. If you want to use a Virtual Number, use this endpoint to assign one. Free Trial users can assign one Virtual Number, and those on a paid plan can assign up to 100.   Virtual Numbers that have not sent a message in 30 days (Free Trial) or sent/received a message in 18 months (paid plans) will be automatically unassigned from your account. You can check the **lastUse** date of your Virtual Number at any time using GET /virtual-numbers/{virtual-number}.  Note that Virtual Numbers used in v2 of the Messaging API cannot be used to send messages in v3. Please assign a new Virtual Number instead. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.VirtualNumbersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

VirtualNumbersApi apiInstance = new VirtualNumbersApi();
Object body = null; // Object | 
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    VirtualNumber result = apiInstance.assignNumber(body, contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VirtualNumbersApi#assignNumber");
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

[**VirtualNumber**](VirtualNumber.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteNumber"></a>
# **deleteNumber**
> deleteNumber(contentLanguage, authorization, accept, acceptCharset, contentType, virtualNumber, telstraApiVersion)

delete a virtual number

Use **virtual-number** to remove a Virtual Number that&#x27;s been assigned to your account. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.VirtualNumbersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

VirtualNumbersApi apiInstance = new VirtualNumbersApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String virtualNumber = "virtualNumber_example"; // String | Write the Virtual Number here, using national format (e.g. 0412345678). 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    apiInstance.deleteNumber(contentLanguage, authorization, accept, acceptCharset, contentType, virtualNumber, telstraApiVersion);
} catch (ApiException e) {
    System.err.println("Exception when calling VirtualNumbersApi#deleteNumber");
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
 **virtualNumber** | **String**| Write the Virtual Number here, using national format (e.g. 0412345678).  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNumbers"></a>
# **getNumbers**
> InlineResponse2001 getNumbers(contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion, limit, offset, filter)

fetch all virtual numbers

Use this endpoint to fetch all Virtual Numbers currently assigned to your account. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.VirtualNumbersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

VirtualNumbersApi apiInstance = new VirtualNumbersApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
Integer limit = 10; // Integer | Tell us how many results you want us to return, up to a maximum of 50. 
Integer offset = 0; // Integer | Use the offset to navigate between the response results. An offset of 0 will display the first page of results, and so on. 
String filter = "filter_example"; // String | Filter your Virtual Numbers by tag or by number.
try {
    InlineResponse2001 result = apiInstance.getNumbers(contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion, limit, offset, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VirtualNumbersApi#getNumbers");
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
 **limit** | **Integer**| Tell us how many results you want us to return, up to a maximum of 50.  | [optional] [default to 10] [enum: 1, 50]
 **offset** | **Integer**| Use the offset to navigate between the response results. An offset of 0 will display the first page of results, and so on.  | [optional] [default to 0] [enum: 0, 999999]
 **filter** | **String**| Filter your Virtual Numbers by tag or by number. | [optional]

### Return type

[**InlineResponse2001**](GetNumbers200Response.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRecipientOptouts"></a>
# **getRecipientOptouts**
> InlineResponse2002 getRecipientOptouts(contentLanguage, authorization, accept, acceptCharset, contentType, virtualNumber, telstraApiVersion, limit, offset)

Get recipient optouts list

Use this endpoint to fetch any mobile number(s) that have opted out of receiving messages from a Virtual Number assigned to your account.  Recipients can opt out at any time by sending a message with industry standard keywords such as STOP, STOPALL, UNSUBSCRIBE, QUIT, END and CANCEL. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.VirtualNumbersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

VirtualNumbersApi apiInstance = new VirtualNumbersApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String virtualNumber = "virtualNumber_example"; // String | Write the Virtual Number here, using national format (e.g. 0412345678). 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
Integer limit = 10; // Integer | Tell us how many results you want us to return, up to a maximum of 50. 
Integer offset = 0; // Integer | Use the offset to navigate between the response results. An offset of 0 will display the first page of results, and so on. 
try {
    InlineResponse2002 result = apiInstance.getRecipientOptouts(contentLanguage, authorization, accept, acceptCharset, contentType, virtualNumber, telstraApiVersion, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VirtualNumbersApi#getRecipientOptouts");
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
 **virtualNumber** | **String**| Write the Virtual Number here, using national format (e.g. 0412345678).  |
 **telstraApiVersion** | **String**|  | [optional]
 **limit** | **Integer**| Tell us how many results you want us to return, up to a maximum of 50.  | [optional] [default to 10] [enum: 1, 50]
 **offset** | **Integer**| Use the offset to navigate between the response results. An offset of 0 will display the first page of results, and so on.  | [optional] [default to 0] [enum: 0, 999999]

### Return type

[**InlineResponse2002**](GetRecipientOptouts200Response.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getVirtualNumber"></a>
# **getVirtualNumber**
> VirtualNumber getVirtualNumber(contentLanguage, authorization, accept, acceptCharset, contentType, virtualNumber, telstraApiVersion)

fetch a virtual number

Fetch the tags, replyCallbackUrl and lastUse date for a Virtual Number.

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.VirtualNumbersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

VirtualNumbersApi apiInstance = new VirtualNumbersApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String virtualNumber = "virtualNumber_example"; // String | Write the Virtual Number here, using national format (e.g. 0412345678). 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    VirtualNumber result = apiInstance.getVirtualNumber(contentLanguage, authorization, accept, acceptCharset, contentType, virtualNumber, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VirtualNumbersApi#getVirtualNumber");
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
 **virtualNumber** | **String**| Write the Virtual Number here, using national format (e.g. 0412345678).  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**VirtualNumber**](VirtualNumber.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateNumber"></a>
# **updateNumber**
> VirtualNumber updateNumber(body, contentLanguage, authorization, accept, acceptCharset, contentType, virtualNumber, telstraApiVersion)

update a virtual number

Use **virtual-number** to update the tags and/or replyCallbackUrl of a Virtual Number.  This request body will override the original POST/ virtual-numbers call. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.VirtualNumbersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

VirtualNumbersApi apiInstance = new VirtualNumbersApi();
Object body = null; // Object | 
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String virtualNumber = "virtualNumber_example"; // String | Write the Virtual Number here, using national format (e.g. 0412345678). 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    VirtualNumber result = apiInstance.updateNumber(body, contentLanguage, authorization, accept, acceptCharset, contentType, virtualNumber, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VirtualNumbersApi#updateNumber");
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
 **virtualNumber** | **String**| Write the Virtual Number here, using national format (e.g. 0412345678).  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**VirtualNumber**](VirtualNumber.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

