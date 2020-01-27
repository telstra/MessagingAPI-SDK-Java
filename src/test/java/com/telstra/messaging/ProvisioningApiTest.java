/*
 * Telstra Messaging API
 * The API specification for Telstra Messaging API
 *
 * The version of the OpenAPI document: 2.2.9
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.telstra.messaging;

import com.telstra.ApiException;
import com.telstra.models.DeleteNumberRequest;
import com.telstra.models.GetSubscriptionResponse;
import com.telstra.models.ProvisionNumberRequest;
import com.telstra.models.ProvisionNumberResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProvisioningApi
 */
@Ignore
public class ProvisioningApiTest {

    private final ProvisioningApi api = new ProvisioningApi();

    
    /**
     * Create Subscription
     *
     * Invoke the provisioning API to get a dedicated mobile number for an account or application.  Note that Free Trial apps will have a 30-Day Limit for their provisioned number. If the Provisioning call is made several times within that 30-Day period, it will return the &#x60;expiryDate&#x60; in the Unix format and will not add any activeDays until after that &#x60;expiryDate&#x60;. After the &#x60;expiryDate&#x60;, you may make another Provisioning call to extend the activeDays by another 30-Days.  For paid apps, a provisioned number can be allotted for a maximum of 5 years. If a Provisioning call is made which will result to activeDays &gt; 1825, a 409 &#x60;Active Days Max&#x60; response will be returned to indicate that the provisioned number is already valid for more than 5 years and that no update to activeDays has been made. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createSubscriptionTest() throws ApiException {
        ProvisionNumberRequest body = null;
        ProvisionNumberResponse response = api.createSubscription(body);

        // TODO: test validations
    }
    
    /**
     * Delete Subscription
     *
     * Delete a mobile number subscription from an account 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteSubscriptionTest() throws ApiException {
        DeleteNumberRequest body = null;
        api.deleteSubscription(body);

        // TODO: test validations
    }
    
    /**
     * Get Subscription
     *
     * Get mobile number subscription for an account 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSubscriptionTest() throws ApiException {
        GetSubscriptionResponse response = api.getSubscription();

        // TODO: test validations
    }
    
}
