/*
 * Telstra Messaging API
 * The API specification for Telstra Messaging API
 *
 * The version of the OpenAPI document: 2.2.9
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.telstra.models;

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
 * MessageMulti
 */

public class MessageMulti {
  public static final String SERIALIZED_NAME_TO = "to";
  @SerializedName(SERIALIZED_NAME_TO)
  private String to;

  public static final String SERIALIZED_NAME_BODY = "body";
  @SerializedName(SERIALIZED_NAME_BODY)
  private String body;

  public static final String SERIALIZED_NAME_RECEIPT_OFF = "receiptOff";
  @SerializedName(SERIALIZED_NAME_RECEIPT_OFF)
  private Boolean receiptOff;


  public MessageMulti to(String to) {
    
    this.to = to;
    return this;
  }

   /**
   * Phone number (in E.164 format) to send the SMS to. This number can be in international format &#x60;\&quot;to\&quot;: \&quot;+61412345678\&quot;&#x60; or in national format. 
   * @return to
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "+61412345678", value = "Phone number (in E.164 format) to send the SMS to. This number can be in international format `\"to\": \"+61412345678\"` or in national format. ")

  public String getTo() {
    return to;
  }


  public void setTo(String to) {
    this.to = to;
  }


  public MessageMulti body(String body) {
    
    this.body = body;
    return this;
  }

   /**
   * The text body of the message. Messages longer than 160 characters will be counted as multiple messages.  This field contains the message text, this can be up to 1900 (for a single recipient) or 500 (for multiple recipients) UTF-8 characters. As mobile devices rarely support the full range of UTF-8 characters, it is possible that some characters may not be translated correctly by the mobile device 
   * @return body
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Test Message", value = "The text body of the message. Messages longer than 160 characters will be counted as multiple messages.  This field contains the message text, this can be up to 1900 (for a single recipient) or 500 (for multiple recipients) UTF-8 characters. As mobile devices rarely support the full range of UTF-8 characters, it is possible that some characters may not be translated correctly by the mobile device ")

  public String getBody() {
    return body;
  }


  public void setBody(String body) {
    this.body = body;
  }


  public MessageMulti receiptOff(Boolean receiptOff) {
    
    this.receiptOff = receiptOff;
    return this;
  }

   /**
   * Whether Delivery Receipt will be sent back or not.  Setting this field to &#x60;true&#x60; will disable Delivery Receipts. The &#x60;notifyURL&#x60; field will be ignored, if there is one in the payload. An \&quot;OLD-NONEXISTANT-MESSAGE-ID\&quot; 400 error will also be returned upon Polling for the SMS Status. 
   * @return receiptOff
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "Whether Delivery Receipt will be sent back or not.  Setting this field to `true` will disable Delivery Receipts. The `notifyURL` field will be ignored, if there is one in the payload. An \"OLD-NONEXISTANT-MESSAGE-ID\" 400 error will also be returned upon Polling for the SMS Status. ")

  public Boolean getReceiptOff() {
    return receiptOff;
  }


  public void setReceiptOff(Boolean receiptOff) {
    this.receiptOff = receiptOff;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageMulti messageMulti = (MessageMulti) o;
    return Objects.equals(this.to, messageMulti.to) &&
        Objects.equals(this.body, messageMulti.body) &&
        Objects.equals(this.receiptOff, messageMulti.receiptOff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, body, receiptOff);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageMulti {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    receiptOff: ").append(toIndentedString(receiptOff)).append("\n");
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

