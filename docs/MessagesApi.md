# MessagesApi

All URIs are relative to *https://products.api.telstra.com/messaging/v3*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteMessageById**](MessagesApi.md#deleteMessageById) | **DELETE** /messages/{messageId} | delete a message
[**getMessageById**](MessagesApi.md#getMessageById) | **GET** /messages/{messageId} | fetch a specific message
[**getMessages**](MessagesApi.md#getMessages) | **GET** /messages | fetch all sent/received messages
[**sendMessages**](MessagesApi.md#sendMessages) | **POST** /messages | send messages
[**updateMessageById**](MessagesApi.md#updateMessageById) | **PUT** /messages/{messageId} | update a message
[**updateMessageTags**](MessagesApi.md#updateMessageTags) | **PATCH** /messages/{messageId} | update message tags

<a name="deleteMessageById"></a>
# **deleteMessageById**
> deleteMessageById(contentLanguage, authorization, accept, acceptCharset, contentType, messageId, telstraApiVersion)

delete a message

Use this endpoint to delete a message that&#x27;s been scheduled for sending, but hasn&#x27;t yet sent. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

MessagesApi apiInstance = new MessagesApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
UUID messageId = new UUID(); // UUID | When you sent the original message, this is the UUID that was returned in the call response. Use this ID to fetch, update or delete a message with the appropriate endpoints. 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    apiInstance.deleteMessageById(contentLanguage, authorization, accept, acceptCharset, contentType, messageId, telstraApiVersion);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#deleteMessageById");
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
 **messageId** | [**UUID**](.md)| When you sent the original message, this is the UUID that was returned in the call response. Use this ID to fetch, update or delete a message with the appropriate endpoints.  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMessageById"></a>
# **getMessageById**
> MessageGet getMessageById(contentLanguage, authorization, accept, acceptCharset, contentType, messageId, telstraApiVersion)

fetch a specific message

Use the **messageId** to fetch a message that&#x27;s been sent from/to your account within the last 30 days. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

MessagesApi apiInstance = new MessagesApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
UUID messageId = new UUID(); // UUID | When you sent the original message, this is the UUID that was returned in the response. Use this ID to fetch, update or delete a message with the appropriate endpoints.   Incoming messages are also assigned a messageId. Use this ID with GET/ messages/{messageId} to fetch the message later. 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    MessageGet result = apiInstance.getMessageById(contentLanguage, authorization, accept, acceptCharset, contentType, messageId, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#getMessageById");
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
 **messageId** | [**UUID**](.md)| When you sent the original message, this is the UUID that was returned in the response. Use this ID to fetch, update or delete a message with the appropriate endpoints.   Incoming messages are also assigned a messageId. Use this ID with GET/ messages/{messageId} to fetch the message later.  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**MessageGet**](MessageGet.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMessages"></a>
# **getMessages**
> InlineResponse200 getMessages(contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion, limit, offset, direction, status, filter)

fetch all sent/received messages

Fetch messages that have been sent from/to your account in the last 30 days.

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

MessagesApi apiInstance = new MessagesApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
Integer limit = 10; // Integer | Tell us how many results you want us to return, up to a maximum of 50. 
Integer offset = 0; // Integer | Use the offset to navigate between the response results. An offset of 0 will display the first page of results, and so on. 
String direction = "direction_example"; // String | Filter your messages by direction: * **outgoing** – messages sent from your account. * **incoming** – messages sent to your account. 
String status = "status_example"; // String | Filter your messages by one of the statuses below:  * **queued** – messages queued for sending or still in transit. * **sent** – messages that have been sent from the server. * **delivered** – messages successful delivered to the recipient's device. Note that we will only be able to return this status if you set deliveryNotification to **true** (paid feature).  * **expired** – message that couldn't be sent within the **retryTimeout** timeframe. 
String filter = "filter_example"; // String | Filter your messages by:  * tag - use one of the tags assigned to your message(s) * number - either the Virtual Number used to send the message, or the Recipient Number the message was sent to. 
try {
    InlineResponse200 result = apiInstance.getMessages(contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion, limit, offset, direction, status, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#getMessages");
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
 **direction** | **String**| Filter your messages by direction: * **outgoing** – messages sent from your account. * **incoming** – messages sent to your account.  | [optional] [enum: outgoing, incoming]
 **status** | **String**| Filter your messages by one of the statuses below:  * **queued** – messages queued for sending or still in transit. * **sent** – messages that have been sent from the server. * **delivered** – messages successful delivered to the recipient&#x27;s device. Note that we will only be able to return this status if you set deliveryNotification to **true** (paid feature).  * **expired** – message that couldn&#x27;t be sent within the **retryTimeout** timeframe.  | [optional] [enum: queued, sent, delivered, expired]
 **filter** | **String**| Filter your messages by:  * tag - use one of the tags assigned to your message(s) * number - either the Virtual Number used to send the message, or the Recipient Number the message was sent to.  | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="sendMessages"></a>
# **sendMessages**
> MessageSent sendMessages(body, contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion)

send messages

Send an SMS/MMS to a mobile number, or to multiple mobile numbers.  Free Trial users can message to up to 10 unique recipient numbers for free. The first five recipients will be automatically added to your Free Trial Numbers list. Need more? Just use the POST /free-trial-numbers call to add another five. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

MessagesApi apiInstance = new MessagesApi();
Object body = null; // Object | 
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    MessageSent result = apiInstance.sendMessages(body, contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#sendMessages");
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

[**MessageSent**](MessageSent.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateMessageById"></a>
# **updateMessageById**
> MessageUpdate updateMessageById(body, contentLanguage, authorization, accept, acceptCharset, contentType, messageId, telstraApiVersion)

update a message

Need to update a message that&#x27;s scheduled for sending? You can change any of the below parameters, as long as the message hasn&#x27;t been sent yet. This request body will override the original POST/ messages call. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

MessagesApi apiInstance = new MessagesApi();
Object body = null; // Object | 
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
UUID messageId = new UUID(); // UUID | When you sent the original message, this is the UUID that was returned in the call response. Use this ID to fetch, update or delete a message with the appropriate endpoints. 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    MessageUpdate result = apiInstance.updateMessageById(body, contentLanguage, authorization, accept, acceptCharset, contentType, messageId, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#updateMessageById");
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
 **messageId** | [**UUID**](.md)| When you sent the original message, this is the UUID that was returned in the call response. Use this ID to fetch, update or delete a message with the appropriate endpoints.  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**MessageUpdate**](MessageUpdate.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateMessageTags"></a>
# **updateMessageTags**
> updateMessageTags(body, contentLanguage, authorization, accept, acceptCharset, contentType, messageId, telstraApiVersion)

update message tags

Use the **messageId** to update the tag(s) assigned to a message. You can use this endpoint any time, even after your message has been delivered. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

MessagesApi apiInstance = new MessagesApi();
Object body = null; // Object | 
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
UUID messageId = new UUID(); // UUID | When you sent the original message, this is the UUID that was returned in the call response. Use this ID to fetch, update or delete a message with the appropriate endpoints. 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    apiInstance.updateMessageTags(body, contentLanguage, authorization, accept, acceptCharset, contentType, messageId, telstraApiVersion);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#updateMessageTags");
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
 **messageId** | [**UUID**](.md)| When you sent the original message, this is the UUID that was returned in the call response. Use this ID to fetch, update or delete a message with the appropriate endpoints.  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

