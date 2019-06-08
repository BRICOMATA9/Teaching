import java.sql.* ;
 import java.io.* ;
 import java.sql.DriverManager;

import java.sql.ResultSet;

 public  class test4 {

    public  static  void main (String[] args) {
       try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.jdbc.Driver") ;
         Driver pilote = (Driver)c.newInstance() ;
          // enregistrement du pilote auprès du DriverManager
         DriverManager.registerDriver(pilote);
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Nom de la base ;
         String nomBase =  "gentoo" ;  // dépend du contexte
          // Chaîne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "aghiles" ;  // dépend du contexte
         String motDePasse =  "aghilesDJ35B" ;  // dépend du contexte
          // Connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;

          // Envoi d’un requête générique
          
         String sql =  "USE gentoo" ;
         Statement smt = con.createStatement() ;
         ResultSet rs = smt.executeQuery(sql) ; 

         sql =  "SELECT * FROM developers" ;
         smt = con.createStatement() ;
         rs = smt.executeQuery(sql) ;
          while (rs.next()) {
            System.out.println(rs.getString(1)) ;
         }
      }  catch (Exception e) {
          // gestion des exceptions
      }
   }
}
