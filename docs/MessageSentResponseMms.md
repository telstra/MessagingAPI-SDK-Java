

# MessageSentResponseMms

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**messages** | [**List&lt;Message&gt;**](Message.md) | An array of messages. | 
**mmsMediaKB** | **Integer** | Indicates the message size in kB of the MMS sent.  |  [optional]
**country** | **List&lt;Object&gt;** | An array of the countries to which the destination MSISDNs belong. |  [optional]
**messageType** | **String** | This returns whether the message sent was a SMS or MMS. | 
**numberSegments** | **Integer** | MMS with numberSegments below 600 are classed as Small whereas those that are bigger than 600 are classed as Large. They will be charged accordingly.  | 



