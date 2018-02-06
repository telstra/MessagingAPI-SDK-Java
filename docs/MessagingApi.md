# MessagingApi

All URIs are relative to *https://tapi.telstra.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMMSStatus**](MessagingApi.md#getMMSStatus) | **GET** /messages/mms/{messageid}/status | Get MMS Status
[**getSMSStatus**](MessagingApi.md#getSMSStatus) | **GET** /messages/sms/{messageId}/status | Get SMS Status
[**retrieveSMSResponses**](MessagingApi.md#retrieveSMSResponses) | **GET** /messages/sms | Retrieve SMS Responses
[**sendMMS**](MessagingApi.md#sendMMS) | **POST** /messages/mms | Send MMS
[**sendSMS**](MessagingApi.md#sendSMS) | **POST** /messages/sms | Send SMS


<a name="getMMSStatus"></a>
# **getMMSStatus**
> OutboundPollResponse getMMSStatus(messageid)

Get MMS Status

Get MMS Status

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: auth
OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
auth.setAccessToken("YOUR ACCESS TOKEN");

MessagingApi apiInstance = new MessagingApi();
String messageid = "messageid_example"; // String | Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/mms
try {
    OutboundPollResponse result = apiInstance.getMMSStatus(messageid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#getMMSStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageid** | **String**| Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/mms |

### Return type

[**OutboundPollResponse**](OutboundPollResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSMSStatus"></a>
# **getSMSStatus**
> OutboundPollResponse getSMSStatus(messageId)

Get SMS Status

Get Message Status

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: auth
OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
auth.setAccessToken("YOUR ACCESS TOKEN");

MessagingApi apiInstance = new MessagingApi();
String messageId = "messageId_example"; // String | Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/sms
try {
    OutboundPollResponse result = apiInstance.getSMSStatus(messageId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#getSMSStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageId** | **String**| Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/sms |

### Return type

[**OutboundPollResponse**](OutboundPollResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveSMSResponses"></a>
# **retrieveSMSResponses**
> List&lt;InboundPollResponse&gt; retrieveSMSResponses()

Retrieve SMS Responses

Retrieve Messages

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: auth
OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
auth.setAccessToken("YOUR ACCESS TOKEN");

MessagingApi apiInstance = new MessagingApi();
try {
    List<InboundPollResponse> result = apiInstance.retrieveSMSResponses();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#retrieveSMSResponses");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;InboundPollResponse&gt;**](InboundPollResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendMMS"></a>
# **sendMMS**
> Object sendMMS(body)

Send MMS

Send MMS

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: auth
OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
auth.setAccessToken("YOUR ACCESS TOKEN");

MessagingApi apiInstance = new MessagingApi();
SendMmsRequest body = new SendMmsRequest(); // SendMmsRequest | A JSON or XML payload containing the recipient's phone number and MMS message.The recipient number should be in the format '04xxxxxxxx' where x is a digit
try {
    Object result = apiInstance.sendMMS(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#sendMMS");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMmsRequest**](SendMmsRequest.md)| A JSON or XML payload containing the recipient&#39;s phone number and MMS message.The recipient number should be in the format &#39;04xxxxxxxx&#39; where x is a digit |

### Return type

**Object**

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendSMS"></a>
# **sendSMS**
> MessageSentResponse sendSMS(payload)

Send SMS

Send Message

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.MessagingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: auth
OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
auth.setAccessToken("YOUR ACCESS TOKEN");

MessagingApi apiInstance = new MessagingApi();
SendSMSRequest payload = new SendSMSRequest(); // SendSMSRequest | A JSON or XML payload containing the recipient's phone number and text message. The recipient number should be in the format '04xxxxxxxx' where x is a digit
try {
    MessageSentResponse result = apiInstance.sendSMS(payload);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#sendSMS");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **payload** | [**SendSMSRequest**](SendSMSRequest.md)| A JSON or XML payload containing the recipient&#39;s phone number and text message. The recipient number should be in the format &#39;04xxxxxxxx&#39; where x is a digit |

### Return type

[**MessageSentResponse**](MessageSentResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

