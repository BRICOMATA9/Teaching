public class test1{
	public static void main(String[] args){
		int j,i=j=0;
		while(j<5){
			i=0;
			while(i<5){
				if (i==3)break;
				System.out.println(i);
				i++;
			}
			System.out.println("sortir1");
			if (j==3)break;
			j++;
		}
		System.out.println("sortir2");
	}
}
