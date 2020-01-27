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
import com.telstra.models.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * MessageSentResponseSms
 */

public class MessageSentResponseSms {
  public static final String SERIALIZED_NAME_MESSAGES = "messages";
  @SerializedName(SERIALIZED_NAME_MESSAGES)
  private List<Message> messages = new ArrayList<Message>();

  public static final String SERIALIZED_NAME_COUNTRY = "Country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  private List<Object> country = null;

  public static final String SERIALIZED_NAME_MESSAGE_TYPE = "messageType";
  @SerializedName(SERIALIZED_NAME_MESSAGE_TYPE)
  private String messageType;

  public static final String SERIALIZED_NAME_NUMBER_SEGMENTS = "numberSegments";
  @SerializedName(SERIALIZED_NAME_NUMBER_SEGMENTS)
  private Integer numberSegments;


  public MessageSentResponseSms messages(List<Message> messages) {
    
    this.messages = messages;
    return this;
  }

  public MessageSentResponseSms addMessagesItem(Message messagesItem) {
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * An array of messages.
   * @return messages
  **/
  @ApiModelProperty(required = true, value = "An array of messages.")

  public List<Message> getMessages() {
    return messages;
  }


  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }


  public MessageSentResponseSms country(List<Object> country) {
    
    this.country = country;
    return this;
  }

  public MessageSentResponseSms addCountryItem(Object countryItem) {
    if (this.country == null) {
      this.country = new ArrayList<Object>();
    }
    this.country.add(countryItem);
    return this;
  }

   /**
   * An array of the countries to which the destination MSISDNs belong.
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[{AUS=1}]", value = "An array of the countries to which the destination MSISDNs belong.")

  public List<Object> getCountry() {
    return country;
  }


  public void setCountry(List<Object> country) {
    this.country = country;
  }


  public MessageSentResponseSms messageType(String messageType) {
    
    this.messageType = messageType;
    return this;
  }

   /**
   * This returns whether the message sent was a SMS or MMS.
   * @return messageType
  **/
  @ApiModelProperty(example = "SMS", required = true, value = "This returns whether the message sent was a SMS or MMS.")

  public String getMessageType() {
    return messageType;
  }


  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }


  public MessageSentResponseSms numberSegments(Integer numberSegments) {
    
    this.numberSegments = numberSegments;
    return this;
  }

   /**
   * A message which has 160 GSM-7 characters or less will have numberSegments&#x3D;1. Note that multi-part messages which are over 160 GSM-7 characters will include the User Data Header as part of the numberSegments. The User Data Header is being used for the re-assembly of the messages. 
   * @return numberSegments
  **/
  @ApiModelProperty(example = "1", required = true, value = "A message which has 160 GSM-7 characters or less will have numberSegments=1. Note that multi-part messages which are over 160 GSM-7 characters will include the User Data Header as part of the numberSegments. The User Data Header is being used for the re-assembly of the messages. ")

  public Integer getNumberSegments() {
    return numberSegments;
  }


  public void setNumberSegments(Integer numberSegments) {
    this.numberSegments = numberSegments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageSentResponseSms messageSentResponseSms = (MessageSentResponseSms) o;
    return Objects.equals(this.messages, messageSentResponseSms.messages) &&
        Objects.equals(this.country, messageSentResponseSms.country) &&
        Objects.equals(this.messageType, messageSentResponseSms.messageType) &&
        Objects.equals(this.numberSegments, messageSentResponseSms.numberSegments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messages, country, messageType, numberSegments);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageSentResponseSms {\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
    sb.append("    numberSegments: ").append(toIndentedString(numberSegments)).append("\n");
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

