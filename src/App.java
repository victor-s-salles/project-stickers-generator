import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // String url = "https://imdb-api.com/en/API/Top250Movies/KEY";

        // Caso a api do IMBD esteja instável
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        URI address = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(address).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();

        // System.out.println(body);

        JsonParser parser = new JsonParser();

        List<Map<String, String>> filmsList = parser.parse(body);

        // System.out.println(filmsList.size());

        for (Map<String, String> film : filmsList) {
            System.out.println(film.get("title"));
            System.out.println(film.get("image"));
            System.out.println(film.get("imDbRating"));
            System.out.println();
        }
    }
}
