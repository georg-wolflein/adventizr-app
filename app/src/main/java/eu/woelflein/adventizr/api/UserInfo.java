package eu.woelflein.adventizr.api;

import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo {

    private String id;
    private String username;

    public static UserInfo fromJson(String json) throws JSONException {
        UserInfo userInfo = new UserInfo();
        JSONObject object = new JSONObject(json);
        userInfo.id = object.getString("_id");
        userInfo.username = object.getString("username");
        return userInfo;
    }
}
