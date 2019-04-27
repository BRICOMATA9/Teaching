package tp6;

import java.io.EOFException;

public abstract class JsonValue {
    public abstract void parse( Lexer l ) throws JsonParseException, EOFException;

}
