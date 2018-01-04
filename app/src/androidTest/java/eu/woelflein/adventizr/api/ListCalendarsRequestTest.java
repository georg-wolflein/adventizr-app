package eu.woelflein.adventizr.api;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ListCalendarsRequestTest {

    /**
     * Tests the {@link ListCalendarsRequest#readResponse(String)} method with a sample JSON response.
     */
    @Test
    public void readResponse() throws ApiResponseException {
        String json = "[{\"_id\":\"uo387NeabZCEXwSX3\",\"title\":\"testing\",\"description\":\"t\",\"user\":{\"_id\":\"xPaQENoTTLuA7Aaod\",\"username\":\"georg\"},\"created\":\"2017-12-25T16:09:41.819Z\",\"updated\":\"2017-12-26T15:32:48.298Z\"}]";
        ApiRequest<List<CalendarInfo>> request = new ListCalendarsRequest();
        List<CalendarInfo> calendars = request.readResponse(json);
        assertEquals(1, calendars.size());
        CalendarInfo first = calendars.get(0);
        assertEquals("uo387NeabZCEXwSX3", first.getId());
        assertEquals("testing", first.getTitle());
    }

}