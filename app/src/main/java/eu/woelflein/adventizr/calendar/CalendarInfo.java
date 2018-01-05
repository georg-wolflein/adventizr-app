package eu.woelflein.adventizr.calendar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * A class representing a calendar's basic information.
 */
public class CalendarInfo {

    private String id;
    private String title;
    private String description;
    private UserInfo user;
    private Date created;
    private Date updated;

    /**
     * Parse a {@link CalendarInfo} object from its JSON representation.
     *
     * @param json the JSON string
     * @return the {@link CalendarInfo} object
     * @throws JSONException if the JSON could not be parsed
     */
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

    /**
     * Get the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Get the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the user.
     *
     * @return the user
     */
    public UserInfo getUser() {
        return user;
    }

    /**
     * Get the date of creation.
     *
     * @return the date of creation
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Get the date it was last updated.
     *
     * @return the date it was last updated
     */
    public Date getUpdated() {
        return updated;
    }
}
