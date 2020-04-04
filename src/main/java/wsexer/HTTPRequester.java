package wsexer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HTTPRequester {

    public static String makeHTTPRequest(String endPoint, String idOrName) {
        String urlString = "https://pokeapi.co/api/v2/"+endPoint+"/"+idOrName;
        String response = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection= (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            connection.setRequestMethod("GET");
            connection.connect();
            Scanner responseScanner = new Scanner(connection.getInputStream());
            while (responseScanner.hasNext()) {
                response = responseScanner.nextLine();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            connection.disconnect();
        }
        return response;
    }
}
