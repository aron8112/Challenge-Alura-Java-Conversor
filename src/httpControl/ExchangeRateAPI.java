package httpControl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.*;

public class ExchangeRateAPI {

  private static final String API_KEY = "41fb87d384f9f437e44fd081";
  private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
  public ApiResponse apiResponse;

  // Método para obtener la tasa de cambio entre dos monedas
  public ApiResponse obtenerTasaCambio(String codigoOrigen, String codigoDestino, double monto) {
    String urlString = BASE_URL + API_KEY + "/pair/" + codigoOrigen + "/" + codigoDestino + "/" + monto;

    Gson gson = new GsonBuilder()
//        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();
    ApiResponse apiResponse;

    try {
      // Crear la URL y abrir la conexión

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(urlString))
          .build();
      HttpResponse<String> response = client
          .send(request, HttpResponse.BodyHandlers.ofString());

      String json = response.body();
      System.out.println(json);
      this.apiResponse = gson.fromJson(json, ApiResponse.class);
      System.out.println(this.apiResponse);
    } catch (Exception e) {
      System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
    }
      return this.apiResponse;
  }
}

