# MessagingApi

All URIs are relative to *https://tapi.telstra.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMMSStatus**](MessagingApi.md#getMMSStatus) | **GET** /messages/mms/{messageid}/status | Get MMS Status
[**getSMSStatus**](MessagingApi.md#getSMSStatus) | **GET** /messages/sms/{messageId}/status | Get SMS Status
[**mMSHealthCheck**](MessagingApi.md#mMSHealthCheck) | **GET** /messages/mms/heathcheck | MMS Health Check
[**retrieveMMSReplies**](MessagingApi.md#retrieveMMSReplies) | **GET** /messages/mms | Retrieve MMS Replies
[**retrieveSMSReplies**](MessagingApi.md#retrieveSMSReplies) | **GET** /messages/sms | Retrieve SMS Replies
[**sMSHealthCheck**](MessagingApi.md#sMSHealthCheck) | **GET** /messages/sms/heathcheck | SMS Health Check
[**sMSMulti**](MessagingApi.md#sMSMulti) | **POST** /messages/sms/multi | Send Multiple SMS
[**sendMMS**](MessagingApi.md#sendMMS) | **POST** /messages/mms | Send MMS
[**sendSMS**](MessagingApi.md#sendSMS) | **POST** /messages/sms | Send SMS


<a name="getMMSStatus"></a>
# **getMMSStatus**
> List&lt;OutboundPollResponse&gt; getMMSStatus(messageid)

Get MMS Status

Get MMS Status

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    String messageid = "messageid_example"; // String | Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/mms 
    try {
      List<OutboundPollResponse> result = apiInstance.getMMSStatus(messageid);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#getMMSStatus");
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
 **messageid** | **String**| Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/mms  |

### Return type

[**List&lt;OutboundPollResponse&gt;**](OutboundPollResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  |  -  |
**404** | The requested URI does not exist OLD-NONEXISTANT-MESSAGE-ID RESOURCE-NOT-FOUND  |  -  |
**405** | The requested resource does not support the supplied verb |  -  |
**415** | API does not support the requested content type |  -  |
**422** | The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="getSMSStatus"></a>
# **getSMSStatus**
> List&lt;OutboundPollResponse&gt; getSMSStatus(messageId)

Get SMS Status

If no notification URL has been specified, it is possible to poll for the message status.  Note that the &#x60;MessageId&#x60; that appears in the URL must be URL encoded. Just copying the &#x60;MessageId&#x60; as it was supplied when submitting the message may not work.  # SMS Status with Notification URL  When a message has reached its final state, the API will send a POST to the URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{     \&quot;to\&quot;: \&quot;+61418123456\&quot;,     \&quot;sentTimestamp\&quot;: \&quot;2017-03-17T10:05:22+10:00\&quot;,     \&quot;receivedTimestamp\&quot;: \&quot;2017-03-17T10:05:23+10:00\&quot;,     \&quot;messageId\&quot;: \&quot;1234567890ABCDEFGHIJKLNOPQRSTUVW\&quot;,     \&quot;deliveryStatus\&quot;: \&quot;DELIVRD\&quot;   } &lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- | ---| | &#x60;to&#x60; |  The number the message was sent to. | | &#x60;receivedTimestamp&#x60; | Time the message was sent to the API. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;deliveryStatus&#x60; | The final state of the message. | | &#x60;messageId&#x60; | The same reference that was returned when the original message was sent.| | &#x60;receivedTimestamp&#x60; | Time the message was sent to the API.|  Upon receiving this call it is expected that your servers will give a 204 (No Content) response. 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    String messageId = "messageId_example"; // String | Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/sms. 
    try {
      List<OutboundPollResponse> result = apiInstance.getSMSStatus(messageId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#getSMSStatus");
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
 **messageId** | **String**| Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/sms.  |

### Return type

[**List&lt;OutboundPollResponse&gt;**](OutboundPollResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission  SpikeArrest-The API call rate limit has been exceeded |  -  |
**404** | The requested URI does not exist  OLD-NONEXISTANT-MESSAGE-ID  RESOURCE-NOT-FOUND |  -  |
**405** | The requested resource does not support the supplied verb |  -  |
**415** | API does not support the requested content type |  -  |
**422** | The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="mMSHealthCheck"></a>
# **mMSHealthCheck**
> HealthCheckResponse mMSHealthCheck()

MMS Health Check

Determine whether the MMS service is up or down. 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    try {
      HealthCheckResponse result = apiInstance.mMSHealthCheck();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#mMSHealthCheck");
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

[**HealthCheckResponse**](HealthCheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="retrieveMMSReplies"></a>
# **retrieveMMSReplies**
> GetMmsResponse retrieveMMSReplies()

Retrieve MMS Replies

Messages are retrieved one at a time, starting with the earliest reply.  If the subscription has a &#x60;notifyURL&#x60;, reply messages will be logged there instead, i.e. &#x60;GET&#x60; and reply &#x60;notifyURL&#x60; are exclusive.  # MMS Reply with Notification URL  When a reply is received, the API will send a POST to the subscription URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;: \&quot;+61418123456\&quot;,   \&quot;from\&quot;: \&quot;+61421987654\&quot;,   \&quot;sentTimestamp\&quot;: \&quot;2018-03-23T12:15:45+10:00\&quot;,   \&quot;messageId\&quot;: \&quot;XFRO1ApiA0000000111\&quot;,   \&quot;subject\&quot;: \&quot;Foo\&quot;,   \&quot;envelope\&quot;: \&quot;string\&quot;,   \&quot;MMSContent\&quot;:     [       {         \&quot;type\&quot;: \&quot;text/plain\&quot;,         \&quot;filename\&quot;: \&quot;text_1.txt\&quot;,         \&quot;payload\&quot;: \&quot;string\&quot;       },       {         \&quot;type\&quot;: \&quot;image/jpeg\&quot;,         \&quot;filename\&quot;: \&quot;sample.jpeg\&quot;,         \&quot;payload\&quot;: \&quot;string\&quot;       }     ] }&lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- | --- | | &#x60;to&#x60; |The number the message was sent to. | | &#x60;from&#x60; | The number the message was sent from. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;messageId&#x60; | Message Id assigned by the MMSC | | &#x60;subject&#x60; | The subject assigned to the message. | | &#x60;envelope&#x60; | Information about about terminal type and originating operator. | | &#x60;MMSContent&#x60; | An array of the actual content of the reply message. | | &#x60;type&#x60; | The content type of the message. | | &#x60;filename&#x60; | The filename for the message content. | | &#x60;payload&#x60; | The content of the message. | 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    try {
      GetMmsResponse result = apiInstance.retrieveMMSReplies();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#retrieveMMSReplies");
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

[**GetMmsResponse**](GetMmsResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  |  -  |
**404** | The requested URI does not exist RESOURCE-NOT-FOUND  |  -  |
**405** | The requested resource does not support the supplied verb |  -  |
**415** | API does not support the requested content type |  -  |
**422** | The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="retrieveSMSReplies"></a>
# **retrieveSMSReplies**
> InboundPollResponse retrieveSMSReplies()

Retrieve SMS Replies

Messages are retrieved one at a time, starting with the earliest reply.  The API supports the encoding of emojis in the reply message. The emojis will be in their UTF-8 format.  If the subscription has a &#x60;notifyURL&#x60;, reply messages will be logged there instead.  # SMS Reply with Notification URL  When a reply is received, the API will send a POST to the subscription URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;:\&quot;+61472880123\&quot;,   \&quot;from\&quot;:\&quot;+61412345678\&quot;,   \&quot;body\&quot;:\&quot;Foo4\&quot;,   \&quot;sentTimestamp\&quot;:\&quot;2018-04-20T14:24:35\&quot;,   \&quot;messageId\&quot;:\&quot;DMASApiA0000000146\&quot; }&lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- |--- | | &#x60;to&#x60; | The number the message was sent to. | | &#x60;from&#x60; | The number the message was sent from. | | &#x60;body&#x60; | The content of the SMS response. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;messageId&#x60; | The ID assigned to the message. | 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    try {
      InboundPollResponse result = apiInstance.retrieveSMSReplies();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#retrieveSMSReplies");
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

[**InboundPollResponse**](InboundPollResponse.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  |  -  |
**404** | The requested URI does not exist RESOURCE-NOT-FOUND  |  -  |
**405** | The requested resource does not support the supplied verb |  -  |
**415** | API does not support the requested content type |  -  |
**422** | The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="sMSHealthCheck"></a>
# **sMSHealthCheck**
> HealthCheckResponse sMSHealthCheck()

SMS Health Check

Determine whether the SMS service is up or down. 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    try {
      HealthCheckResponse result = apiInstance.sMSHealthCheck();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#sMSHealthCheck");
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

[**HealthCheckResponse**](HealthCheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="sMSMulti"></a>
# **sMSMulti**
> MessageSentResponseSms sMSMulti(payload)

Send Multiple SMS

Send multiple SMS in one API call. 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    SendSmsMultiRequest payload = new SendSmsMultiRequest(); // SendSmsMultiRequest | A JSON payload containing the recipient's phone number and text message. This number can be in international format if preceeded by a '+' or in national format ('04xxxxxxxx') where x is a digit. 
    try {
      MessageSentResponseSms result = apiInstance.sMSMulti(payload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#sMSMulti");
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
 **payload** | [**SendSmsMultiRequest**](SendSmsMultiRequest.md)| A JSON payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  |

### Return type

[**MessageSentResponseSms**](MessageSentResponseSms.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | Invalid or missing request parameters * DR-NOTIFY-URL-MISSING : when receiptOff is missing or receiptOff&#x3D;false but notifyURL is missing  |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="sendMMS"></a>
# **sendMMS**
> MessageSentResponseMms sendMMS(body)

Send MMS

Send MMS

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    SendMmsRequest body = new SendMmsRequest(); // SendMmsRequest | A JSON or XML payload containing the recipient's phone number and MMS message. The recipient number should be in the format '04xxxxxxxx' where x is a digit. 
    try {
      MessageSentResponseMms result = apiInstance.sendMMS(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#sendMMS");
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
 **body** | [**SendMmsRequest**](SendMmsRequest.md)| A JSON or XML payload containing the recipient&#39;s phone number and MMS message. The recipient number should be in the format &#39;04xxxxxxxx&#39; where x is a digit.  |

### Return type

[**MessageSentResponseMms**](MessageSentResponseMms.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Invalid or missing request parameters MMS-TYPE-MISSING MMS-PAYLOAD-MISSING MMS-FILENAME-MISSING DELIVERY-IMPOSSIBLE TO-MSISDN-NOT-VALID SENDER-MISSING DELIVERY-IMPOSSIBLE SUBJECT-TOO-LONG FROM-MSISDN-TOO-LONG TO-MSISDN-TOO-LONG NOT-PROVISIONED Request flagged as containing suspicious content  |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  |  -  |
**404** | The requested URI does not exist RESOURCE-NOT-FOUND  |  -  |
**405** | The requested resource does not support the supplied verb |  -  |
**415** | API does not support the requested content type |  -  |
**422** | The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

<a name="sendSMS"></a>
# **sendSMS**
> MessageSentResponseSms sendSMS(payload)

Send SMS

Send an SMS Message to a single or multiple mobile number/s. 

### Example
```java
// Import classes:
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.Configuration;
import com.telstra.auth.*;
import com.telstra.models.*;
import com.telstra.messaging.MessagingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://tapi.telstra.com/v2");
    
    // Configure OAuth2 access token for authorization: auth
    OAuth auth = (OAuth) defaultClient.getAuthentication("auth");
    auth.setAccessToken("YOUR ACCESS TOKEN");

    MessagingApi apiInstance = new MessagingApi(defaultClient);
    SendSMSRequest payload = new SendSMSRequest(); // SendSMSRequest | A JSON or XML payload containing the recipient's phone number and text message. This number can be in international format if preceeded by a '+' or in national format ('04xxxxxxxx') where x is a digit. 
    try {
      MessageSentResponseSms result = apiInstance.sendSMS(payload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessagingApi#sendSMS");
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
 **payload** | [**SendSMSRequest**](SendSMSRequest.md)| A JSON or XML payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  |

### Return type

[**MessageSentResponseSms**](MessageSentResponseSms.md)

### Authorization

[auth](../README.md#auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Invalid or missing request parameters * TO-MSISDN-NOT-VALID * SENDER-MISSING * DELIVERY-IMPOSSIBLE * FROM-MSISDN-TOO-LONG * BODY-TOO-LONG * BODY-MISSING * TO-MSISDN-TOO-LONG * TECH-ERR * BODY-NOT-VALID * NOT-PROVISIONED * Request flagged as containing suspicious content. * Invalid &#39;from&#39; address specified.  |  -  |
**401** | Invalid access token. Please try with a valid token |  -  |
**403** | Authorization credentials passed and accepted but account does not have permission.  SpikeArrest-The API call rate limit has been exceeded  |  -  |
**404** | The requested URI does not exist RESOURCE-NOT-FOUND  |  -  |
**405** | The requested resource does not support the supplied verb |  -  |
**415** | API does not support the requested content type |  -  |
**422** | The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  |  -  |
**500** | Technical error : Unable to route the message to a Target Endpoint :  An error has occurred while processing your request, please refer to API Docs for summary on the issue  |  -  |
**501** | The HTTP method being used has not yet been implemented for the requested resource  |  -  |
**503** | The service requested is currently unavailable |  -  |
**0** | An internal error occurred when processing the request |  -  |

