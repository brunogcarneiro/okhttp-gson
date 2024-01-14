package carneiro.bruno;

import carneiro.bruno.jsonparser.JsonParser;
import carneiro.bruno.model.ApiResponse;
import carneiro.bruno.model.UserData;
import carneiro.bruno.restclient.RestClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        try {
            RestClient restClient = new RestClient();

            // Make HTTP Request
            String path = "https://platform.brexapis.com/interview/test";
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept","application/json");
            String jsonResponse = restClient.get(path, headers);

            // Parse JSON Response
            JsonParser<ApiResponse> parser = new JsonParser<>(ApiResponse.class);
            ApiResponse apiResponse = parser.parse(jsonResponse);

            // Print results
            for (UserData userData : apiResponse.getData()) {
                System.out.println("Company: " + userData.getCompany());
                System.out.println("Created At: " + userData.getCreatedAt());
                System.out.println("Name: " + userData.getName());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
