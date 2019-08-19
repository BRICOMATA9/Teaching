import java.lang.reflect.*;
import java.util.Arrays;
class ShowVariables {
        public static void show (Object ob) {
                
		Class c = ob.getClass();   
                System.out.println(c);  	
                show(c.getDeclaredFields(),ob);
        }


        public static void show (Field[] fields,Object ob) {
           System.out.println("Variable content:");
           for ( Field field : fields  ) 
                try {
                  System.out.println (field.getName() + ": " 
                                      + deepToString(field.get(ob)));
                } 
                catch ( IllegalAccessException ex ) {System.out.println(ex);}
	}
 


        public static String deepToString (Object ob) {
                String s;
		if (ob instanceof Object[]|| 
                    ob instanceof int[] ||
                    ob instanceof char[]|| 
                    ob instanceof boolean[]|| 
                    ob instanceof double[])       //not complete 
                  {  s="{";
                   if (Array.getLength(ob)!=0){
	 		   for (int i=0; i<Array.getLength(ob)-1; i++)
				s = s+deepToString(Array.get(ob,i))+",";
         	          s = s+deepToString(Array.get(ob,Array.getLength(ob)-1));
                   }
                   s=s+"}";
                  }                   
                else if (ob == null) s="non initialisée";
                     else s=ob.toString();
                return s;
        }

}   

class A {
	 int x = 5;
	 boolean[] tab = new boolean[5];
	 double d = 3.4;
	 Object o;
}



class AppShow {
	public static void main (String[] args) {
		A a = new A();
		ShowVariables.show(a);
                a.x = 12;
		ShowVariables.show(a);		

	}
}
