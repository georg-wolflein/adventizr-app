package eu.woelflein.adventizr.api;

/**
 * A request to the API.
 *
 * @param <T> the type of the response (after parsing it).
 */
public abstract class ApiRequest<T> {

    private String endpoint;

    /**
     * Constructor.
     *
     * @param endpoint the API endpoint
     */
    public ApiRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Create a simple {@link ApiRequest <String>} that returns the response String.
     *
     * @param endpoint the API endpoint
     * @return the {@link ApiRequest <String>} object
     */
    public static ApiRequest<String> forEndpoint(String endpoint) {
        return new ApiRequest<String>(endpoint) {
            @Override
            public String readResponse(String response) {
                return response;
            }
        };
    }

    /**
     * Get the API endpoint.
     *
     * @return the API endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Read the response and convert it to type {@link T}.
     * This method must be implemented.
     *
     * @param response the response String
     * @return the converted response as type {@link T}
     * @throws ApiResponseException if the response String could not be converted
     */
    public abstract T readResponse(String response) throws ApiResponseException;
}
