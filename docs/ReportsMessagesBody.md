# ReportsMessagesBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**LocalDate**](LocalDate.md) | Set the time period you want to generate a report for by typing the start date (inclusive) here.  Note that we only retain data for three months, so please ensure your startDate is not more than three months old.  Use ISO format(yyyy-mm-dd), e.g. 2019-08-24.  | 
**endDate** | [**LocalDate**](LocalDate.md) | Type the end date (inclusive) of your reporting period here.  Your endDate must be a date in the past, and less than three months from your startDate. Use ISO format(yyyy-mm-dd).  | 
**reportCallbackUrl** | **String** | Tell us the callbackUrl you want us to notify when your report is ready for download.  Sample callback response:  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;reportId\&quot;:\&quot;1520b774-46b0-4415-a05f-7bcb1c032c59\&quot;,   \&quot;reportStatus\&quot;:\&quot;completed\&quot;,   \&quot;timestamp\&quot;:\&quot;2022-11-10T05:06:42.823Z\&quot; }&lt;/code&gt;&lt;/pre&gt;  |  [optional]
**filter** | **String** | Filter your messages report by:   * tag - use one of the tags assigned to your message(s)   * number - either the Virtual Number used to send the message, or the Recipient Number the message was sent to.  |  [optional]
