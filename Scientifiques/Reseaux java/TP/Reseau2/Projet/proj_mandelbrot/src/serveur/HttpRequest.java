package serveur;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    protected String              fileName;
    protected Map<String, String> parameters;

    public HttpRequest( String request ) {
        this.fileName = extractFileName( request );
    }

    public static String extractFileName( String url ) {
        if ( url.equals( "/" ) ) {
            return "index.htlm";
        } else if ( url.indexOf( "?" ) == -1 ) {
            return url.substring( 1, url.length() - 1 );
        } else {
            return url.substring( 1, url.indexOf( "?" ) );
        }
    }

    public static Map<String, String> extractParameters( String url ) {
        if ( url.equals( "/" ) || url.indexOf( "?" ) == -1
                || url.substring( url.indexOf( "?" ) + 1, url.length() - 1 ).equals( "" ) )
            return null;
        else {
            Map<String, String> parameters = new HashMap<String, String>();
            url = url.substring( url.indexOf( "?" ) + 1, url.length() );
            String[] params = url.split( "&" );
            for ( String s : params ) {
                String name = s.split( "=" )[0].trim();
                String value = s.split( "=" )[1].trim();
                parameters.put( name, value );
            }
            return parameters;
        }
    }
}
