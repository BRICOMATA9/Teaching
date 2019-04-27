
public class Test2 implements MySerialisable{

	float f1,f2;
	
	public Test2() {};
	
	public Test2(float f1, float f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
	}

	@Override
	public void writeToBuff(SerializerBuffer ms) {
		ms.writeFloat(f1);
		ms.writeFloat(f2);
		
	}
	
	public void readFromBuff( SerializerBuffer ms ) {
        this.f1 = ms.readFloat();
        this.f2 = ms.readFloat();
    }

    @Override
    public String toString() {
        return " ,Test2 [F1=" + this.f1 + ", F2=" + this.f2 + "]";
    }
    
 // public static final Creator<Test2> CREATOR= new MySerialisable.Creator<Test2>(){
  		//public Test2 init(){return new Test2();}
  	//}
}
	

