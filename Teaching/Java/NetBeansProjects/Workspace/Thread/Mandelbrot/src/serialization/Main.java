package serialization;

public class Main {

	private static SerializerBuffer buffer;
	
    public static void main( String[] args ) {
            buffer = new SerializerBuffer(1024);
            
            Objet o = new Objet(2232);
            buffer.writeMySerializable( o );
            
            buffer.getBuffer().clear();
            Objet o2 = buffer.readMySerializable( Objet.CREATOR );
            
            System.out.println(o2.getI());
    }
}


