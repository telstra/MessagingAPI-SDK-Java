# GetReports201Response

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reportId** | [**UUID**](UUID.md) | When your report is ready for download, you can use this UUID to fetch it with the GET /reports/{reportId} endpoint.  |  [optional]
**reportCallbackUrl** | **String** | If you provided a reportCallbackUrl in your request, it will be returned here. |  [optional]
**reportStatus** | **String** | The status of the report. It will be either:        * **queued** – the report is in the queue for generation.        * **completed** – the report is ready for download.        * **failed** – the report failed to generate. Please try again.  |  [optional]
