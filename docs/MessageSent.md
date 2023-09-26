# MessageSent

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**messageId** | **OneOfMessageSentMessageId** | Use this UUID with our other endpoints to fetch, update or delete the message. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status will be either queued, sent, delivered, expired or undeliverable. |  [optional]
**to** | **OneOfMessageSentTo** | The recipient&#x27;s mobile number(s). |  [optional]
**from** | **String** | This will be either \&quot;privateNumber\&quot;, one of your Virtual Numbers or your senderName. |  [optional]
**messageContent** | **String** | The content of the message. |  [optional]
**multimedia** | [**List&lt;MultimediaGet&gt;**](MultimediaGet.md) | The multimedia content of the message (MMS only). It will include:  |  [optional]
**retryTimeout** | **Integer** | How many minutes you asked the server to keep trying to send the message. |  [optional]
**scheduleSend** | [**OffsetDateTime**](OffsetDateTime.md) | The time (in Central Standard Time) the message is scheduled to send. |  [optional]
**deliveryNotification** | **Boolean** | If set to **true**, you will receive a notification to the statusCallbackUrl when your SMS is delivered (paid feature). |  [optional]
**statusCallbackUrl** | **String** | The URL the API will call when the status of the message changes. |  [optional]
**tags** | **List&lt;String&gt;** | Any customisable tags assigned to the message. |  [optional]

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
QUEUED | &quot;queued&quot;
SENT | &quot;sent&quot;
DELIVERED | &quot;delivered&quot;
EXPIRED | &quot;expired&quot;
UNDELIVERABLE | &quot;undeliverable&quot;
