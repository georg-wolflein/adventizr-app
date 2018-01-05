package eu.woelflein.adventizr.api;

import org.json.JSONException;
import org.json.JSONObject;

public class GetStatusRequest extends ApiRequest<Boolean> {

    public GetStatusRequest() {
        super("status");
    }

    @Override
    public Boolean readResponse(String response) throws ApiResponseException {
        try {
            return new JSONObject(response).getString("status").equals("running");
        } catch (JSONException e) {
            throw new ApiResponseException();
        }
    }
}
