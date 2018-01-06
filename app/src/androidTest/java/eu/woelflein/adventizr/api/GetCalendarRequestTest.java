package eu.woelflein.adventizr.api;

import eu.woelflein.adventizr.calendar.CalendarInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the {@link GetCalendarRequest} class.
 */
public class GetCalendarRequestTest {

    /**
     * Tests that the request points to the correct API endpoint.
     */
    @Test
    public void apiEndpoint() {
        assertEquals("calendars/abc", new GetCalendarRequest("abc").getEndpoint());
    }

    /**
     * Tests the {@link GetCalendarRequest#readResponse(String)} method with a sample JSON response.
     */
    @Test
    public void readResponse() throws ApiResponseException {
        String json = "{\"_id\":\"uo387NeabZCEXwSX3\",\"title\":\"testing\",\"description\":\"t\"," +
                "\"user\":{\"_id\":\"xPaQENoTTLuA7Aaod\",\"username\":\"georg\"}," +
                "\"created\":\"2017-12-25T16:09:41.819Z\",\"updated\":\"2017-12-26T15:32:48.298Z\"}";
        CalendarInfo calendar = new GetCalendarRequest("uo387NeabZCEXwSX3").readResponse(json);
        assertEquals("uo387NeabZCEXwSX3", calendar.getId());
        assertEquals("testing", calendar.getTitle());
    }
}