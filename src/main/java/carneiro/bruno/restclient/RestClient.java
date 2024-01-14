package carneiro.bruno.restclient;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;


public class RestClient
{
    private final OkHttpClient client;

    public RestClient() {
        this.client = new OkHttpClient();
    }

    public String get(String path, Map<String, String> headers) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(path);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            requestBuilder = requestBuilder.header(entry.getKey(), entry.getValue());
        }

        Request request = requestBuilder.build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String post(String path, Map<String, String> headers, String body) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(path);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            requestBuilder = requestBuilder.header(entry.getKey(), entry.getValue());
        }

        RequestBody requestBody = RequestBody.create(body, MediaType.parse("application/json"));
        Request request = requestBuilder.post(requestBody).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
