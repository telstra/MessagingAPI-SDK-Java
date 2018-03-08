/*
 * Telstra Messaging API
 *  The Telstra SMS Messaging API allows your applications to send and receive SMS text messages from Australia's leading network operator.  It also allows your application to track the delivery status of both sent and received SMS messages. 
 *
 * OpenAPI spec version: 2.2.5
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * GetSubscriptionResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-03-08T00:36:43.245Z")
public class GetSubscriptionResponse {
  @SerializedName("activeDays")
  private String activeDays = null;

  @SerializedName("notifyURL")
  private String notifyURL = null;

  @SerializedName("destinationAddress")
  private String destinationAddress = null;

  public GetSubscriptionResponse activeDays(String activeDays) {
    this.activeDays = activeDays;
    return this;
  }

   /**
   * Number of active days
   * @return activeDays
  **/
  @ApiModelProperty(value = "Number of active days")
  public String getActiveDays() {
    return activeDays;
  }

  public void setActiveDays(String activeDays) {
    this.activeDays = activeDays;
  }

  public GetSubscriptionResponse notifyURL(String notifyURL) {
    this.notifyURL = notifyURL;
    return this;
  }

   /**
   * Notify url configured
   * @return notifyURL
  **/
  @ApiModelProperty(value = "Notify url configured")
  public String getNotifyURL() {
    return notifyURL;
  }

  public void setNotifyURL(String notifyURL) {
    this.notifyURL = notifyURL;
  }

  public GetSubscriptionResponse destinationAddress(String destinationAddress) {
    this.destinationAddress = destinationAddress;
    return this;
  }

   /**
   * The mobile phone number that was allocated
   * @return destinationAddress
  **/
  @ApiModelProperty(value = "The mobile phone number that was allocated")
  public String getDestinationAddress() {
    return destinationAddress;
  }

  public void setDestinationAddress(String destinationAddress) {
    this.destinationAddress = destinationAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSubscriptionResponse getSubscriptionResponse = (GetSubscriptionResponse) o;
    return Objects.equals(this.activeDays, getSubscriptionResponse.activeDays) &&
        Objects.equals(this.notifyURL, getSubscriptionResponse.notifyURL) &&
        Objects.equals(this.destinationAddress, getSubscriptionResponse.destinationAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activeDays, notifyURL, destinationAddress);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSubscriptionResponse {\n");
    
    sb.append("    activeDays: ").append(toIndentedString(activeDays)).append("\n");
    sb.append("    notifyURL: ").append(toIndentedString(notifyURL)).append("\n");
    sb.append("    destinationAddress: ").append(toIndentedString(destinationAddress)).append("\n");
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
