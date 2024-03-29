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
import org.threeten.bp.LocalDate;
/**
 * ReportsMessagesBody
 */


public class ReportsMessagesBody {
  @SerializedName("startDate")
  private LocalDate startDate = null;

  @SerializedName("endDate")
  private LocalDate endDate = null;

  @SerializedName("reportCallbackUrl")
  private String reportCallbackUrl = null;

  @SerializedName("filter")
  private String filter = null;

  public ReportsMessagesBody startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * Set the time period you want to generate a report for by typing the start date (inclusive) here.  Note that we only retain data for three months, so please ensure your startDate is not more than three months old.  Use ISO format(yyyy-mm-dd), e.g. 2019-08-24. 
   * @return startDate
  **/
  @Schema(required = true, description = "Set the time period you want to generate a report for by typing the start date (inclusive) here.  Note that we only retain data for three months, so please ensure your startDate is not more than three months old.  Use ISO format(yyyy-mm-dd), e.g. 2019-08-24. ")
  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public ReportsMessagesBody endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

   /**
   * Type the end date (inclusive) of your reporting period here.  Your endDate must be a date in the past, and less than three months from your startDate. Use ISO format(yyyy-mm-dd). 
   * @return endDate
  **/
  @Schema(required = true, description = "Type the end date (inclusive) of your reporting period here.  Your endDate must be a date in the past, and less than three months from your startDate. Use ISO format(yyyy-mm-dd). ")
  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public ReportsMessagesBody reportCallbackUrl(String reportCallbackUrl) {
    this.reportCallbackUrl = reportCallbackUrl;
    return this;
  }

   /**
   * Tell us the callbackUrl you want us to notify when your report is ready for download.  Sample callback response:  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;reportId\&quot;:\&quot;1520b774-46b0-4415-a05f-7bcb1c032c59\&quot;,   \&quot;reportStatus\&quot;:\&quot;completed\&quot;,   \&quot;timestamp\&quot;:\&quot;2022-11-10T05:06:42.823Z\&quot; }&lt;/code&gt;&lt;/pre&gt; 
   * @return reportCallbackUrl
  **/
  @Schema(description = "Tell us the callbackUrl you want us to notify when your report is ready for download.  Sample callback response:  <pre><code class=\"language-sh\">{   \"reportId\":\"1520b774-46b0-4415-a05f-7bcb1c032c59\",   \"reportStatus\":\"completed\",   \"timestamp\":\"2022-11-10T05:06:42.823Z\" }</code></pre> ")
  public String getReportCallbackUrl() {
    return reportCallbackUrl;
  }

  public void setReportCallbackUrl(String reportCallbackUrl) {
    this.reportCallbackUrl = reportCallbackUrl;
  }

  public ReportsMessagesBody filter(String filter) {
    this.filter = filter;
    return this;
  }

   /**
   * Filter your messages report by:   * tag - use one of the tags assigned to your message(s)   * number - either the Virtual Number used to send the message, or the Recipient Number the message was sent to. 
   * @return filter
  **/
  @Schema(description = "Filter your messages report by:   * tag - use one of the tags assigned to your message(s)   * number - either the Virtual Number used to send the message, or the Recipient Number the message was sent to. ")
  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportsMessagesBody reportsMessagesBody = (ReportsMessagesBody) o;
    return Objects.equals(this.startDate, reportsMessagesBody.startDate) &&
        Objects.equals(this.endDate, reportsMessagesBody.endDate) &&
        Objects.equals(this.reportCallbackUrl, reportsMessagesBody.reportCallbackUrl) &&
        Objects.equals(this.filter, reportsMessagesBody.filter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, endDate, reportCallbackUrl, filter);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    reportCallbackUrl: ").append(toIndentedString(reportCallbackUrl)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
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
