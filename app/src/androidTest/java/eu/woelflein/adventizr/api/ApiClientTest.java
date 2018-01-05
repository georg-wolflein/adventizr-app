package eu.woelflein.adventizr.api;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import eu.woelflein.adventizr.Preference;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Test class for the {@link ApiClient} class.
 */
public class ApiClientTest {

    /**
     * Initializes the {@link ApiClient} instance.
     */
    @Before
    public void setUp() throws MalformedURLException {
        Context appContext = InstrumentationRegistry.getTargetContext();
        ApiClient.setInstance(new ApiClient(Preference.API_BASE_URL.getString(appContext)));
    }

    /**
     * Tests that {@link ApiClient#getInstance()} does not return null.
     */
    @Test
    public void getInstance() {
        assertNotNull(ApiClient.getInstance());
    }

    /**
     * Tests that the "/status?format=plain" endpoint returns "running", thereby testing the {@link ApiClient#getResponseString(ApiRequest)} method.
     */
    @Test
    public void apiIsRunning() throws IOException {
        String outcome = ApiClient.getInstance().getResponseString(ApiRequest.forEndpoint("status?format=plain"));
        assertEquals("running", outcome);
    }

    @Test
    public void performPlainTextRequest() throws IOException, ApiResponseException {
        ApiRequest<String> request = ApiRequest.forEndpoint("status?format=plain");
        assertEquals("running", ApiClient.getInstance().performRequest(request));
    }
}