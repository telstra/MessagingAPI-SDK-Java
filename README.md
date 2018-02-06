# TelstraMessaging

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>Telstra</groupId>
    <artifactId>TelstraMessaging</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "Telstra:TelstraMessaging:1.0.0"
```

### Others

At first generate the JAR by executing:


Then manually install the following JARs:

* target/TelstraMessaging-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.telstra.*;
import com.telstra.auth.*;
import com.telstra.messaging.*;
import com.telstra.messaging.AuthenticationApi;

import java.io.File;
import java.util.*;

public class AuthenticationApiExample {

    public static void main(String[] args) {
        
        AuthenticationApi apiInstance = new AuthenticationApi();
        String clientId = "clientId_example"; // String | 
        String clientSecret = "clientSecret_example"; // String | 
        String grantType = "client_credentials"; // String | 
        try {
            OAuthResponse result = apiInstance.authToken(clientId, clientSecret, grantType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthenticationApi#authToken");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://tapi.telstra.com/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AuthenticationApi* | [**authToken**](docs/AuthenticationApi.md#authToken) | **POST** /oauth/token | Generate authentication token
*MessagingApi* | [**getMMSStatus**](docs/MessagingApi.md#getMMSStatus) | **GET** /messages/mms/{messageid}/status | Get MMS Status
*MessagingApi* | [**getSMSStatus**](docs/MessagingApi.md#getSMSStatus) | **GET** /messages/sms/{messageId}/status | Get SMS Status
*MessagingApi* | [**retrieveSMSResponses**](docs/MessagingApi.md#retrieveSMSResponses) | **GET** /messages/sms | Retrieve SMS Responses
*MessagingApi* | [**sendMMS**](docs/MessagingApi.md#sendMMS) | **POST** /messages/mms | Send MMS
*MessagingApi* | [**sendSMS**](docs/MessagingApi.md#sendSMS) | **POST** /messages/sms | Send SMS
*ProvisioningApi* | [**createSubscription**](docs/ProvisioningApi.md#createSubscription) | **POST** /messages/provisioning/subscriptions | Create Subscription
*ProvisioningApi* | [**deleteSubscription**](docs/ProvisioningApi.md#deleteSubscription) | **DELETE** /messages/provisioning/subscriptions | Delete Subscription
*ProvisioningApi* | [**getSubscription**](docs/ProvisioningApi.md#getSubscription) | **GET** /messages/provisioning/subscriptions | Get Subscription


## Documentation for Models

 - [ErrorError](docs/ErrorError.md)
 - [ErrorErrorError](docs/ErrorErrorError.md)
 - [InboundPollResponse](docs/InboundPollResponse.md)
 - [MMSContent](docs/MMSContent.md)
 - [Message](docs/Message.md)
 - [MessageSentResponse](docs/MessageSentResponse.md)
 - [MessageType](docs/MessageType.md)
 - [OAuthRequest](docs/OAuthRequest.md)
 - [OAuthResponse](docs/OAuthResponse.md)
 - [OutboundPollResponse](docs/OutboundPollResponse.md)
 - [ProvisionNumberRequest](docs/ProvisionNumberRequest.md)
 - [ProvisionNumberResponse](docs/ProvisionNumberResponse.md)
 - [SendMmsRequest](docs/SendMmsRequest.md)
 - [SendSMSRequest](docs/SendSMSRequest.md)
 - [Status](docs/Status.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### auth

- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: 
  - NSMS: NSMS


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



