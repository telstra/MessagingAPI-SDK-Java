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

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * SendSMSRequest
 */

public class SendSMSRequest {
  public static final String SERIALIZED_NAME_TO = "to";
  @SerializedName(SERIALIZED_NAME_TO)
  private String to;

  public static final String SERIALIZED_NAME_BODY = "body";
  @SerializedName(SERIALIZED_NAME_BODY)
  private String body;

  public static final String SERIALIZED_NAME_FROM = "from";
  @SerializedName(SERIALIZED_NAME_FROM)
  private String from;

  public static final String SERIALIZED_NAME_VALIDITY = "validity";
  @SerializedName(SERIALIZED_NAME_VALIDITY)
  private Integer validity;

  public static final String SERIALIZED_NAME_SCHEDULED_DELIVERY = "scheduledDelivery";
  @SerializedName(SERIALIZED_NAME_SCHEDULED_DELIVERY)
  private Integer scheduledDelivery;

  public static final String SERIALIZED_NAME_NOTIFY_U_R_L = "notifyURL";
  @SerializedName(SERIALIZED_NAME_NOTIFY_U_R_L)
  private String notifyURL;

  public static final String SERIALIZED_NAME_REPLY_REQUEST = "replyRequest";
  @SerializedName(SERIALIZED_NAME_REPLY_REQUEST)
  private Boolean replyRequest;

  public static final String SERIALIZED_NAME_PRIORITY = "priority";
  @SerializedName(SERIALIZED_NAME_PRIORITY)
  private Boolean priority;


  public SendSMSRequest to(String to) {
    
    this.to = to;
    return this;
  }

   /**
   * Phone number (in E.164 format) to send the SMS to. This number can be in international format &#x60;\&quot;to\&quot;: \&quot;+61412345678\&quot;&#x60; or in national format. Can be an array of strings if sending to multiple numbers: &#x60;\&quot;to\&quot;:[\&quot;+61412345678\&quot;, \&quot;+61418765432\&quot;]&#x60; 
   * @return to
  **/
  @ApiModelProperty(example = "", required = true, value = "Phone number (in E.164 format) to send the SMS to. This number can be in international format `\"to\": \"+61412345678\"` or in national format. Can be an array of strings if sending to multiple numbers: `\"to\":[\"+61412345678\", \"+61418765432\"]` ")

  public String getTo() {
    return to;
  }


  public void setTo(String to) {
    this.to = to;
  }


  public SendSMSRequest body(String body) {
    
    this.body = body;
    return this;
  }

   /**
   * The text body of the message. Messages longer than 160 characters will be counted as multiple messages. This field contains the message text, this can be up to 1900 (for a single recipient) or 500 (for multiple recipients) UTF-8 characters. As mobile devices rarely support the full range of UTF-8 characters, it is possible that some characters may not be translated correctly by the mobile device 
   * @return body
  **/
  @ApiModelProperty(example = "Test Message", required = true, value = "The text body of the message. Messages longer than 160 characters will be counted as multiple messages. This field contains the message text, this can be up to 1900 (for a single recipient) or 500 (for multiple recipients) UTF-8 characters. As mobile devices rarely support the full range of UTF-8 characters, it is possible that some characters may not be translated correctly by the mobile device ")

  public String getBody() {
    return body;
  }


  public void setBody(String body) {
    this.body = body;
  }


  public SendSMSRequest from(String from) {
    
    this.from = from;
    return this;
  }

