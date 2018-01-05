package eu.woelflein.adventizr.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A request to get the current API status.
 */
public class GetStatusRequest extends ApiRequest<Boolean> {

    /**
     * Constructor.
     */
    public GetStatusRequest() {
        super("status");
    }

    /**
     * Read the API response.
     *
     * @param response the response String
     * @return true if it is running, false otherwise
     */
    @Override
    public Boolean readResponse(String response) {
        try {
            return new JSONObject(response).getString("status").equals("running");
        } catch (JSONException e) {
            return false;
        }
    }
}
