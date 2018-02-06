/*
 * Telstra Messaging API
 *  The Telstra SMS Messaging API allows your applications to send and receive SMS text messages from Australia's leading network operator.  It also allows your application to track the delivery status of both sent and received SMS messages. 
 *
 * OpenAPI spec version: 2.2.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.telstra.messaging;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.telstra.messaging.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * OutboundPollResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-06T12:04:52.962+11:00")
public class OutboundPollResponse {
  @SerializedName("to")
  private String to = null;

  @SerializedName("receivedTimestamp")
  private String receivedTimestamp = null;

  @SerializedName("sentTimestamp")
  private String sentTimestamp = null;

  @SerializedName("deliveryStatus")
  private Status deliveryStatus = null;

  public OutboundPollResponse to(String to) {
    this.to = to;
    return this;
  }

   /**
   * The phone number (recipient) the message was sent to (in E.164 format).
   * @return to
  **/
  @ApiModelProperty(value = "The phone number (recipient) the message was sent to (in E.164 format).")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public OutboundPollResponse receivedTimestamp(String receivedTimestamp) {
    this.receivedTimestamp = receivedTimestamp;
    return this;
  }

   /**
   * The date and time when the message was recieved by recipient.
   * @return receivedTimestamp
  **/
  @ApiModelProperty(value = "The date and time when the message was recieved by recipient.")
  public String getReceivedTimestamp() {
    return receivedTimestamp;
  }

  public void setReceivedTimestamp(String receivedTimestamp) {
    this.receivedTimestamp = receivedTimestamp;
  }

  public OutboundPollResponse sentTimestamp(String sentTimestamp) {
    this.sentTimestamp = sentTimestamp;
    return this;
  }

   /**
   * The date and time when the message was sent.
   * @return sentTimestamp
  **/
  @ApiModelProperty(value = "The date and time when the message was sent.")
  public String getSentTimestamp() {
    return sentTimestamp;
  }

  public void setSentTimestamp(String sentTimestamp) {
    this.sentTimestamp = sentTimestamp;
  }

  public OutboundPollResponse deliveryStatus(Status deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
    return this;
  }

   /**
   * Get deliveryStatus
   * @return deliveryStatus
  **/
  @ApiModelProperty(value = "")
  public Status getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(Status deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OutboundPollResponse outboundPollResponse = (OutboundPollResponse) o;
    return Objects.equals(this.to, outboundPollResponse.to) &&
        Objects.equals(this.receivedTimestamp, outboundPollResponse.receivedTimestamp) &&
        Objects.equals(this.sentTimestamp, outboundPollResponse.sentTimestamp) &&
        Objects.equals(this.deliveryStatus, outboundPollResponse.deliveryStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, receivedTimestamp, sentTimestamp, deliveryStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OutboundPollResponse {\n");
    
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    receivedTimestamp: ").append(toIndentedString(receivedTimestamp)).append("\n");
    sb.append("    sentTimestamp: ").append(toIndentedString(sentTimestamp)).append("\n");
    sb.append("    deliveryStatus: ").append(toIndentedString(deliveryStatus)).append("\n");
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
