package eu.woelflein.adventizr.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the {@link ApiRequest} class.
 */
public class ApiRequestTest {

    /**
     * Test the creation of an {@link ApiRequest} for plain text (Strings).
     */
    @Test
    public void forEndpoint() throws ApiResponseException {
        ApiRequest<String> request = ApiRequest.forEndpoint("test");
        assertEquals("abc", request.readResponse("abc"));
    }

    /**
     * Tests the {@link ApiRequest#getEndpoint()} method.
     */
    @Test
    public void getEndpoint() {
        ApiRequest<String> request = new ApiRequest<String>("test") {
            @Override
            public String readResponse(String response) {
                return null;
            }
        };
        assertEquals("test", request.getEndpoint());
    }

    /**
     * Tests the {@link ApiRequest#readResponse(String)} method for parsing the received data.
     */
    @Test
    public void readResponse() throws ApiResponseException {
        ApiRequest<String> request = new ApiRequest<String>("test") {
            @Override
            public String readResponse(String response) {
                return "test" + response;
            }
        };
        assertEquals("testabc", request.readResponse("abc"));
    }
}