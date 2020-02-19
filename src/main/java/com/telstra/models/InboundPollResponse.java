/*
 * Telstra Messaging API
 * The Telstra Messaging API specification
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
 * Poll for incoming messages returning the latest. Only works if no callback url was specified when provisioning a number. 
 */
@ApiModel(description = "Poll for incoming messages returning the latest. Only works if no callback url was specified when provisioning a number. ")

public class InboundPollResponse {
  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_DESTINATION_ADDRESS = "destinationAddress";
  @SerializedName(SERIALIZED_NAME_DESTINATION_ADDRESS)
  private String destinationAddress;

  public static final String SERIALIZED_NAME_SENDER_ADDRESS = "senderAddress";
  @SerializedName(SERIALIZED_NAME_SENDER_ADDRESS)
  private String senderAddress;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message;

  public static final String SERIALIZED_NAME_MESSAGE_ID = "messageId";
  @SerializedName(SERIALIZED_NAME_MESSAGE_ID)
  private String messageId;

  public static final String SERIALIZED_NAME_SENT_TIMESTAMP = "sentTimestamp";
  @SerializedName(SERIALIZED_NAME_SENT_TIMESTAMP)
  private String sentTimestamp;


  public InboundPollResponse status(String status) {
    
    this.status = status;
    return this;
  }

   /**
   * message status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "message status")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }


  public InboundPollResponse destinationAddress(String destinationAddress) {
    
    this.destinationAddress = destinationAddress;
    return this;
  }

   /**
   * The phone number (recipient) that the message was sent to (in E.164 format). 
   * @return destinationAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The phone number (recipient) that the message was sent to (in E.164 format). ")

  public String getDestinationAddress() {
    return destinationAddress;
  }


  public void setDestinationAddress(String destinationAddress) {
    this.destinationAddress = destinationAddress;
  }


  public InboundPollResponse senderAddress(String senderAddress) {
    
    this.senderAddress = senderAddress;
    return this;
  }

   /**
   * The phone number (sender) that the message was sent from (in E.164 format). 
   * @return senderAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The phone number (sender) that the message was sent from (in E.164 format). ")

  public String getSenderAddress() {
    return senderAddress;
  }


  public void setSenderAddress(String senderAddress) {
    this.senderAddress = senderAddress;
  }


  public InboundPollResponse message(String message) {
    
    this.message = message;
    return this;
  }

   /**
   * Text of the message that was sent
   * @return message
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Text of the message that was sent")

  public String getMessage() {
    return message;
  }


  public void setMessage(String message) {
    this.message = message;
  }


  public InboundPollResponse messageId(String messageId) {
    
    this.messageId = messageId;
    return this;
  }

   /**
   * Message Id
   * @return messageId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Message Id")

  public String getMessageId() {
    return messageId;
  }


  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }


  public InboundPollResponse sentTimestamp(String sentTimestamp) {
    
    this.sentTimestamp = sentTimestamp;
    return this;
  }

   /**
   * The date and time when the message was sent by recipient.
   * @return sentTimestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the message was sent by recipient.")

  public String getSentTimestamp() {
    return sentTimestamp;
  }


  public void setSentTimestamp(String sentTimestamp) {
    this.sentTimestamp = sentTimestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InboundPollResponse inboundPollResponse = (InboundPollResponse) o;
    return Objects.equals(this.status, inboundPollResponse.status) &&
        Objects.equals(this.destinationAddress, inboundPollResponse.destinationAddress) &&
        Objects.equals(this.senderAddress, inboundPollResponse.senderAddress) &&
        Objects.equals(this.message, inboundPollResponse.message) &&
        Objects.equals(this.messageId, inboundPollResponse.messageId) &&
        Objects.equals(this.sentTimestamp, inboundPollResponse.sentTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, destinationAddress, senderAddress, message, messageId, sentTimestamp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InboundPollResponse {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    destinationAddress: ").append(toIndentedString(destinationAddress)).append("\n");
    sb.append("    senderAddress: ").append(toIndentedString(senderAddress)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    sentTimestamp: ").append(toIndentedString(sentTimestamp)).append("\n");
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

