# InlineResponse2005

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reportId** | [**UUID**](UUID.md) | The UUID assigned to your report.  |  [optional]
**reportStatus** | **String** | The status of the report. It will be either:        * **queued** – the report is in the queue for generation.        * **completed** – the report is ready for download.        * **failed** – the report failed to generate. Please try again.  |  [optional]
**reportUrl** | **String** | Use this link to download your CSV file. |  [optional]
