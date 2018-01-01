package eu.woelflein.adventizr.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiClient {

    private URL baseUrl;

    public ApiClient(URL baseUrl) {
        this.baseUrl = baseUrl;
    }

    private String getResponseString(ApiRequest request) throws IOException {
        URL url = new URL(baseUrl, request.getEndpoint());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) throw new IOException();
        return new Scanner(connection.getInputStream(), "UTF-8").useDelimiter("\\A").next();
    }

    public <T> T performRequest(ApiRequest<T> request) throws IOException, ApiResponseException {
        return request.readResponse(getResponseString(request));
    }
}
