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

package com.telstra.messaging;

import com.telstra.*;
import java.util.UUID;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static com.telstra.messaging.AuthenticationApi.getAuthToken;
import static org.junit.Assert.assertNotNull;


/**
 * API tests for ReportsApi
 */

public class ReportsApiTest {

    private ApiClient defaultClient;

    //@Before
    public void setUp() {

        defaultClient = new ApiClient();

        String clientId = "YOUR CLIENT ID";
        String clientSecret = "YOUR CLIENT SECRET";
        String grantType = "client_credentials";
        String scope = "free-trial-numbers:read free-trial-numbers:write messages:read messages:write virtual-numbers:read virtual-numbers:write reports:read reports:write";

        defaultClient.setAccessSecret(clientId, clientSecret, grantType, scope);
        defaultClient.setBasePath("https://products.api.telstra.com/v2");
        System.out.println("Setting up before each test...");
    }

    /**
     * fetch a specific report
     * Fetch a download link for a report generated with POST /reports/{reportId} using the **reportId** returned in the response. Once ready, your report will be available for download for one week. 
     *
     */
    @Ignore
    public void getReportTest() {

        try{
            ApiClient apiClient = getAuthToken(defaultClient);
            ReportsApi reportsApi = new ReportsApi(apiClient);

            UUID reportId = UUID.fromString("2be7b580-4c34-11ee-a651-ad71114ff6eb");

            GetReportId200Response response = reportsApi.getReport(reportId);
            System.out.println(response);
            assertNotNull(response.getReportId());

        } catch (ApiException e) {
            System.err.println("Exception when calling ReportsApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
    /**
     * fetch all reports
     * Fetch details of all reports recently generated for your account. Use it to check the status of a report, plus fetch the report ID, status, report type and expiry date. 
     *
     */
    @Ignore
    public void getReportsTest() {

        try{
            ApiClient apiClient = getAuthToken(defaultClient);
            ReportsApi reportsApi = new ReportsApi(apiClient);

            GetReports200Response response = reportsApi.getReports();
            System.out.println(response);
            assertNotNull(response.getReports());

        } catch (ApiException e) {
            System.err.println("Exception when calling ReportsApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
    /**
     * submit a request for a messages report
     * Request a CSV report of messages (both incoming and outgoing) that have been sent to/from your account within the last three months. You can request details for a specific timeframe, and filter your messages by tags, recipient number or Virtual Number.  A 201 Created means your report has been queued for generation. Make a note of the reportId returned in the response. You&#x27;ll need this to check the status of your report and fetch your download link with GET reports/{reportId}. If you supplied a reportCallbackUrl in the request we&#x27;ll also notify it when your report is ready for download.  Once your report is generated, it will be available for download for one week. The expiry date is returned in the response. 
     *
     */
    @Ignore
    public void messagesReportTest() {

        try{
            ApiClient apiClient = getAuthToken(defaultClient);
            ReportsApi reportsApi = new ReportsApi(apiClient);

            ReportsMessagesBody reportsMessagesBody = new ReportsMessagesBody().startDate(org.threeten.bp.LocalDate.parse("2023-09-01"))
                    .endDate(org.threeten.bp.LocalDate.parse("2023-09-06"))
                    .reportCallbackUrl("http://www.example.com");

            GetReports201Response response = reportsApi.messagesReport(reportsMessagesBody);
            System.out.println(response);
            assertNotNull(response.getReportId());

        } catch (ApiException e) {
            System.err.println("Exception when calling ReportsApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
