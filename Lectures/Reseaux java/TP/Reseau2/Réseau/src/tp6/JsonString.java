package tp6;

import java.io.EOFException;

public class JsonString extends JsonValue {
    String value;

    @Override
    public void parse( Lexer l ) throws JsonParseException, EOFException {
        l.check( '"' );
        l.get();
        StringBuilder stringBuilder = new StringBuilder();
        char c = l.current();
        boolean echap = false;
        while ( c != '"' || echap ) {
            echap = c == '\\';
            if ( !echap ) {
                stringBuilder.append( c );
            }
            l.get();
            c = l.current();
        }
        l.get();
        value = stringBuilder.toString();

    }

    public JsonString() {
        value = null;
    }

    public JsonString( String s ) {
        value = s;
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }

}
