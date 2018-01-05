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

    private ApiClient(String baseUrl) throws MalformedURLException {
        this.baseUrl = new URL(baseUrl);
    }

    public static ApiClient getInstance() {
        return instance;
    }

    public static void setInstance(String baseUrl) throws MalformedURLException {
        instance = new ApiClient(baseUrl);
    }

    public String getResponseString(ApiRequest request) throws IOException {
        URL url = new URL(baseUrl, request.getEndpoint());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) throw new IOException();
        return new Scanner(connection.getInputStream(), "UTF-8").useDelimiter("\\A").next();
    }

    public <T> T performRequest(ApiRequest<T> request) throws IOException, ApiResponseException {
        return request.readResponse(getResponseString(request));
    }
}
