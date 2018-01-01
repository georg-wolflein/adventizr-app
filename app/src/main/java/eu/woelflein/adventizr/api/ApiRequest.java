package eu.woelflein.adventizr.api;

public abstract class ApiRequest<T> {

    private String endpoint;

    public ApiRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public abstract T readResponse(String response) throws ApiResponseException;
}
