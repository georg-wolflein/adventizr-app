package eu.woelflein.adventizr.api;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class CalendarInfo {

    private String id;
    private String title;
    private String description;
    private UserInfo user;
    private Date created;
    private Date updated;

    public static CalendarInfo fromJson(String json) throws JSONException {
        CalendarInfo calendarInfo = new CalendarInfo();
        JSONObject object = new JSONObject(json);
        calendarInfo.id = object.getString("_id");
        calendarInfo.title = object.getString("title");
        calendarInfo.description = object.getString("description");
        calendarInfo.user = UserInfo.fromJson(object.getJSONObject("user").toString());
        // TODO: parse created and updated
        return calendarInfo;
    }
}
