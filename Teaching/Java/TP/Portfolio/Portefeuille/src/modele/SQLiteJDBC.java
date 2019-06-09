package modele;
import java.sql.*;

public class SQLiteJDBC
{


	public static Statement connexionbddSQLITE(){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			c = DriverManager.getConnection("jdbc:sqlite:base_projet_info_gigabytse.bd");
			stmt=c.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	/*
	public static void creerbdd(){
		Statement stmt=connexionbddSQLITE();

		String creer_tableau_alice ="CREATE TABLE  Tableau_Alice( Entreprises VARCHAR DEFAULT null, ID VARCHAR DEFAULT null, nombre_actions VARCHAR DEFAULT null, valeur_action VARCHAR DEFAULT null, total VARCHAR DEFAULT null)";
		String creer_tableau_Yahoo_CAC40 ="CREATE TABLE Liste_Entreprises_Yahoo_CAC40 (Entreprises VARCHAR DEFAULT null, ID VARCHAR DEFAULT null)";
		String creer_tableau_combobox="CREATE TABLE tableau_combobox_achat_vente (Type_Transaction VARCHAR DEFAULT null, Entreprises VARCHAR DEFAULT null, ID VARCHAR DEFAULT null, nombres_actions int DEFAULT null)";
		String remplir_tableau_Yahoo_CAC40="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Accor','AC.PA')";
		String r2= "INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Credit Agricole','ACA.PA')";
		String r3 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Air Liquide','AI.PA')";
		String r4 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('AIRBUS GROUP','AIR.PA')";
		String r5 = "INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Alstom','ALO.PA')";
		String r6 = "INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Alcatel-Lucent','ALU.PA')";
		String r7 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Danone','BN.PA')";
		String r8 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('BNP Paribas','BNP.PA')";
		String r9 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Carrefour','CA.PA')";
		String r10= "INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Cap Gemini','CAP.PA')";
		String r11 = "INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('AXA Group','CS.PA')";
		String r12 = "INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('VINCI','DG.PA')";
		String r13 = "INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Electricité de France','EDF.PA')";
		String r14 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Essilor International','EI.PA')";
		String r15="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Bouygues','EN.PA')";
		String r16="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('TOTAL','FP.PA')";
		String r17="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Valeo','FR.PA')";
		String r18="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Société Generale Group','GLE.PA')";
		String r19 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('ENGIE','GSZ.PA')";
		String r20 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Kering','KER.PA')";
		String r21 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Lafarge','LG.PA')";
		String r22 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Legrand','LR.PA')";
		String r23="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('LVMH Moët Hennessy Louis Vuitton','MC.PA')";
		String r24="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Compagnie Generale DES Etablissements Michelin','ML.PA')";
		String r25="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('ARCELORMITAL REG','MT.PA')";
		String r26="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Oral','OR.PA')";
		String r27="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Orange','ORA.PA')";
		String r28="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Publicis Groupe','PUB.PA')";
		String r29="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Pernod-Ricard','RI.PA')";
		String r30="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Renault','RNO.PA')";
		String r31="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Safran','SAF.PA')";
		String r32="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Sanofi','SAN.PA')";
		String r33="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Compagnie de Saint-Gobain','SGO.PA')";
		String r34="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('SOLVAY','SOLB.PA')";
		String r35="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Schneider Electric','SU.PA')";
		String r36="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Technip','TEC.PA')";
		String r37="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Peugeot','UG.PA')";
		String r38="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Unibail-Rodamco','UL.PA')";
		String r39="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Veolia Environnement','VIE.PA')";
		String r40 ="INSERT INTO Liste_Entreprises_Yahoo_CAC40 VALUES('Vivendi','VIV.PA')";
		try {
			stmt.executeUpdate(creer_tableau_alice);
			stmt.executeUpdate(creer_tableau_Yahoo_CAC40);
			stmt.executeUpdate(creer_tableau_combobox);
			stmt.executeUpdate(remplir_tableau_Yahoo_CAC40);
			stmt.executeUpdate(r2);
			stmt.executeUpdate(r3);
			stmt.executeUpdate(r4);
			stmt.executeUpdate(r5);
			stmt.executeUpdate(r6);
			stmt.executeUpdate(r7);
			stmt.executeUpdate(r8);
			stmt.executeUpdate(r9);
			stmt.executeUpdate(r10);
			stmt.executeUpdate(r11);
			stmt.executeUpdate(r12);
			stmt.executeUpdate(r13);
			stmt.executeUpdate(r14);
			stmt.executeUpdate(r15);
			stmt.executeUpdate(r16);
			stmt.executeUpdate(r17);
			stmt.executeUpdate(r18);
			stmt.executeUpdate(r19);
			stmt.executeUpdate(r20);
			stmt.executeUpdate(r21);
			stmt.executeUpdate(r22);
			stmt.executeUpdate(r23);
			stmt.executeUpdate(r24);
			stmt.executeUpdate(r25);
			stmt.executeUpdate(r26);
			stmt.executeUpdate(r27);
			stmt.executeUpdate(r28);
			stmt.executeUpdate(r29);
			stmt.executeUpdate(r30);
			stmt.executeUpdate(r31);
			stmt.executeUpdate(r32);
			stmt.executeUpdate(r33);
			stmt.executeUpdate(r34);
			stmt.executeUpdate(r35);
			stmt.executeUpdate(r36);
			stmt.executeUpdate(r37);
			stmt.executeUpdate(r38);
			stmt.executeUpdate(r39);
			stmt.executeUpdate(r40);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	//}
}