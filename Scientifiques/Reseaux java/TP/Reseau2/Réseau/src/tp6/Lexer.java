package tp6;

import java.io.EOFException;

public interface Lexer {
    public char current();

    public char get() throws EOFException;

    public void skipWhiteSpace();

    public void next() throws EOFException;

    public void check( char c ) throws JsonParseException;

}
