package api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
            public static NewResponse connect(String base_code, String target_code, int amount){
                try {
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("https://v6.exchangerate-api.com/v6/a9603a5ca8e8c9031aa3a6e6/pair/"+base_code+"/"+target_code+"/"+amount))
                            .build();

                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    return gson.fromJson(json, NewResponse.class );
                }catch (Exception e){
                    System.out.println("Error: " + e);
                    return null;
                }
            }

}
