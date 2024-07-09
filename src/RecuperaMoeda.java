import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RecuperaMoeda {

    public Moeda buscaMoeda(String base_code, String target_code){
        URI moedaConvertida = URI.create("https://v6.exchangerate-api.com/v6/a3e72daeb934fb85e887fa81/pair/" + base_code + "/" + target_code);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(moedaConvertida)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moeda.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter informações a partir dessa Moeda");
        }
    }
}
