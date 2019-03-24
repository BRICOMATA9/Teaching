package tp6;

public class JsonParseException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 2157535721374080168L;
    int                       position;
    char                      found;
    char                      expected;

    public JsonParseException( int p, char f, char e ) {
        super( "JsonParseException [position=" + p + ", found=" + f + ", expected=" + e + "]" );
        position = p;
        found = f;
        expected = e;

    }

    @Override
    public String toString() {
        return "JsonParseException [position=" + position + ", found=" + found + ", expected=" + expected + "]";
    }

}
