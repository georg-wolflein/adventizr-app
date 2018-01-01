package eu.woelflein.adventizr.api;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListCalendarsRequestTest {
    @Test
    public void readResponse() throws ApiResponseException {
        String json = "[{\"_id\":\"uo387NeabZCEXwSX3\",\"title\":\"testing\",\"description\":\"t\",\"user\":{\"_id\":\"xPaQENoTTLuA7Aaod\",\"username\":\"georg\"},\"created\":\"2017-12-25T16:09:41.819Z\",\"updated\":\"2017-12-26T15:32:48.298Z\"}]";
        ApiRequest<List<CalendarInfo>> request = new ListCalendarsRequest();
        List<CalendarInfo> calendars = request.readResponse(json);
        for (CalendarInfo c : calendars) {

        }
    }

}