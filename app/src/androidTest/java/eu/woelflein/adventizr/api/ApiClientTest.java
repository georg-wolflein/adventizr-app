package eu.woelflein.adventizr.api;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import eu.woelflein.adventizr.Preference;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class ApiClientTest {

    @Before
    public void setUp() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        ApiClient.setInstance(new ApiClient(Preference.API_BASE_URL.getString(appContext)));
    }

    /**
     * Tests that the status?format=plain endpoint returns "running".
     */
    @Test
    public void apiIsRunning() throws IOException {
        String outcome = ApiClient.getInstance().getResponseString(ApiRequest.forEndpoint("status?format=plain"));
        assertEquals("running", outcome);
    }

    @Test
    public void performRequest() {
    }
}