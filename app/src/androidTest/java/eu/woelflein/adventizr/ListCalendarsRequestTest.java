package eu.woelflein.adventizr;

import eu.woelflein.adventizr.api.ApiRequest;
import eu.woelflein.adventizr.api.ApiResponseException;
import eu.woelflein.adventizr.api.ListCalendarsRequest;
import eu.woelflein.adventizr.calendar.CalendarInfo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * A test class for the {@link ListCalendarsRequest} class.
 */
public class ListCalendarsRequestTest {

    /**
     * Tests that the request points to the correct API endpoint.
     */
    @Test
    public void apiEndpoint() {
        assertEquals("calendars", new ListCalendarsRequest().getEndpoint());
    }

    /**
     * Tests the {@link ListCalendarsRequest#readResponse(String)} method with a sample JSON response.
     */
    @Test
    public void readResponse() throws ApiResponseException {
        String json = "[{\"_id\":\"uo387NeabZCEXwSX3\",\"title\":\"testing\",\"description\":\"t\"," +
                "\"user\":{\"_id\":\"xPaQENoTTLuA7Aaod\",\"username\":\"georg\"}," +
                "\"created\":\"2017-12-25T16:09:41.819Z\",\"updated\":\"2017-12-26T15:32:48.298Z\"}]";
        ApiRequest<List<CalendarInfo>> request = new ListCalendarsRequest();
        List<CalendarInfo> calendars = request.readResponse(json);
        assertEquals(1, calendars.size());
        CalendarInfo first = calendars.get(0);
        assertEquals("uo387NeabZCEXwSX3", first.getId());
        assertEquals("testing", first.getTitle());
    }

}