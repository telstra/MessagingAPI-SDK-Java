# Getting started


The Telstra SMS Messaging API allows your applications to send and receive SMS text messages from Australia's leading network operator.

It also allows your application to track the delivery status of both sent and received SMS messages.


## How to Build

The generated code uses a few Maven dependencies e.g., Jackson, UniRest,
and Apache HttpClient. The reference to these dependencies is already
added in the pom.xml file will be installed automatically. Therefore,
you will need internet access for a successful build.

* In order to open the client library in Eclipse click on ``` File -> Import ```.

![Importing SDK into Eclipse - Step 1](https://apidocs.io/illustration/java?step=import0&workspaceFolder=Telstra%20Messaging%20API-Java&workspaceName=TelstraMessagingAPI&projectName=TelstraMessagingAPILib&rootNamespace=com.telstra.tapi)

* In the import dialog, select ``` Existing Java Project ``` and click ``` Next ```.

![Importing SDK into Eclipse - Step 2](https://apidocs.io/illustration/java?step=import1&workspaceFolder=Telstra%20Messaging%20API-Java&workspaceName=TelstraMessagingAPI&projectName=TelstraMessagingAPILib&rootNamespace=com.telstra.tapi)

* Browse to locate the folder containing the source code. Select the detected location of the project and click ``` Finish ```.

![Importing SDK into Eclipse - Step 3](https://apidocs.io/illustration/java?step=import2&workspaceFolder=Telstra%20Messaging%20API-Java&workspaceName=TelstraMessagingAPI&projectName=TelstraMessagingAPILib&rootNamespace=com.telstra.tapi)

* Upon successful import, the project will be automatically built by Eclipse after automatically resolving the dependencies.

![Importing SDK into Eclipse - Step 4](https://apidocs.io/illustration/java?step=import3&workspaceFolder=Telstra%20Messaging%20API-Java&workspaceName=TelstraMessagingAPI&projectName=TelstraMessagingAPILib&rootNamespace=com.telstra.tapi)

## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| oAuthClientId | OAuth 2 Client ID |
| oAuthClientSecret | OAuth 2 Client Secret |



API client can be initialized as following.

```java
// Configuration parameters and credentials
String oAuthClientId = "oAuthClientId"; // OAuth 2 Client ID
String oAuthClientSecret = "oAuthClientSecret"; // OAuth 2 Client Secret

TelstraMessagingAPIClient client = new TelstraMessagingAPIClient(oAuthClientId, oAuthClientSecret);
```

You must authorize now authorize the client.

### Authorizing your client

This SDK uses *OAuth 2.0 authorization* to authorize the client.

The `authorize()` method will exchange the OAuth client credentials for an *access token*.
The access token is an object containing information for authorizing client requests.

 You must pass the *[scopes](#scopes)* for which you need permission to access.
```java
try {
    client.auth().authorize(scopes);
} catch (Throwable e) {
    // TODO Handle exception
}
```

The client can now make authorized endpoint calls.


### Scopes

Scopes enable your application to only request access to the resources it needs while enabling users to control the amount of access they grant to your application. Available scopes are defined in the `com.telstra.tapi.Models.OAuthScopeEnum` enumeration.

| Scope Name | Description |
| --- | --- |
| `NSMS` | NSMS |

### Storing an access token for reuse

It is recommended that you store the access token for reuse.

```java
// store token
storeAccessToken(com.telstra.tapi.Configuration.oAuthToken);
```

### Creating a client from a stored token

To authorize a client from a stored access token, just set the access token in `Configuration` along with the other configuration parameters before creating the client:

```java
// load token later...
com.telstra.tapi.Configuration.oAuthToken = loadAccessToken();

// Set other configuration, then instantiate client
client = new TelstraMessagingAPIClient();
```

### Complete example

```java
package com.example;

import java.util.LinkedList;
import java.util.List;

import com.telstra.tapi.models.OAuthScopeEnum;

public class Main {
    public Main() {
        // Configuration parameters and credentials
        String oAuthClientId = "oAuthClientId"; // OAuth 2 Client ID
        String oAuthClientSecret = "oAuthClientSecret"; // OAuth 2 Client Secret
        
        TelstraMessagingAPIClient client = new TelstraMessagingAPIClient(oAuthClientId, oAuthClientSecret);

        List<OAuthScopeEnum> scopes = new LinkedList<OAuthScopeEnum>();
        scopes.add(OAuthScopeEnum.NSMS);
        
        try {
            // obtain a new access token
            client.auth().authorize(scopes, null);
        } catch (Throwable e) {
            // TODO Catch auth error
        }
        
        // the client is now authorized; you can use client to make endpoint calls
    }
}
```



# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [ProvisioningController](#provisioning_controller)
* [MessagingController](#messaging_controller)

## <a name="provisioning_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.telstra.tapi.controllers.ProvisioningController") ProvisioningController

### Get singleton instance

The singleton instance of the ``` ProvisioningController ``` class can be accessed from the API Client.

```java
ProvisioningController provisioning = client.getProvisioning();
```

### <a name="delete_subscription_async"></a>![Method: ](https://apidocs.io/img/method.png "com.telstra.tapi.controllers.ProvisioningController.deleteSubscriptionAsync") deleteSubscriptionAsync

> Delete Subscription


```java
void deleteSubscriptionAsync(final APICallBack<Object> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
provisioning.deleteSubscriptionAsync(new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Invalid or missing request parameters |
| 401 | Invalid or no credentials passed in the request |
| 403 | Authorization credentials passed and accepted but account does not have permission |
| 404 | The requested URI does not exist |
| 0 | An internal error occurred when processing the request |



### <a name="create_subscription_async"></a>![Method: ](https://apidocs.io/img/method.png "com.telstra.tapi.controllers.ProvisioningController.createSubscriptionAsync") createSubscriptionAsync

> Create Subscription


```java
void createSubscriptionAsync(
        final ProvisionNumberRequest body,
        final APICallBack<ProvisionNumberResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | A JSON payload containing the required attributes |


#### Example Usage

```java
try {
    ProvisionNumberRequest body = new ProvisionNumberRequest();
    // Invoking the API call with sample inputs
    provisioning.createSubscriptionAsync(body, new APICallBack<ProvisionNumberResponse>() {
        public void onSuccess(HttpContext context, ProvisionNumberResponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Invalid or missing request parameters |
| 401 | Invalid or no credentials passed in the request |
| 403 | Authorization credentials passed and accepted but account does not have permission |
| 404 | The requested URI does not exist |
| 0 | An internal error occurred when processing the request |



### <a name="get_subscription_async"></a>![Method: ](https://apidocs.io/img/method.png "com.telstra.tapi.controllers.ProvisioningController.getSubscriptionAsync") getSubscriptionAsync

> Get Subscription


```java
void getSubscriptionAsync(final APICallBack<ProvisionNumberResponse> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
provisioning.getSubscriptionAsync(new APICallBack<ProvisionNumberResponse>() {
    public void onSuccess(HttpContext context, ProvisionNumberResponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Invalid or missing request parameters |
| 401 | Invalid or no credentials passed in the request |
| 403 | Authorization credentials passed and accepted but account does not have permission |
| 404 | The requested URI does not exist |
| 0 | An internal error occurred when processing the request |



[Back to List of Controllers](#list_of_controllers)

## <a name="messaging_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.telstra.tapi.controllers.MessagingController") MessagingController

### Get singleton instance

The singleton instance of the ``` MessagingController ``` class can be accessed from the API Client.

```java
MessagingController messaging = client.getMessaging();
```

### <a name="retrieve_sms_responses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.telstra.tapi.controllers.MessagingController.retrieveSMSResponsesAsync") retrieveSMSResponsesAsync

> Retrieve SMS Responses


```java
void retrieveSMSResponsesAsync(final APICallBack<InboundPollResponse> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
messaging.retrieveSMSResponsesAsync(new APICallBack<InboundPollResponse>() {
    public void onSuccess(HttpContext context, InboundPollResponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Invalid or missing request parameters |
| 401 | Invalid or no credentials passed in the request |
| 403 | Authorization credentials passed and accepted but account does<br>not have permission |
| 404 | The requested URI does not exist |
| 405 | The requested resource does not support the supplied verb |
| 415 | API does not support the requested content type |
| 422 | The request is formed correctly, but due to some condition<br>the request cannot be processed e.g. email is required and it is not provided<br>in the request |
| 501 | The HTTP method being used has not yet been implemented for<br>the requested resource |
| 503 | The service requested is currently unavailable |
| 0 | An internal error occurred when processing the request |



### <a name="create_send_sms_async"></a>![Method: ](https://apidocs.io/img/method.png "com.telstra.tapi.controllers.MessagingController.createSendSMSAsync") createSendSMSAsync

> Send SMS


```java
void createSendSMSAsync(
        final SendSMSRequest payload,
        final APICallBack<MessageSentResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| payload |  ``` Required ```  | A JSON or XML payload containing the recipient's phone number and text message.

The recipient number should be in the format '04xxxxxxxx' where x is a digit |


#### Example Usage

```java
try {
    SendSMSRequest payload = new SendSMSRequest();
    // Invoking the API call with sample inputs
    messaging.createSendSMSAsync(payload, new APICallBack<MessageSentResponse>() {
        public void onSuccess(HttpContext context, MessageSentResponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Invalid or missing request parameters |
| 401 | Invalid or no credentials passed in the request |
| 403 | Authorization credentials passed and accepted but account does<br>not have permission |
| 404 | The requested URI does not exist |
| 405 | The requested resource does not support the supplied verb |
| 415 | API does not support the requested content type |
| 422 | The request is formed correctly, but due to some condition<br>the request cannot be processed e.g. email is required and it is not provided<br>in the request |
| 501 | The HTTP method being used has not yet been implemented for<br>the requested resource |
| 503 | The service requested is currently unavailable |
| 0 | An internal error occurred when processing the request |



### <a name="get_sms_status_async"></a>![Method: ](https://apidocs.io/img/method.png "com.telstra.tapi.controllers.MessagingController.getSMSStatusAsync") getSMSStatusAsync

> Get SMS Status


```java
void getSMSStatusAsync(
        final String messageId,
        final APICallBack<List<OutboundPollResponse>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| messageId |  ``` Required ```  | Unique identifier of a message - it is the value returned from a previous POST call to https://api.telstra.com/v2/messages/sms |


#### Example Usage

```java
String messageId = "messageId";
// Invoking the API call with sample inputs
messaging.getSMSStatusAsync(messageId, new APICallBack<List<OutboundPollResponse>>() {
    public void onSuccess(HttpContext context, List<OutboundPollResponse> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Invalid or missing request parameters |
| 401 | Invalid or no credentials passed in the request |
| 403 | Authorization credentials passed and accepted but account does<br>not have permission |
| 404 | The requested URI does not exist |
| 405 | The requested resource does not support the supplied verb |
| 415 | API does not support the requested content type |
| 422 | The request is formed correctly, but due to some condition<br>the request cannot be processed e.g. email is required and it is not provided<br>in the request |
| 501 | The HTTP method being used has not yet been implemented for<br>the requested resource |
| 503 | The service requested is currently unavailable |
| 0 | An internal error occurred when processing the request |



### <a name="create_send_mms_async"></a>![Method: ](https://apidocs.io/img/method.png "com.telstra.tapi.controllers.MessagingController.createSendMMSAsync") createSendMMSAsync

> Send MMS


```java
void createSendMMSAsync(
        final SendMMSRequest body,
        final APICallBack<DynamicResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | A JSON or XML payload containing the recipient's phone number
and MMS message.The recipient number should be in the format '04xxxxxxxx'
where x is a digit |


#### Example Usage

```java
try {
    SendMMSRequest body = new SendMMSRequest();
    // Invoking the API call with sample inputs
    messaging.createSendMMSAsync(body, new APICallBack<DynamicResponse>() {
        public void onSuccess(HttpContext context, DynamicResponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Invalid or missing request parameters |
| 401 | Invalid or no credentials passed in the request |
| 403 | Authorization credentials passed and accepted but account does<br>not have permission |
| 404 | The requested URI does not exist |
| 405 | The requested resource does not support the supplied verb |
| 415 | API does not support the requested content type |
| 422 | The request is formed correctly, but due to some condition<br>the request cannot be processed e.g. email is required and it is not provided<br>in the request |
| 501 | The HTTP method being used has not yet been implemented for<br>the requested resource |
| 503 | The service requested is currently unavailable |
| 0 | An internal error occurred when processing the request |



### <a name="get_mms_status_async"></a>![Method: ](https://apidocs.io/img/method.png "com.telstra.tapi.controllers.MessagingController.getMMSStatusAsync") getMMSStatusAsync

> Get MMS Status


```java
void getMMSStatusAsync(
        final String messageid,
        final APICallBack<List<OutboundPollResponse>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| messageid |  ``` Required ```  | Unique identifier of a message - it is the value returned from
a previous POST call to https://api.telstra.com/v2/messages/mms |


#### Example Usage

```java
String messageid = "messageid";
// Invoking the API call with sample inputs
messaging.getMMSStatusAsync(messageid, new APICallBack<List<OutboundPollResponse>>() {
    public void onSuccess(HttpContext context, List<OutboundPollResponse> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Invalid or missing request parameters |
| 401 | Invalid or no credentials passed in the request |
| 403 | Authorization credentials passed and accepted but account does<br>not have permission |
| 404 | The requested URI does not exist |
| 405 | The requested resource does not support the supplied verb |
| 415 | API does not support the requested content type |
| 422 | The request is formed correctly, but due to some condition<br>the request cannot be processed e.g. email is required and it is not provided<br>in the request |
| 501 | The HTTP method being used has not yet been implemented for<br>the requested resource |
| 503 | The service requested is currently unavailable |
| 0 | An internal error occurred when processing the request |



[Back to List of Controllers](#list_of_controllers)



