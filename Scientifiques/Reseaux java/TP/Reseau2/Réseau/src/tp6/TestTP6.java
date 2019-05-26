package tp6;

import java.io.EOFException;

public class TestTP6 {

    public static void main( String[] args ) throws EOFException, JsonParseException {
        StringLexer sl = new StringLexer( "\"test\"" );
        JsonValue jv = new JsonString();
        jv.parse( sl );
        System.out.println( jv.toString() );

    }

}
