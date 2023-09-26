package com.telstra;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;




/**
 * UpdateNumberRequest
 */

public class UpdateNumberRequest {
  public static final String SERIALIZED_NAME_REPLY_CALLBACK_URL = "replyCallbackUrl";
  @SerializedName(SERIALIZED_NAME_REPLY_CALLBACK_URL)
  private String replyCallbackUrl;

  public static final String SERIALIZED_NAME_TAGS = "tags";
  @SerializedName(SERIALIZED_NAME_TAGS)
  private List<String> tags;

  public UpdateNumberRequest() {
  }

  public UpdateNumberRequest replyCallbackUrl(String replyCallbackUrl) {
    
    this.replyCallbackUrl = replyCallbackUrl;
    return this;
  }

   /**
   * Tell us the URL that replies to the Virtual Number should be sent to.  Note that if you don&#39;t include this field, any pre-existing replyCallbackUrl will be wiped.  Sample callback response:  &lt;pre&gt;&lt;code class&#x3D;\&quot;language-sh\&quot;&gt;{   \&quot;to\&quot;:\&quot;0476543210\&quot;,    \&quot;from\&quot;:\&quot;0401234567\&quot;,    \&quot;timestamp\&quot;:\&quot;2022-11-10T05:06:42.823Z\&quot;,   \&quot;messageId\&quot;:\&quot;75f263c0-60b5-11ed-8456-71ae4c63550d\&quot;,    \&quot;messageContent\&quot;:\&quot;Hi, example message\&quot;,    \&quot;multimedia\&quot;: {      \&quot;fileName:\&quot;image.jpeg\&quot;      \&quot;type:\&quot;image/jpeg\&quot;      \&quot;payload\&quot;:\&quot;base64 payload\&quot;    } }&lt;/code&gt;&lt;/pre&gt; 
   * @return replyCallbackUrl
  **/

  public String getReplyCallbackUrl() {
    return replyCallbackUrl;
  }


  public void setReplyCallbackUrl(String replyCallbackUrl) {
    this.replyCallbackUrl = replyCallbackUrl;
  }


  public UpdateNumberRequest tags(List<String> tags) {
    
    this.tags = tags;
    return this;
  }

  public UpdateNumberRequest addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Create your own tags and use them to fetch, sort and report on your Virtual Numbers through our other endpoints. You can assign up to 10 tags per number.   Note that if you don&#39;t include this field, any pre-existing tags will be wiped. 
   * @return tags
  **/

  public List<String> getTags() {
    return tags;
  }


  public void setTags(List<String> tags) {
    this.tags = tags;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateNumberRequest updateNumberRequest = (UpdateNumberRequest) o;
    return Objects.equals(this.replyCallbackUrl, updateNumberRequest.replyCallbackUrl) &&
        Objects.equals(this.tags, updateNumberRequest.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replyCallbackUrl, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    replyCallbackUrl: ").append(toIndentedString(replyCallbackUrl)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("replyCallbackUrl");
    openapiFields.add("tags");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

}

