package eu.woelflein.adventizr.api;

public abstract class ApiRequest<T> {

    private String endpoint;

    public ApiRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    public static ApiRequest<String> forEndpoint(String endpoint) {
        return new ApiRequest<String>(endpoint) {
            @Override
            public String readResponse(String response) {
                return response;
            }
        };
    }

    public String getEndpoint() {
        return endpoint;
    }

    public abstract T readResponse(String response) throws ApiResponseException;
}
