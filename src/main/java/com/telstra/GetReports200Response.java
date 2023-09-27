/*
 * Messaging API v3.1.0
 * Send and receive SMS & MMS programmatically, leveraging Australia's leading mobile network. With Telstra's Messaging API, we take out the complexity to allow seamless messaging integration into your app, with just a few lines of code. Our REST API is enterprise grade, allowing you to communicate with engaging SMS & MMS messaging in your web and mobile apps in near real-time on a global scale. 
 *
 * OpenAPI spec version: 3.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.telstra;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
/**
 * GetReports200Response
 */


public class GetReports200Response {
  @SerializedName("reports")
  private List<GetReports200ResponseReportsInner> reports = null;

  public GetReports200Response reports(List<GetReports200ResponseReportsInner> reports) {
    this.reports = reports;
    return this;
  }

  public GetReports200Response addReportsItem(GetReports200ResponseReportsInner reportsItem) {
    if (this.reports == null) {
      this.reports = new ArrayList<GetReports200ResponseReportsInner>();
    }
    this.reports.add(reportsItem);
    return this;
  }

   /**
   * Get reports
   * @return reports
  **/
  @Schema(description = "")
  public List<GetReports200ResponseReportsInner> getReports() {
    return reports;
  }

  public void setReports(List<GetReports200ResponseReportsInner> reports) {
    this.reports = reports;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetReports200Response getReports200Response = (GetReports200Response) o;
    return Objects.equals(this.reports, getReports200Response.reports);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reports);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    reports: ").append(toIndentedString(reports)).append("\n");
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