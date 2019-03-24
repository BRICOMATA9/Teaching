package tp6;

import java.io.EOFException;

public class StringLexer implements Lexer {
    private String str;
    private int    position;

    public StringLexer( String str ) {
        this.str = str;
        position = 0;
    }

    @Override
    public char current() {
        return str.charAt( position );
    }

    @Override
    public char get() throws EOFException {
        char c = current();
        if ( position < str.length() - 1 ) {
            position++;
            return c;
        } else {
            throw new EOFException();
        }
    }

    @Override
    public void skipWhiteSpace() {
        while ( Character.isWhitespace( current() ) && position < str.length() ) {
            position++;
        }
    }

    @Override
    public void next() throws EOFException {
        get();
        skipWhiteSpace();
    }

    @Override
    public void check( char c ) throws JsonParseException {
        if ( current() != c )
            throw new JsonParseException( position, current(), c );
    }
}