   /**
   * This will be the source address that will be displayed on the receiving device. You can set an Alphanumeric sender ID of up to 11 characters that the SMS was sent from. Phone numbers in the &#x60;from&#x60; attribute will be blocked (400-error) to prevent number spoofing.  Most standard ASCII characters are accepted in the alphanumeric &#x60;from&#x60; attribute, however there are some limitations. The following limitations and characters are allowed in the alphanumeric &#x60;from&#x60; attribute; any alphabetic character (e.g. &#x60;abc&#x60;), any number mixed with alphabetic characters (e.g. &#x60;123abc&#x60;), uppercase and lowercase characters (e.g. &#x60;aBc&#x60;), any of the following special characters mixed with alphabetic characters are allowed; &#x60;~!@#$%^&amp;*()~_~+-&#x3D;{}|[];&#39;?,./&#x60; (e.g. &#x60;abc~!@&#x60;), any combination of lowercase, uppercase, numeric or allowed special characters (e.g. &#x60;abc@#123DE&#x60;). All other characters, including spaces and extended ASCII characters, are not allowed (e.g. &#x60;&lt;&gt;:\&quot;\\&#x60;).  If attribute is not present, the service will use the mobile number associated with the application (in E.164 format).  If &#x60;replyRequest&#x60; is set to true, then this field should not be present.  This feature is only available on Telstra Account paid plans, not through Free Trials or credit card paid plans.  *Please note that Alphanumeric sender ID works for domestic, i.e. Australian, destinations only.* 
   * @return from
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Foo_App", value = "This will be the source address that will be displayed on the receiving device. You can set an Alphanumeric sender ID of up to 11 characters that the SMS was sent from. Phone numbers in the `from` attribute will be blocked (400-error) to prevent number spoofing.  Most standard ASCII characters are accepted in the alphanumeric `from` attribute, however there are some limitations. The following limitations and characters are allowed in the alphanumeric `from` attribute; any alphabetic character (e.g. `abc`), any number mixed with alphabetic characters (e.g. `123abc`), uppercase and lowercase characters (e.g. `aBc`), any of the following special characters mixed with alphabetic characters are allowed; `~!@#$%^&*()~_~+-={}|[];'?,./` (e.g. `abc~!@`), any combination of lowercase, uppercase, numeric or allowed special characters (e.g. `abc@#123DE`). All other characters, including spaces and extended ASCII characters, are not allowed (e.g. `<>:\"\\`).  If attribute is not present, the service will use the mobile number associated with the application (in E.164 format).  If `replyRequest` is set to true, then this field should not be present.  This feature is only available on Telstra Account paid plans, not through Free Trials or credit card paid plans.  *Please note that Alphanumeric sender ID works for domestic, i.e. Australian, destinations only.* ")

  public String getFrom() {
    return from;
  }


  public void setFrom(String from) {
    this.from = from;
  }


  public SendSMSRequest validity(Integer validity) {
    
    this.validity = validity;
    return this;
  }

   /**
   * How long the platform should attempt to deliver the message for.  This period is specified in minutes from the message.  Normally if the message cannot be delivered immediately, it will be stored and delivery will be periodically reattempted. The network will attempt to send the message for up to seven days. It is possible to define a period smaller than 7 days by including this parameter and specifying the number of minutes that delivery should be attempted.  e.g.: including &#x60;\&quot;validity\&quot;: 60&#x60; will specify that if a message can&#39;t be delivered within the first 60 minutes then the network should stop. 
   * @return validity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "How long the platform should attempt to deliver the message for.  This period is specified in minutes from the message.  Normally if the message cannot be delivered immediately, it will be stored and delivery will be periodically reattempted. The network will attempt to send the message for up to seven days. It is possible to define a period smaller than 7 days by including this parameter and specifying the number of minutes that delivery should be attempted.  e.g.: including `\"validity\": 60` will specify that if a message can't be delivered within the first 60 minutes then the network should stop. ")

  public Integer getValidity() {
    return validity;
  }


  public void setValidity(Integer validity) {
    this.validity = validity;
  }


  public SendSMSRequest scheduledDelivery(Integer scheduledDelivery) {
    
    this.scheduledDelivery = scheduledDelivery;
    return this;
  }

   /**
   * How long the platform should wait before attempting to send the message - specified in minutes.  e.g.: If &#x60;\&quot;scheduledDelivery\&quot;: 120&#x60; is included, then the network will not attempt to start message delivery for two hours after the message has been submitted 
   * @return scheduledDelivery
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "How long the platform should wait before attempting to send the message - specified in minutes.  e.g.: If `\"scheduledDelivery\": 120` is included, then the network will not attempt to start message delivery for two hours after the message has been submitted ")

  public Integer getScheduledDelivery() {
    return scheduledDelivery;
  }


  public void setScheduledDelivery(Integer scheduledDelivery) {
    this.scheduledDelivery = scheduledDelivery;
  }


  public SendSMSRequest notifyURL(String notifyURL) {
    
    this.notifyURL = notifyURL;
    return this;
  }

   /**
   * Contains a URL that will be called once your message has been processed. The status may be delivered, expired, deleted, etc. Please refer to the Delivery Status section for more information.  If you are using a domain URL you must include the forward slash at the end of the URL (e.g. http://www.example.com/). 
   * @return notifyURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "http://www.example.com/", value = "Contains a URL that will be called once your message has been processed. The status may be delivered, expired, deleted, etc. Please refer to the Delivery Status section for more information.  If you are using a domain URL you must include the forward slash at the end of the URL (e.g. http://www.example.com/). ")

  public String getNotifyURL() {
    return notifyURL;
  }


  public void setNotifyURL(String notifyURL) {
    this.notifyURL = notifyURL;
  }


  public SendSMSRequest replyRequest(Boolean replyRequest) {
    
    this.replyRequest = replyRequest;
    return this;
  }

   /**
   * If set to true, the reply message functionality will be implemented. The &#x60;from&#x60; field should not be present.  If false or not present, then normal message handling is implemented.  When set to true, network will use a temporary number to deliver this message. All messages sent by a mobile to this temporary number will be stored against the same &#x60;messageId&#x60;. If a &#x60;notifyURL&#x60; is provided then user replies will be delivered to the URL where &#x60;messageId&#x60; will be same as &#x60;messageId&#x60; in the response to the original API request.  This field contains the message text, this can be up to 500 UTF-8 characters. As mobile devices rarely support the full range of UTF-8 characters, it is possible that some characters may not be translated correctly by the mobile device. 
   * @return replyRequest
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "If set to true, the reply message functionality will be implemented. The `from` field should not be present.  If false or not present, then normal message handling is implemented.  When set to true, network will use a temporary number to deliver this message. All messages sent by a mobile to this temporary number will be stored against the same `messageId`. If a `notifyURL` is provided then user replies will be delivered to the URL where `messageId` will be same as `messageId` in the response to the original API request.  This field contains the message text, this can be up to 500 UTF-8 characters. As mobile devices rarely support the full range of UTF-8 characters, it is possible that some characters may not be translated correctly by the mobile device. ")

  public Boolean getReplyRequest() {
    return replyRequest;
  }


  public void setReplyRequest(Boolean replyRequest) {
    this.replyRequest = replyRequest;
  }


  public SendSMSRequest priority(Boolean priority) {
    
    this.priority = priority;
    return this;
  }

   /**
   * When messages are queued up for a number, then it is possible to set where a new message will be placed in the queue. If the priority is set to true then the new message will be placed ahead of all messages with a normal priority. If there are no messages queued for the number, then this parameter has no effect. 
   * @return priority
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "When messages are queued up for a number, then it is possible to set where a new message will be placed in the queue. If the priority is set to true then the new message will be placed ahead of all messages with a normal priority. If there are no messages queued for the number, then this parameter has no effect. ")

  public Boolean getPriority() {
    return priority;
  }


  public void setPriority(Boolean priority) {
    this.priority = priority;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendSMSRequest sendSMSRequest = (SendSMSRequest) o;
    return Objects.equals(this.to, sendSMSRequest.to) &&
        Objects.equals(this.body, sendSMSRequest.body) &&
        Objects.equals(this.from, sendSMSRequest.from) &&
        Objects.equals(this.validity, sendSMSRequest.validity) &&
        Objects.equals(this.scheduledDelivery, sendSMSRequest.scheduledDelivery) &&
        Objects.equals(this.notifyURL, sendSMSRequest.notifyURL) &&
        Objects.equals(this.replyRequest, sendSMSRequest.replyRequest) &&
        Objects.equals(this.priority, sendSMSRequest.priority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, body, from, validity, scheduledDelivery, notifyURL, replyRequest, priority);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendSMSRequest {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    validity: ").append(toIndentedString(validity)).append("\n");
    sb.append("    scheduledDelivery: ").append(toIndentedString(scheduledDelivery)).append("\n");
    sb.append("    notifyURL: ").append(toIndentedString(notifyURL)).append("\n");
    sb.append("    replyRequest: ").append(toIndentedString(replyRequest)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

