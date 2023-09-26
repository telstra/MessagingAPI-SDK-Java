# GetReports200ResponseReportsInner

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reportId** | [**UUID**](UUID.md) | Use this UUID to fetch your report with the GET /reports/{reportId} endpoint.  |  [optional]
**reportStatus** | **String** | The status of the report. It will be either:        * **queued** – the report is in the queue for generation.        * **completed** – the report is ready for download.        * **failed** – the report failed to generate. Please try again.  |  [optional]
**reportType** | **String** | The type of report generated. |  [optional]
**reportExpiry** | [**LocalDate**](LocalDate.md) | The expiry date of your report. After this date, you will be unable to download your report.  |  [optional]
