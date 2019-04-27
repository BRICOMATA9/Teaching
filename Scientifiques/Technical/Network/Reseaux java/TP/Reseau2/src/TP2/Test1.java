
public class Test1 implements MySerialisable {
	String s;
	int i;
	Test2 t;
	
	public Test1(){}
	
	public Test1(String s,Test2 t,int i){
		this.s=s;
		this.i=i;
		this.t=t;
	}
	
	public void writeToBuff(SerializerBuffer ms){
		ms.writeInt(i);
		ms.writeString(s);
		t.writeToBuff(ms);
	}
	
	public String toString() {
        return "Test1 [i=" + this.i + this.t + ", s=" + this.s + "]";
    }
	
	public void readFromBuff(SerializerBuffer ms){
		i = ms.readInt();
		s = ms.readString();
		t = new Test2();
		t.readFromBuff(ms);
	}
	//public static final Creator<Test1> CREATOR= new MySerialisable.Creator<Test1>(){
		//public Test1 init(){return new Test1();}
	//}
	
	
	public static void main(String[] args) {
		Test2 tT2 = new Test2(3.14f,2.7f);
		Test1 t = new Test1("foo€Test",null,32);
		System.out.println("Pre :"+t);
		SerializerBuffer sb = new SerializerBuffer(1024);
		t.writeToBuff(sb);
		sb.buffer.flip();
		Test1 t2 = new Test1();
		t2.readFromBuff(sb);
		System.out.println("Post :"+t2);
	}
	
}
