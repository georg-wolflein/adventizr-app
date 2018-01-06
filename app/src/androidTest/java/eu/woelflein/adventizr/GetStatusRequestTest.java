package eu.woelflein.adventizr;

import eu.woelflein.adventizr.api.ApiResponseException;
import eu.woelflein.adventizr.api.GetStatusRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for the {@link GetStatusRequest} class.
 */
public class GetStatusRequestTest {

    /**
     * Tests that the request points to the correct API endpoint.
     */
    @Test
    public void apiEndpoint() {
        assertEquals("status", new GetStatusRequest().getEndpoint());
    }

    /**
     * Tests the {@link GetStatusRequest#readResponse(String)} method with a sample JSON response if the service is
     * running.
     */
    @Test
    public void readRunningResponse() throws ApiResponseException {
        String json = "{\"status\":\"running\"}";
        assertTrue(new GetStatusRequest().readResponse(json));
    }

    /**
     * Tests the {@link GetStatusRequest#readResponse(String)} method with a sample JSON response if the service is
     * not running.
     */
    @Test
    public void readFailedResponse() throws ApiResponseException {
        String json = "{\"status\":\"fail\"}";
        assertFalse(new GetStatusRequest().readResponse(json));
    }
}