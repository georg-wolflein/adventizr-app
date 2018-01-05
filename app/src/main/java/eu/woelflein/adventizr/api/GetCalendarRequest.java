package eu.woelflein.adventizr.api;

import eu.woelflein.adventizr.calendar.CalendarInfo;
import org.json.JSONException;

/**
 * A request to get a specific calendar's info.
 */
public class GetCalendarRequest extends ApiRequest<CalendarInfo> {

    /**
     * Constructor.
     *
     * @param id the calendar's ID
     */
    public GetCalendarRequest(String id) {
        super("calendars/" + id);
    }

    @Override
    public CalendarInfo readResponse(String response) throws ApiResponseException {
        try {
            return CalendarInfo.fromJson(response);
        } catch (JSONException e) {
            throw new ApiResponseException();
        }
    }
}
