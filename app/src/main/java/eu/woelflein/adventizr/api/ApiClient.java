package eu.woelflein.adventizr.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * A client for the adventizr API.
 */
public class ApiClient {

    private URL baseUrl;
    private static ApiClient instance;

    /**
     * Constructor.
     *
     * @param baseUrl the base URL of the API
     * @throws MalformedURLException if the URL was malformed
     */
    private ApiClient(String baseUrl) throws MalformedURLException {
        this.baseUrl = new URL(baseUrl);
    }

    /**
     * Get the instance of the client.
     *
     * @return the {@link ApiClient}, or null if {@link #setInstance(String)} was not called before.
     */
    public static ApiClient getInstance() {
        return instance;
    }

    /**
     * Set the instance of the client.
     *
     * @param baseUrl the base URL of the API
     * @throws MalformedURLException if the URL was malformed
     */
    public static void setInstance(String baseUrl) throws MalformedURLException {
        instance = new ApiClient(baseUrl);
    }

    /**
     * Get the response of an API request as a String.
     *
     * @param request the {@link ApiRequest}
     * @return the response as a String
     * @throws IOException if there was a problem communicating with the API
     */
    public String getResponseString(ApiRequest request) throws IOException {
        URL url = new URL(baseUrl, request.getEndpoint());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) throw new IOException();
        return new Scanner(connection.getInputStream(), "UTF-8").useDelimiter("\\A").next();
    }

    /**
     * Perform an API request and get the parsed response.
     *
     * @param request the {@link ApiRequest}
     * @param <T>     the return type of the response
     * @return the parsed response
     * @throws IOException          if there was a problem communicating with the API
     * @throws ApiResponseException if the response could not be parsed by the {@link ApiRequest#readResponse(String)} method
     */
    public <T> T performRequest(ApiRequest<T> request) throws IOException, ApiResponseException {
        return request.readResponse(getResponseString(request));
    }
}
