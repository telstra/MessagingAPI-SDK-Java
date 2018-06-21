
# MessageSentResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**messages** | [**List&lt;Message&gt;**](Message.md) | An array of messages. | 
**messageType** | **String** | This returns whether the message sent was a SMS or MMS. | 
**numberSegments** | **Integer** | For SMS messages only, the value indicates the number of 160 character message segments sent. | 
**numberNationalDestinations** | **Integer** | This returns the number of domestic Australian messages sent. |  [optional]
**numberInternationalDestinations** | **Integer** | This returns the number of international messages sent |  [optional]



