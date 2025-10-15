package employeeManager.services;

import com.google.gson.Gson;
import employeeManager.model.ApiResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private final static String API_ROOT_URI = "https://randomuser.me/api/?seed=foobar";
    private final HttpClient httpClient;
    private final Gson gson;

    public ApiService() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ApiResponse getResults(int amount) {
        URI API_ENDPOINT = URI.create(API_ROOT_URI + "&results=" + amount);
        try {
            HttpRequest request = HttpRequest.newBuilder(API_ENDPOINT).GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ensureSuccess(response, API_ENDPOINT.toString());
            return gson.fromJson(response.body(), ApiResponse.class);
        } catch (InterruptedException | IOException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La solicitud fue interrumpida mientras se consultaba: " + API_ENDPOINT, e);
        }
    }

    private void ensureSuccess(HttpResponse<?> response, String url) {
        if (response.statusCode() >= 400) {
            throw new RuntimeException("La llamada " + url + " ha fallado con el código " + response.statusCode());
        }
    }

}
