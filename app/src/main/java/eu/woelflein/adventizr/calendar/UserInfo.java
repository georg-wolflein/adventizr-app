package eu.woelflein.adventizr.calendar;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class representing a user's basic information.
 */
public class UserInfo {

    private String id;
    private String username;

    /**
     * Parse a {@link UserInfo} object from its JSON representation.
     *
     * @param json the JSON string
     * @return the {@link UserInfo} object
     * @throws JSONException if the JSON could not be parsed
     */
    public static UserInfo fromJson(String json) throws JSONException {
        UserInfo userInfo = new UserInfo();
        JSONObject object = new JSONObject(json);
        userInfo.id = object.getString("_id");
        userInfo.username = object.getString("username");
        return userInfo;
    }

    /**
     * Get the user ID.
     *
     * @return the user ID
     */
    public String getId() {
        return id;
    }

    /**
     * Get the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }
}
