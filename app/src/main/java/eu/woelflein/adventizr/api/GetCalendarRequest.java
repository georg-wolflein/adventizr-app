package eu.woelflein.adventizr.api;

import org.json.JSONException;

public class GetCalendarRequest extends ApiRequest<CalendarInfo> {

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
