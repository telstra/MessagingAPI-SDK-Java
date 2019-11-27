/*
 * Telstra Messaging API
 *  # Introduction  <table><tbody><tr><td class = 'into_api' style='border:none;padding:0 0 0 0'><p>Send and receive SMS and MMS messages globally using Telstra's enterprise grade Messaging API. It also allows your application to track the delivery status of both sent and received messages. Get your dedicated Australian number, and start sending and receiving messages today.</p></td><td class = 'into_api_logo' style='width: 20%;border:none'><img class = 'api_logo' style='margin: -26px 0 0 0' src = 'https://test-dev.telstra.net/sites/default/files/messagingapi-icon.png'></td></tr></tbody></table>  # Features  The Telstra Messaging API provides the features below.  | Feature | Description | | --- | --- | | `Dedicated Number` | Provision a mobile number for your account to be used as `from` address in the API | | `Send Messages` | Sending SMS or MMS messages | | `Receive Messages` | Telstra will deliver messages sent to a dedicated number or to the `notifyURL` defined by you | | `Broadcast Messages` | Invoke a single API call to send a message to a list of numbers provided in `to` | | `Delivery Status` | Query the delivery status of your messages | | `Callbacks` | Provide a notification URL and Telstra will notify your app when a message status changes | | `Alphanumeric Identifier` | Differentiate yourself by providing an alphanumeric string in `from`. This feature is only available on Telstra Account paid plans and works on domestic, i.e. Australian, destinations only | | `Concatenation` | Send messages up to 1900 characters long and Telstra will automaticaly segment and reassemble them | | `Reply Request` | Create a chat session by associating `messageId` and `to` number to track responses received from a mobile number. We will store this association for 8 days | | `Character set` | Accepts all Unicode characters as part of UTF-8 | | `Bounce-back response` | See if your SMS hits an unreachable or unallocated number (Australia Only) | | `Queuing` | Messaging API will automatically queue and deliver each message at a compliant rate. | | `Emoji Encoding` | The API supports the encoding of the full range of emojis in the Basic Multilingual Plane. Support for emojis in the Supplementary Planes include those in the U+1F600 to U+1F6FF block. Emojis in the reply messages will be in their UTF-8 format |  ## Delivery Status: Notification/Callbacks vs Polling  The API provides two methods to confirm that a message has been delivered to the destination.  1. When you send a message there is an opportunity to specify a `notifyURL`. Once the message has been delivered, the API will make a call to this URL to advise of the message status. 2. If you do not specify a URL you can always call the `GET /status` API to get the status of the message.  # Getting Access to the API  1. Register at [https://dev.telstra.com](https://dev.telstra.com). 2. After registration, login to [https://dev.telstra.com](https://dev.telstra.com) and navigate to the **My apps** page. 3. Create your application by clicking the **Add new app** button 4. Select **API Free Trial** Product when configuring your application. This Product includes the Telstra Messaging API as well as other free trial APIs. Your application will be approved automatically. 5. There is a maximum of 1000 free messages per developer. Additional messages and features can be purchased from [https://dev.telstra.com](https://dev.telstra.com). 6. Note your `Client key` and `Client secret` as these will be needed to provision a number for your application and for authentication.  Now head over to **Getting Started** where you can find a postman collection as well as some links to sample apps and SDKs to get you started.  Happy Messaging!  # Frequently Asked Questions  **Q: Is creating a subscription via the Provisioning call a required step?**  A. Yes. You will only be able to start sending messages if you have a provisioned dedicated number. Use Provisioning to create a dedicated number subscription, or renew your dedicated number if it has expired.  **Q: When trying to send an SMS I receive a `400 Bad Request` response. How can I fix this?**  A. You need to make sure you have a provisioned dedicated number before you can send an SMS. If you do not have a provisioned dedicated number and you try to send a message via the API, you will get the error below in the response:  <pre><code class=\"language-sh\">{   \"status\":\"400\",   \"code\":\"DELIVERY-IMPOSSIBLE\",   \"message\":\"Invalid \\'from\\' address specified\" }</code></pre>  Use Provisioning to create a dedicated number subscription, or renew your dedicated number if it has expired.  **Q: How long does my dedicated number stay active for?**  A. When you provision a dedicated number, by default it will be active for 30 days. You can use the `activeDays` parameter during the provisioning call to increment or decrement the number of days your dedicated number will remain active.  Note that Free Trial apps will have 30 days as the maximum `activeDays` they can add to their provisioned number. If the Provisioning call is made several times within that 30-Day period, it will return the `expiryDate` in the Unix format and will not add any activeDays until after that `expiryDate`.  **Q: Can I send a broadcast message using the Telstra Messaging API?**  A. Yes. Recipient numbers can be in the form of an array of strings if a broadcast message needs to be sent, allowing you to send to multiple mobile numbers in one API call.   A sample request body for this will be: `{\"to\":[\"+61412345678\",\"+61487654321\"],\"body\":\"Test Message\"}`  **Q: How many recipient numbers can I send a broadcast message to at one time?**  A. The API currently supports up to 10 recipient numbers in the `\"to\"` array.  **Q: Can I send SMS and MMS to all countries?**  A. You can send SMS and MMS to the countries in [this list](https://raw.githubusercontent.com/telstra/MessagingAPI-v2/master/docs/Telstra_Messaging_API_Country_Codes.csv), provided the destination network supports delivery. Messages CANNOT be sent to countries which are subject to global sanctions namely: Burma, Côte d'Ivoire, Cuba, Iran, North Korea, Syria.  **Q: Can I use `Alphanumeric Identifier` from my paid plan via credit card?**  A. `Alphanumeric Identifier` is only available on Telstra Account paid plans, not through credit card paid plans.  **Q: What is the maximum sized MMS that I can send?**  A. This will depend on the carrier that will receive the MMS. For Telstra it's up to 2MB,  Optus up to 1.5MB and Vodafone only allows up to 500kB. You will need to check with international carriers for thier MMS size limits.  **Q: How is the size of an MMS calculated?**  A. Images are scaled up to approximately 4/3 when base64 encoded. Additionally, there is approximately 200 bytes of overhead on each MMS. Assuming the maximum MMS that can be sent on Telstra’s network is 2MB, then the maximum image size that can be sent will be approximately 1.378MB (1.378 x 1.34 + 200, without SOAP encapsulation).  **Q: How is an MMS classified as Small or Large?**  A. MMSes with numberSegments below 600 are classed as Small whereas those that are bigger than 600 are classed as Large. They will be charged accordingly.  **Q: Are SMILs supported by the Messaging API?**  A. While there will be no error if you send an MMS with a SMIL presentation, the actual layout or sequence defined in the SMIL may not display as expected because most of the new smartphone devices ignore the SMIL presentation layer. SMIL was used in feature phones which had limited capability and SMIL allowed a *powerpoint type* presentation to be provided. Smartphones now have the capability to display video which is the better option for presentations. It is recommended that MMS messages should just drop the SMIL.  **Q: How do I assign a delivery notification or callback URL?**  A. You can assign a delivery notification or callback URL by adding the `notifyURL` parameter in the body of the request when you send a message. Once the message has been delivered, a notification will then be posted to this callback URL.  **Q: Sometimes I am missing delivery receipts, why is this happening?**  A: Telstra can guarantee delivery receipts are provided for any mobile service connected on Telstra's network so long as the destination handset is able to receive SMS or MMS messages. For other carriers, although messages will be delivered to valid handsets on those carriers, they do not have an obligation to provide delivery receipts back to Telstra.  **Q: What is the difference between the `notifyURL` parameter in the Provisoning call versus the `notifyURL` parameter in the Send Message call?**  A. The `notifyURL` in the Provisoning call will be the URL where replies to the provisioned number will be posted. On the other hand, the `notifyURL` in the Send Message call will be the URL where the delivery notification will be posted, e.g. when an SMS has already been delivered to the recipient.  **Q: Is there a specific format for the `notifyURL` parameter?**  A. The `notifyURL` should be a complete URL address which includes the protocol identifier (e.g. `https://`). It should also have a forward slash at the end if it is just a domain (e.g. http://www.example.com/).  # Getting Started  Below are the steps to get started with the Telstra Messaging API.   1. Generate an OAuth2 token using your `Client key` and `Client secret`.   2. Use the Provisioning call to create a subscription and receive a dedicated number.   3. Send a message to a specific mobile number.  ## Run in Postman <a href=\"https://app.getpostman.com/run-collection/44f2a97ae4c9689ce53e#?env%5BMessaging%20API%20Environment%5D=W3sidmFsdWUiOiJ0YXBpLnRlbHN0cmEuY29tIiwia2V5IjoiaG9zdCIsImVuYWJsZWQiOnRydWV9LHsidmFsdWUiOiIiLCJrZXkiOiJjbGllbnRfaWQiLCJlbmFibGVkIjp0cnVlfSx7InZhbHVlIjoiIiwia2V5IjoiY2xpZW50X3NlY3JldCIsImVuYWJsZWQiOnRydWV9LHsidmFsdWUiOm51bGwsImtleSI6ImFjY2Vzc190b2tlbiIsImVuYWJsZWQiOnRydWV9LHsidmFsdWUiOiIiLCJrZXkiOiJtZXNzYWdlX2lkIiwiZW5hYmxlZCI6dHJ1ZX1d\"><img src=\"https://run.pstmn.io/button.svg\" alt=\"Run in Postman\"/></a>  ## Sample Apps   - [Perl Sample App](https://github.com/telstra/MessagingAPI-perl-sample-app)   - [Happy Chat App](https://github.com/telstra/messaging-sample-code-happy-chat)   - [PHP Sample App](https://github.com/developersteve/telstra-messaging-php)  ## SDK Repos   - [Messaging API - PHP SDK](https://github.com/telstra/MessagingAPI-SDK-php)   - [Messaging API - Python SDK](https://github.com/telstra/MessagingAPI-SDK-python)   - [Messaging API - Ruby SDK](https://github.com/telstra/MessagingAPI-SDK-ruby)   - [Messaging API - NodeJS SDK](https://github.com/telstra/MessagingAPI-SDK-node)   - [Messaging API - .Net2 SDK](https://github.com/telstra/MessagingAPI-SDK-dotnet)   - [Messaging API - Java SDK](https://github.com/telstra/MessagingAPI-SDK-Java)  ## Blog Posts For more information on the Messaging API, you can read these blog posts: - [Callbacks Part 1](https://dev.telstra.com/content/understanding-messaging-api-callbacks-part-1) - [Callbacks Part 2](https://dev.telstra.com/content/understanding-messaging-api-callbacks-part-2) 
 *
 * The version of the OpenAPI document: 2.2.9
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.telstra.messaging;

import com.telstra.ApiCallback;
import com.telstra.ApiClient;
import com.telstra.ApiException;
import com.telstra.ApiResponse;
import com.telstra.Configuration;
import com.telstra.Pair;
import com.telstra.ProgressRequestBody;
import com.telstra.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.telstra.messaging.GetMmsResponse;
import com.telstra.messaging.HealthCheckResponse;
import com.telstra.messaging.InboundPollResponse;
import com.telstra.messaging.MessageSentResponseMms;
import com.telstra.messaging.MessageSentResponseSms;
import com.telstra.messaging.OutboundPollResponse;
import com.telstra.messaging.SendMmsRequest;
import com.telstra.messaging.SendSMSRequest;
import com.telstra.messaging.SendSmsMultiRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagingApi {
    private ApiClient localVarApiClient;

    public MessagingApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MessagingApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for getMMSStatus
     * @param messageid Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/mms  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist OLD-NONEXISTANT-MESSAGE-ID RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getMMSStatusCall(String messageid, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/messages/mms/{messageid}/status"
            .replaceAll("\\{" + "messageid" + "\\}", localVarApiClient.escapeString(messageid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "auth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getMMSStatusValidateBeforeCall(String messageid, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'messageid' is set
        if (messageid == null) {
            throw new ApiException("Missing the required parameter 'messageid' when calling getMMSStatus(Async)");
        }
        

        okhttp3.Call localVarCall = getMMSStatusCall(messageid, _callback);
        return localVarCall;

    }

    /**
     * Get MMS Status
     * Get MMS Status
     * @param messageid Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/mms  (required)
     * @return List&lt;OutboundPollResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist OLD-NONEXISTANT-MESSAGE-ID RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public List<OutboundPollResponse> getMMSStatus(String messageid) throws ApiException {
        ApiResponse<List<OutboundPollResponse>> localVarResp = getMMSStatusWithHttpInfo(messageid);
        return localVarResp.getData();
    }

    /**
     * Get MMS Status
     * Get MMS Status
     * @param messageid Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/mms  (required)
     * @return ApiResponse&lt;List&lt;OutboundPollResponse&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist OLD-NONEXISTANT-MESSAGE-ID RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<OutboundPollResponse>> getMMSStatusWithHttpInfo(String messageid) throws ApiException {
        okhttp3.Call localVarCall = getMMSStatusValidateBeforeCall(messageid, null);
        Type localVarReturnType = new TypeToken<List<OutboundPollResponse>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get MMS Status (asynchronously)
     * Get MMS Status
     * @param messageid Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/mms  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist OLD-NONEXISTANT-MESSAGE-ID RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getMMSStatusAsync(String messageid, final ApiCallback<List<OutboundPollResponse>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getMMSStatusValidateBeforeCall(messageid, _callback);
        Type localVarReturnType = new TypeToken<List<OutboundPollResponse>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getSMSStatus
     * @param messageId Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/sms.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission  SpikeArrest-The API call rate limit has been exceeded </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist  OLD-NONEXISTANT-MESSAGE-ID  RESOURCE-NOT-FOUND </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getSMSStatusCall(String messageId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/messages/sms/{messageId}/status"
            .replaceAll("\\{" + "messageId" + "\\}", localVarApiClient.escapeString(messageId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "auth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getSMSStatusValidateBeforeCall(String messageId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'messageId' is set
        if (messageId == null) {
            throw new ApiException("Missing the required parameter 'messageId' when calling getSMSStatus(Async)");
        }
        

        okhttp3.Call localVarCall = getSMSStatusCall(messageId, _callback);
        return localVarCall;

    }

    /**
     * Get SMS Status
     * If no notification URL has been specified, it is possible to poll for the message status.  Note that the &#x60;MessageId&#x60; that appears in the URL must be URL encoded. Just copying the &#x60;MessageId&#x60; as it was supplied when submitting the message may not work.  # SMS Status with Notification URL  When a message has reached its final state, the API will send a POST to the URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{     \&quot;to\&quot;: \&quot;+61418123456\&quot;,     \&quot;sentTimestamp\&quot;: \&quot;2017-03-17T10:05:22+10:00\&quot;,     \&quot;receivedTimestamp\&quot;: \&quot;2017-03-17T10:05:23+10:00\&quot;,     \&quot;messageId\&quot;: \&quot;1234567890ABCDEFGHIJKLNOPQRSTUVW\&quot;,     \&quot;deliveryStatus\&quot;: \&quot;DELIVRD\&quot;   } &lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- | ---| | &#x60;to&#x60; |  The number the message was sent to. | | &#x60;receivedTimestamp&#x60; | Time the message was sent to the API. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;deliveryStatus&#x60; | The final state of the message. | | &#x60;messageId&#x60; | The same reference that was returned when the original message was sent.| | &#x60;receivedTimestamp&#x60; | Time the message was sent to the API.|  Upon receiving this call it is expected that your servers will give a 204 (No Content) response. 
     * @param messageId Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/sms.  (required)
     * @return List&lt;OutboundPollResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission  SpikeArrest-The API call rate limit has been exceeded </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist  OLD-NONEXISTANT-MESSAGE-ID  RESOURCE-NOT-FOUND </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public List<OutboundPollResponse> getSMSStatus(String messageId) throws ApiException {
        ApiResponse<List<OutboundPollResponse>> localVarResp = getSMSStatusWithHttpInfo(messageId);
        return localVarResp.getData();
    }

    /**
     * Get SMS Status
     * If no notification URL has been specified, it is possible to poll for the message status.  Note that the &#x60;MessageId&#x60; that appears in the URL must be URL encoded. Just copying the &#x60;MessageId&#x60; as it was supplied when submitting the message may not work.  # SMS Status with Notification URL  When a message has reached its final state, the API will send a POST to the URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{     \&quot;to\&quot;: \&quot;+61418123456\&quot;,     \&quot;sentTimestamp\&quot;: \&quot;2017-03-17T10:05:22+10:00\&quot;,     \&quot;receivedTimestamp\&quot;: \&quot;2017-03-17T10:05:23+10:00\&quot;,     \&quot;messageId\&quot;: \&quot;1234567890ABCDEFGHIJKLNOPQRSTUVW\&quot;,     \&quot;deliveryStatus\&quot;: \&quot;DELIVRD\&quot;   } &lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- | ---| | &#x60;to&#x60; |  The number the message was sent to. | | &#x60;receivedTimestamp&#x60; | Time the message was sent to the API. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;deliveryStatus&#x60; | The final state of the message. | | &#x60;messageId&#x60; | The same reference that was returned when the original message was sent.| | &#x60;receivedTimestamp&#x60; | Time the message was sent to the API.|  Upon receiving this call it is expected that your servers will give a 204 (No Content) response. 
     * @param messageId Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/sms.  (required)
     * @return ApiResponse&lt;List&lt;OutboundPollResponse&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission  SpikeArrest-The API call rate limit has been exceeded </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist  OLD-NONEXISTANT-MESSAGE-ID  RESOURCE-NOT-FOUND </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<OutboundPollResponse>> getSMSStatusWithHttpInfo(String messageId) throws ApiException {
        okhttp3.Call localVarCall = getSMSStatusValidateBeforeCall(messageId, null);
        Type localVarReturnType = new TypeToken<List<OutboundPollResponse>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get SMS Status (asynchronously)
     * If no notification URL has been specified, it is possible to poll for the message status.  Note that the &#x60;MessageId&#x60; that appears in the URL must be URL encoded. Just copying the &#x60;MessageId&#x60; as it was supplied when submitting the message may not work.  # SMS Status with Notification URL  When a message has reached its final state, the API will send a POST to the URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{     \&quot;to\&quot;: \&quot;+61418123456\&quot;,     \&quot;sentTimestamp\&quot;: \&quot;2017-03-17T10:05:22+10:00\&quot;,     \&quot;receivedTimestamp\&quot;: \&quot;2017-03-17T10:05:23+10:00\&quot;,     \&quot;messageId\&quot;: \&quot;1234567890ABCDEFGHIJKLNOPQRSTUVW\&quot;,     \&quot;deliveryStatus\&quot;: \&quot;DELIVRD\&quot;   } &lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- | ---| | &#x60;to&#x60; |  The number the message was sent to. | | &#x60;receivedTimestamp&#x60; | Time the message was sent to the API. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;deliveryStatus&#x60; | The final state of the message. | | &#x60;messageId&#x60; | The same reference that was returned when the original message was sent.| | &#x60;receivedTimestamp&#x60; | Time the message was sent to the API.|  Upon receiving this call it is expected that your servers will give a 204 (No Content) response. 
     * @param messageId Unique identifier of a message - it is the value returned from a previous POST call to https://tapi.telstra.com/v2/messages/sms.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters  NOT-PROVISIONED  Request flagged as containing suspicious content </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission  SpikeArrest-The API call rate limit has been exceeded </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist  OLD-NONEXISTANT-MESSAGE-ID  RESOURCE-NOT-FOUND </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getSMSStatusAsync(String messageId, final ApiCallback<List<OutboundPollResponse>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getSMSStatusValidateBeforeCall(messageId, _callback);
        Type localVarReturnType = new TypeToken<List<OutboundPollResponse>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for mMSHealthCheck
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call mMSHealthCheckCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/messages/mms/heathcheck";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call mMSHealthCheckValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = mMSHealthCheckCall(_callback);
        return localVarCall;

    }

    /**
     * MMS Health Check
     * Determine whether the MMS service is up or down. 
     * @return HealthCheckResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public HealthCheckResponse mMSHealthCheck() throws ApiException {
        ApiResponse<HealthCheckResponse> localVarResp = mMSHealthCheckWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * MMS Health Check
     * Determine whether the MMS service is up or down. 
     * @return ApiResponse&lt;HealthCheckResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<HealthCheckResponse> mMSHealthCheckWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = mMSHealthCheckValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<HealthCheckResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * MMS Health Check (asynchronously)
     * Determine whether the MMS service is up or down. 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call mMSHealthCheckAsync(final ApiCallback<HealthCheckResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = mMSHealthCheckValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<HealthCheckResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for retrieveMMSReplies
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call retrieveMMSRepliesCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/messages/mms";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "auth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call retrieveMMSRepliesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = retrieveMMSRepliesCall(_callback);
        return localVarCall;

    }

    /**
     * Retrieve MMS Replies
     * Messages are retrieved one at a time, starting with the earliest reply.  If the subscription has a &#x60;notifyURL&#x60;, reply messages will be logged there instead, i.e. &#x60;GET&#x60; and reply &#x60;notifyURL&#x60; are exclusive.  # MMS Reply with Notification URL  When a reply is received, the API will send a POST to the subscription URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;: \&quot;+61418123456\&quot;,   \&quot;from\&quot;: \&quot;+61421987654\&quot;,   \&quot;sentTimestamp\&quot;: \&quot;2018-03-23T12:15:45+10:00\&quot;,   \&quot;messageId\&quot;: \&quot;XFRO1ApiA0000000111\&quot;,   \&quot;subject\&quot;: \&quot;Foo\&quot;,   \&quot;envelope\&quot;: \&quot;string\&quot;,   \&quot;MMSContent\&quot;:     [       {         \&quot;type\&quot;: \&quot;text/plain\&quot;,         \&quot;filename\&quot;: \&quot;text_1.txt\&quot;,         \&quot;payload\&quot;: \&quot;string\&quot;       },       {         \&quot;type\&quot;: \&quot;image/jpeg\&quot;,         \&quot;filename\&quot;: \&quot;sample.jpeg\&quot;,         \&quot;payload\&quot;: \&quot;string\&quot;       }     ] }&lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- | --- | | &#x60;to&#x60; |The number the message was sent to. | | &#x60;from&#x60; | The number the message was sent from. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;messageId&#x60; | Message Id assigned by the MMSC | | &#x60;subject&#x60; | The subject assigned to the message. | | &#x60;envelope&#x60; | Information about about terminal type and originating operator. | | &#x60;MMSContent&#x60; | An array of the actual content of the reply message. | | &#x60;type&#x60; | The content type of the message. | | &#x60;filename&#x60; | The filename for the message content. | | &#x60;payload&#x60; | The content of the message. | 
     * @return GetMmsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public GetMmsResponse retrieveMMSReplies() throws ApiException {
        ApiResponse<GetMmsResponse> localVarResp = retrieveMMSRepliesWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Retrieve MMS Replies
     * Messages are retrieved one at a time, starting with the earliest reply.  If the subscription has a &#x60;notifyURL&#x60;, reply messages will be logged there instead, i.e. &#x60;GET&#x60; and reply &#x60;notifyURL&#x60; are exclusive.  # MMS Reply with Notification URL  When a reply is received, the API will send a POST to the subscription URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;: \&quot;+61418123456\&quot;,   \&quot;from\&quot;: \&quot;+61421987654\&quot;,   \&quot;sentTimestamp\&quot;: \&quot;2018-03-23T12:15:45+10:00\&quot;,   \&quot;messageId\&quot;: \&quot;XFRO1ApiA0000000111\&quot;,   \&quot;subject\&quot;: \&quot;Foo\&quot;,   \&quot;envelope\&quot;: \&quot;string\&quot;,   \&quot;MMSContent\&quot;:     [       {         \&quot;type\&quot;: \&quot;text/plain\&quot;,         \&quot;filename\&quot;: \&quot;text_1.txt\&quot;,         \&quot;payload\&quot;: \&quot;string\&quot;       },       {         \&quot;type\&quot;: \&quot;image/jpeg\&quot;,         \&quot;filename\&quot;: \&quot;sample.jpeg\&quot;,         \&quot;payload\&quot;: \&quot;string\&quot;       }     ] }&lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- | --- | | &#x60;to&#x60; |The number the message was sent to. | | &#x60;from&#x60; | The number the message was sent from. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;messageId&#x60; | Message Id assigned by the MMSC | | &#x60;subject&#x60; | The subject assigned to the message. | | &#x60;envelope&#x60; | Information about about terminal type and originating operator. | | &#x60;MMSContent&#x60; | An array of the actual content of the reply message. | | &#x60;type&#x60; | The content type of the message. | | &#x60;filename&#x60; | The filename for the message content. | | &#x60;payload&#x60; | The content of the message. | 
     * @return ApiResponse&lt;GetMmsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetMmsResponse> retrieveMMSRepliesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = retrieveMMSRepliesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<GetMmsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve MMS Replies (asynchronously)
     * Messages are retrieved one at a time, starting with the earliest reply.  If the subscription has a &#x60;notifyURL&#x60;, reply messages will be logged there instead, i.e. &#x60;GET&#x60; and reply &#x60;notifyURL&#x60; are exclusive.  # MMS Reply with Notification URL  When a reply is received, the API will send a POST to the subscription URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;: \&quot;+61418123456\&quot;,   \&quot;from\&quot;: \&quot;+61421987654\&quot;,   \&quot;sentTimestamp\&quot;: \&quot;2018-03-23T12:15:45+10:00\&quot;,   \&quot;messageId\&quot;: \&quot;XFRO1ApiA0000000111\&quot;,   \&quot;subject\&quot;: \&quot;Foo\&quot;,   \&quot;envelope\&quot;: \&quot;string\&quot;,   \&quot;MMSContent\&quot;:     [       {         \&quot;type\&quot;: \&quot;text/plain\&quot;,         \&quot;filename\&quot;: \&quot;text_1.txt\&quot;,         \&quot;payload\&quot;: \&quot;string\&quot;       },       {         \&quot;type\&quot;: \&quot;image/jpeg\&quot;,         \&quot;filename\&quot;: \&quot;sample.jpeg\&quot;,         \&quot;payload\&quot;: \&quot;string\&quot;       }     ] }&lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- | --- | | &#x60;to&#x60; |The number the message was sent to. | | &#x60;from&#x60; | The number the message was sent from. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;messageId&#x60; | Message Id assigned by the MMSC | | &#x60;subject&#x60; | The subject assigned to the message. | | &#x60;envelope&#x60; | Information about about terminal type and originating operator. | | &#x60;MMSContent&#x60; | An array of the actual content of the reply message. | | &#x60;type&#x60; | The content type of the message. | | &#x60;filename&#x60; | The filename for the message content. | | &#x60;payload&#x60; | The content of the message. | 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call retrieveMMSRepliesAsync(final ApiCallback<GetMmsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = retrieveMMSRepliesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<GetMmsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for retrieveSMSReplies
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call retrieveSMSRepliesCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/messages/sms";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "auth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call retrieveSMSRepliesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = retrieveSMSRepliesCall(_callback);
        return localVarCall;

    }

    /**
     * Retrieve SMS Replies
     * Messages are retrieved one at a time, starting with the earliest reply.  The API supports the encoding of emojis in the reply message. The emojis will be in their UTF-8 format.  If the subscription has a &#x60;notifyURL&#x60;, reply messages will be logged there instead.  # SMS Reply with Notification URL  When a reply is received, the API will send a POST to the subscription URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;:\&quot;+61472880123\&quot;,   \&quot;from\&quot;:\&quot;+61412345678\&quot;,   \&quot;body\&quot;:\&quot;Foo4\&quot;,   \&quot;sentTimestamp\&quot;:\&quot;2018-04-20T14:24:35\&quot;,   \&quot;messageId\&quot;:\&quot;DMASApiA0000000146\&quot; }&lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- |--- | | &#x60;to&#x60; | The number the message was sent to. | | &#x60;from&#x60; | The number the message was sent from. | | &#x60;body&#x60; | The content of the SMS response. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;messageId&#x60; | The ID assigned to the message. | 
     * @return InboundPollResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public InboundPollResponse retrieveSMSReplies() throws ApiException {
        ApiResponse<InboundPollResponse> localVarResp = retrieveSMSRepliesWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Retrieve SMS Replies
     * Messages are retrieved one at a time, starting with the earliest reply.  The API supports the encoding of emojis in the reply message. The emojis will be in their UTF-8 format.  If the subscription has a &#x60;notifyURL&#x60;, reply messages will be logged there instead.  # SMS Reply with Notification URL  When a reply is received, the API will send a POST to the subscription URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;:\&quot;+61472880123\&quot;,   \&quot;from\&quot;:\&quot;+61412345678\&quot;,   \&quot;body\&quot;:\&quot;Foo4\&quot;,   \&quot;sentTimestamp\&quot;:\&quot;2018-04-20T14:24:35\&quot;,   \&quot;messageId\&quot;:\&quot;DMASApiA0000000146\&quot; }&lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- |--- | | &#x60;to&#x60; | The number the message was sent to. | | &#x60;from&#x60; | The number the message was sent from. | | &#x60;body&#x60; | The content of the SMS response. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;messageId&#x60; | The ID assigned to the message. | 
     * @return ApiResponse&lt;InboundPollResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InboundPollResponse> retrieveSMSRepliesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = retrieveSMSRepliesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<InboundPollResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve SMS Replies (asynchronously)
     * Messages are retrieved one at a time, starting with the earliest reply.  The API supports the encoding of emojis in the reply message. The emojis will be in their UTF-8 format.  If the subscription has a &#x60;notifyURL&#x60;, reply messages will be logged there instead.  # SMS Reply with Notification URL  When a reply is received, the API will send a POST to the subscription URL that has been previously specified.  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;:\&quot;+61472880123\&quot;,   \&quot;from\&quot;:\&quot;+61412345678\&quot;,   \&quot;body\&quot;:\&quot;Foo4\&quot;,   \&quot;sentTimestamp\&quot;:\&quot;2018-04-20T14:24:35\&quot;,   \&quot;messageId\&quot;:\&quot;DMASApiA0000000146\&quot; }&lt;/code&gt;&lt;/pre&gt;  The fields are:  | Field | Description | | --- |--- | | &#x60;to&#x60; | The number the message was sent to. | | &#x60;from&#x60; | The number the message was sent from. | | &#x60;body&#x60; | The content of the SMS response. | | &#x60;sentTimestamp&#x60; | Time handling of the message ended. | | &#x60;messageId&#x60; | The ID assigned to the message. | 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call retrieveSMSRepliesAsync(final ApiCallback<InboundPollResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = retrieveSMSRepliesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<InboundPollResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for sMSHealthCheck
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sMSHealthCheckCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/messages/sms/heathcheck";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call sMSHealthCheckValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = sMSHealthCheckCall(_callback);
        return localVarCall;

    }

    /**
     * SMS Health Check
     * Determine whether the SMS service is up or down. 
     * @return HealthCheckResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public HealthCheckResponse sMSHealthCheck() throws ApiException {
        ApiResponse<HealthCheckResponse> localVarResp = sMSHealthCheckWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * SMS Health Check
     * Determine whether the SMS service is up or down. 
     * @return ApiResponse&lt;HealthCheckResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<HealthCheckResponse> sMSHealthCheckWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = sMSHealthCheckValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<HealthCheckResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * SMS Health Check (asynchronously)
     * Determine whether the SMS service is up or down. 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sMSHealthCheckAsync(final ApiCallback<HealthCheckResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = sMSHealthCheckValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<HealthCheckResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for sMSMulti
     * @param payload A JSON payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters * DR-NOTIFY-URL-MISSING : when receiptOff is missing or receiptOff&#x3D;false but notifyURL is missing  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sMSMultiCall(SendSmsMultiRequest payload, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = payload;

        // create path and map variables
        String localVarPath = "/messages/sms/multi";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call sMSMultiValidateBeforeCall(SendSmsMultiRequest payload, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'payload' is set
        if (payload == null) {
            throw new ApiException("Missing the required parameter 'payload' when calling sMSMulti(Async)");
        }
        

        okhttp3.Call localVarCall = sMSMultiCall(payload, _callback);
        return localVarCall;

    }

    /**
     * Send Multiple SMS
     * Send multiple SMS in one API call. 
     * @param payload A JSON payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  (required)
     * @return MessageSentResponseSms
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters * DR-NOTIFY-URL-MISSING : when receiptOff is missing or receiptOff&#x3D;false but notifyURL is missing  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public MessageSentResponseSms sMSMulti(SendSmsMultiRequest payload) throws ApiException {
        ApiResponse<MessageSentResponseSms> localVarResp = sMSMultiWithHttpInfo(payload);
        return localVarResp.getData();
    }

    /**
     * Send Multiple SMS
     * Send multiple SMS in one API call. 
     * @param payload A JSON payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  (required)
     * @return ApiResponse&lt;MessageSentResponseSms&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters * DR-NOTIFY-URL-MISSING : when receiptOff is missing or receiptOff&#x3D;false but notifyURL is missing  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<MessageSentResponseSms> sMSMultiWithHttpInfo(SendSmsMultiRequest payload) throws ApiException {
        okhttp3.Call localVarCall = sMSMultiValidateBeforeCall(payload, null);
        Type localVarReturnType = new TypeToken<MessageSentResponseSms>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Send Multiple SMS (asynchronously)
     * Send multiple SMS in one API call. 
     * @param payload A JSON payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters * DR-NOTIFY-URL-MISSING : when receiptOff is missing or receiptOff&#x3D;false but notifyURL is missing  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sMSMultiAsync(SendSmsMultiRequest payload, final ApiCallback<MessageSentResponseSms> _callback) throws ApiException {

        okhttp3.Call localVarCall = sMSMultiValidateBeforeCall(payload, _callback);
        Type localVarReturnType = new TypeToken<MessageSentResponseSms>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for sendMMS
     * @param body A JSON or XML payload containing the recipient&#39;s phone number and MMS message. The recipient number should be in the format &#39;04xxxxxxxx&#39; where x is a digit.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters MMS-TYPE-MISSING MMS-PAYLOAD-MISSING MMS-FILENAME-MISSING DELIVERY-IMPOSSIBLE TO-MSISDN-NOT-VALID SENDER-MISSING DELIVERY-IMPOSSIBLE SUBJECT-TOO-LONG FROM-MSISDN-TOO-LONG TO-MSISDN-TOO-LONG NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sendMMSCall(SendMmsRequest body, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/messages/mms";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "auth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call sendMMSValidateBeforeCall(SendMmsRequest body, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling sendMMS(Async)");
        }
        

        okhttp3.Call localVarCall = sendMMSCall(body, _callback);
        return localVarCall;

    }

    /**
     * Send MMS
     * Send MMS
     * @param body A JSON or XML payload containing the recipient&#39;s phone number and MMS message. The recipient number should be in the format &#39;04xxxxxxxx&#39; where x is a digit.  (required)
     * @return MessageSentResponseMms
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters MMS-TYPE-MISSING MMS-PAYLOAD-MISSING MMS-FILENAME-MISSING DELIVERY-IMPOSSIBLE TO-MSISDN-NOT-VALID SENDER-MISSING DELIVERY-IMPOSSIBLE SUBJECT-TOO-LONG FROM-MSISDN-TOO-LONG TO-MSISDN-TOO-LONG NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public MessageSentResponseMms sendMMS(SendMmsRequest body) throws ApiException {
        ApiResponse<MessageSentResponseMms> localVarResp = sendMMSWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Send MMS
     * Send MMS
     * @param body A JSON or XML payload containing the recipient&#39;s phone number and MMS message. The recipient number should be in the format &#39;04xxxxxxxx&#39; where x is a digit.  (required)
     * @return ApiResponse&lt;MessageSentResponseMms&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters MMS-TYPE-MISSING MMS-PAYLOAD-MISSING MMS-FILENAME-MISSING DELIVERY-IMPOSSIBLE TO-MSISDN-NOT-VALID SENDER-MISSING DELIVERY-IMPOSSIBLE SUBJECT-TOO-LONG FROM-MSISDN-TOO-LONG TO-MSISDN-TOO-LONG NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<MessageSentResponseMms> sendMMSWithHttpInfo(SendMmsRequest body) throws ApiException {
        okhttp3.Call localVarCall = sendMMSValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<MessageSentResponseMms>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Send MMS (asynchronously)
     * Send MMS
     * @param body A JSON or XML payload containing the recipient&#39;s phone number and MMS message. The recipient number should be in the format &#39;04xxxxxxxx&#39; where x is a digit.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters MMS-TYPE-MISSING MMS-PAYLOAD-MISSING MMS-FILENAME-MISSING DELIVERY-IMPOSSIBLE TO-MSISDN-NOT-VALID SENDER-MISSING DELIVERY-IMPOSSIBLE SUBJECT-TOO-LONG FROM-MSISDN-TOO-LONG TO-MSISDN-TOO-LONG NOT-PROVISIONED Request flagged as containing suspicious content  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint : An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sendMMSAsync(SendMmsRequest body, final ApiCallback<MessageSentResponseMms> _callback) throws ApiException {

        okhttp3.Call localVarCall = sendMMSValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<MessageSentResponseMms>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for sendSMS
     * @param payload A JSON or XML payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters * TO-MSISDN-NOT-VALID * SENDER-MISSING * DELIVERY-IMPOSSIBLE * FROM-MSISDN-TOO-LONG * BODY-TOO-LONG * BODY-MISSING * TO-MSISDN-TOO-LONG * TECH-ERR * BODY-NOT-VALID * NOT-PROVISIONED * Request flagged as containing suspicious content. * Invalid &#39;from&#39; address specified.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission.  SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint :  An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sendSMSCall(SendSMSRequest payload, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = payload;

        // create path and map variables
        String localVarPath = "/messages/sms";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "auth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call sendSMSValidateBeforeCall(SendSMSRequest payload, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'payload' is set
        if (payload == null) {
            throw new ApiException("Missing the required parameter 'payload' when calling sendSMS(Async)");
        }
        

        okhttp3.Call localVarCall = sendSMSCall(payload, _callback);
        return localVarCall;

    }

    /**
     * Send SMS
     * Send an SMS Message to a single or multiple mobile number/s. 
     * @param payload A JSON or XML payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  (required)
     * @return MessageSentResponseSms
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters * TO-MSISDN-NOT-VALID * SENDER-MISSING * DELIVERY-IMPOSSIBLE * FROM-MSISDN-TOO-LONG * BODY-TOO-LONG * BODY-MISSING * TO-MSISDN-TOO-LONG * TECH-ERR * BODY-NOT-VALID * NOT-PROVISIONED * Request flagged as containing suspicious content. * Invalid &#39;from&#39; address specified.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission.  SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint :  An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public MessageSentResponseSms sendSMS(SendSMSRequest payload) throws ApiException {
        ApiResponse<MessageSentResponseSms> localVarResp = sendSMSWithHttpInfo(payload);
        return localVarResp.getData();
    }

    /**
     * Send SMS
     * Send an SMS Message to a single or multiple mobile number/s. 
     * @param payload A JSON or XML payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  (required)
     * @return ApiResponse&lt;MessageSentResponseSms&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters * TO-MSISDN-NOT-VALID * SENDER-MISSING * DELIVERY-IMPOSSIBLE * FROM-MSISDN-TOO-LONG * BODY-TOO-LONG * BODY-MISSING * TO-MSISDN-TOO-LONG * TECH-ERR * BODY-NOT-VALID * NOT-PROVISIONED * Request flagged as containing suspicious content. * Invalid &#39;from&#39; address specified.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission.  SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint :  An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<MessageSentResponseSms> sendSMSWithHttpInfo(SendSMSRequest payload) throws ApiException {
        okhttp3.Call localVarCall = sendSMSValidateBeforeCall(payload, null);
        Type localVarReturnType = new TypeToken<MessageSentResponseSms>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Send SMS (asynchronously)
     * Send an SMS Message to a single or multiple mobile number/s. 
     * @param payload A JSON or XML payload containing the recipient&#39;s phone number and text message. This number can be in international format if preceeded by a &#39;+&#39; or in national format (&#39;04xxxxxxxx&#39;) where x is a digit.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid or missing request parameters * TO-MSISDN-NOT-VALID * SENDER-MISSING * DELIVERY-IMPOSSIBLE * FROM-MSISDN-TOO-LONG * BODY-TOO-LONG * BODY-MISSING * TO-MSISDN-TOO-LONG * TECH-ERR * BODY-NOT-VALID * NOT-PROVISIONED * Request flagged as containing suspicious content. * Invalid &#39;from&#39; address specified.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Invalid access token. Please try with a valid token </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Authorization credentials passed and accepted but account does not have permission.  SpikeArrest-The API call rate limit has been exceeded  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested URI does not exist RESOURCE-NOT-FOUND  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> The requested resource does not support the supplied verb </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> API does not support the requested content type </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> The request is formed correctly, but due to some condition the request cannot be processed e.g. email is required and it is not provided in the request  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Technical error : Unable to route the message to a Target Endpoint :  An error has occurred while processing your request, please refer to API Docs for summary on the issue  </td><td>  -  </td></tr>
        <tr><td> 501 </td><td> The HTTP method being used has not yet been implemented for the requested resource  </td><td>  -  </td></tr>
        <tr><td> 503 </td><td> The service requested is currently unavailable </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An internal error occurred when processing the request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sendSMSAsync(SendSMSRequest payload, final ApiCallback<MessageSentResponseSms> _callback) throws ApiException {

        okhttp3.Call localVarCall = sendSMSValidateBeforeCall(payload, _callback);
        Type localVarReturnType = new TypeToken<MessageSentResponseSms>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
