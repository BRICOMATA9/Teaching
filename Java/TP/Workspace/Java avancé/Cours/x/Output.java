package TD5;
import java.lang.reflect.*;
import java.util.Arrays;
class Output {
        

        // version to be called from static methods: 
	    //works for classes containing only static variables and with an empty constructor
	/*public Output () {
		Class c = null;
                Object ob = null;
                StackTraceElement[] st = Thread.currentThread().getStackTrace();
                //for (int i=0; i<st.length; i++) System.out.println(st[i]);
              	
                try {
                  c=Class.forName(st[2].getClassName());
                  ob = c.newInstance();
                } 
                catch (ClassNotFoundException ex) {}
                catch (InstantiationException ex) {}
                catch (IllegalAccessException ex) {System.out.println(ex);}
                System.out.println(c);
                show(c.getDeclaredFields(),ob);
              
        }*/

        public static void show () {
		        Class<?> c = null;
                Object ob = null;
                StackTraceElement[] st = Thread.currentThread().getStackTrace();
                for (int i=0; i<st.length; i++) System.out.println(st[i]);
              	
                try {
                  c=Class.forName(st[2].getClassName());
                  ob = c.newInstance();
                } 
                catch (ClassNotFoundException |
                	   InstantiationException |
                       IllegalAccessException ex) {System.out.println(ex);}
                System.out.println(c);
                show(c.getDeclaredFields(),ob);
        }


        // version to be called from instance methods: 
        //it shows static and nonstatic variables of the object in argument
	    
        public static void show (Field[] fields,Object ob) {
           System.out.println("Variable content:");
           for ( Field field : fields  ) 
                try {
                  System.out.println (field.getName() + 
                		              ": " + 
                		              affiche(field.get(ob)));
                } catch ( IllegalAccessException ex ) {System.out.println(ex);}
	    }
 
        
        public static String affiche (Object ob) {
                String s;
		  if (ob instanceof Object[]|| 
		      ob instanceof int[] ||
		      ob instanceof char[]|| 
		      ob instanceof boolean[]|| 
		      ob instanceof double[])//not complete 
           {  s="{";
		   for (int i=0; i<Array.getLength(ob)-1; i++)
			  s = s+affiche(Array.get(ob,i))+",";
              s = s+affiche(Array.get(ob,Array.getLength(ob)-1))+"}";
                   //s=Arrays.deepToString(((Object[])ob));
                  }                   
          else s=ob.toString();
          return s;
        }


}   