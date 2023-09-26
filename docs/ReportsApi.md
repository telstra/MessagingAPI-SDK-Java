# ReportsApi

All URIs are relative to *https://products.api.telstra.com/messaging/v3*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getReport**](ReportsApi.md#getReport) | **GET** /reports/{reportId} | fetch a specific report
[**getReports**](ReportsApi.md#getReports) | **GET** /reports | fetch all reports
[**messagesReport**](ReportsApi.md#messagesReport) | **POST** /reports/messages | submit a request for a messages report

<a name="getReport"></a>
# **getReport**
> InlineResponse2005 getReport(contentLanguage, authorization, accept, acceptCharset, contentType, reportId, telstraApiVersion)

fetch a specific report

Fetch a download link for a report generated with POST /reports/{reportId} using the **reportId** returned in the response. Once ready, your report will be available for download for one week. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.ReportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

ReportsApi apiInstance = new ReportsApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
UUID reportId = new UUID(); // UUID | Use the reportId returned in the POST /reports/{reportType} response. 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    InlineResponse2005 result = apiInstance.getReport(contentLanguage, authorization, accept, acceptCharset, contentType, reportId, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApi#getReport");
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
 **reportId** | [**UUID**](.md)| Use the reportId returned in the POST /reports/{reportType} response.  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**InlineResponse2005**](InlineResponse2005.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getReports"></a>
# **getReports**
> InlineResponse2004 getReports(contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion)

fetch all reports

Fetch details of all reports recently generated for your account. Use it to check the status of a report, plus fetch the report ID, status, report type and expiry date. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.ReportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

ReportsApi apiInstance = new ReportsApi();
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    InlineResponse2004 result = apiInstance.getReports(contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApi#getReports");
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

[**InlineResponse2004**](GetReports200Response.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="messagesReport"></a>
# **messagesReport**
> InlineResponse201 messagesReport(body, contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion)

submit a request for a messages report

Request a CSV report of messages (both incoming and outgoing) that have been sent to/from your account within the last three months. You can request details for a specific timeframe, and filter your messages by tags, recipient number or Virtual Number.  A 201 Created means your report has been queued for generation. Make a note of the reportId returned in the response. You&#x27;ll need this to check the status of your report and fetch your download link with GET reports/{reportId}. If you supplied a reportCallbackUrl in the request we&#x27;ll also notify it when your report is ready for download.  Once your report is generated, it will be available for download for one week. The expiry date is returned in the response. 

### Example
```java
// Import classes:
//import com.telstra.ApiClient;
//import com.telstra.ApiException;
//import com.telstra.Configuration;
//import com.telstra.auth.*;
//import com.telstra.messaging.ReportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: bearer_auth
OAuth bearer_auth = (OAuth) defaultClient.getAuthentication("bearer_auth");
bearer_auth.setAccessToken("YOUR ACCESS TOKEN");

ReportsApi apiInstance = new ReportsApi();
ReportsMessagesBody body = new ReportsMessagesBody(); // ReportsMessagesBody | 
String contentLanguage = "contentLanguage_example"; // String | 
String authorization = "authorization_example"; // String | 
String accept = "accept_example"; // String | 
String acceptCharset = "acceptCharset_example"; // String | 
String contentType = "contentType_example"; // String | 
String telstraApiVersion = "telstraApiVersion_example"; // String | 
try {
    InlineResponse201 result = apiInstance.messagesReport(body, contentLanguage, authorization, accept, acceptCharset, contentType, telstraApiVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApi#messagesReport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ReportsMessagesBody**](ReportsMessagesBody.md)|  |
 **contentLanguage** | **String**|  |
 **authorization** | **String**|  |
 **accept** | **String**|  |
 **acceptCharset** | **String**|  |
 **contentType** | **String**|  |
 **telstraApiVersion** | **String**|  | [optional]

### Return type

[**InlineResponse201**](GetReports201Response.md)

### Authorization

[bearer_auth](../README.md#bearer_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

