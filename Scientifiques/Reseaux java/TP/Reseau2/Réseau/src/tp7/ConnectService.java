package tp7;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConnectService {

    public static JsonElement get( String s ) throws IOException {
        URL url = new URL( "https://api.sncf.com/v1/coverage/sncf/places" + s );
        HttpsURLConnection connexion = (HttpsURLConnection) url.openConnection();

        String mdp = Base64.getEncoder().encodeToString( "82ee4aa2-ecf2-4844-b9a1-0bcbff7a285e:".getBytes() );
        connexion.setRequestProperty( "Authorization", "Basic " + mdp );
        // System.out.println( connexion.getResponseCode() );
        InputStream is = connexion.getInputStream();
        InputStreamReader isr = new InputStreamReader( is );
        JsonParser jparser = new JsonParser();
        JsonElement je = jparser.parse( isr );
        return je;
    }

    public static Map<String, String> getGares( String s ) throws IOException {
        Map<String, String> gares = new HashMap<String, String>();
        JsonElement je = get( s );
        JsonObject jo = je.getAsJsonObject();
        JsonArray jA = jo.getAsJsonArray( "places" );
        for ( JsonElement e : jA ) {
            JsonObject obj = e.getAsJsonObject();
            if ( obj.get( "embedded_type" ).getAsString().equals( "stop_area" ) ) {
                String id = obj.get( "id" ).getAsString();
                String name = obj.get( "name" ).getAsString();
                gares.put( id, name );
            }

        }
        return gares;
    }

    public static void main( String[] args ) throws IOException {
        ConnectService cs = new ConnectService();
        String s = "?q={velizy}";
        Map<String, String> gares = getGares( s );

        for ( String k : gares.keySet() ) {
            System.out.println( k + " " + gares.get( k ) );
        }
    }

}
