package SQL;

public class SQL {
	//Methode que retourne la chaine de caractere pour select 
	public String Query_Select(String[] table, String[] filed, String condition) {
		String Str_query = "SELECT " + filed[0];
		for (int i = 1; i < filed.length; i++)
			Str_query = Str_query + "," + filed[i];

		Str_query = Str_query + " FROM " + table[0];
		for (int i = 1; i < table.length; i++)
			Str_query = Str_query + "," + table[i];
		if (condition.length() > 0)
			Str_query = Str_query + " WHERE " + condition;
		return Str_query;
	}

	//Methode que retourne la chaine de caractere pour select distinct
	public String Query_Select_Distinct(String[] table, String[] filed, String condition) {
		String Str_query = "SELECT DISTINCT " + filed[0];
		for (int i = 1; i < filed.length; i++)
			Str_query = Str_query + "," + filed[i];

		Str_query = Str_query + " FROM " + table[0];
		for (int i = 1; i < table.length; i++)
			Str_query = Str_query + "," + table[i];
		if (condition.length() > 0)
			Str_query = Str_query + " WHERE " + condition;
		return Str_query;
	}
	
	//Methode que retourne la chaine de caractere pour updtae
	public String Query_Update(String table, String[] filed, String[] value, String condition) {
		if (filed.length != value.length) return "";

		String Str_query = "UPDATE " + table + " SET ";
		Str_query = Str_query + " " + filed[0] + "=\'" + value[0] + "\'";
		for (int i = 1; i < filed.length; i++)
			Str_query = Str_query + "," + filed[i] + "=" + (value[i]=="NULL"? "NULL " :"\'"+value[i] + "\'");
		if (condition.length() > 0)
			Str_query = Str_query + " WHERE " + condition;
		System.out.println(Str_query);
		return Str_query;
	}

	//Methode que retourne la chaine de caractere pour insert
	public String Query_Insert(String table, String[] filed, String[] value) {
		if (filed.length != value.length)
			return "";
		String Str_query = "INSERT INTO " + table + " (";
		Str_query = Str_query + filed[0];
		for (int i = 1; i < filed.length; i++)
			Str_query = Str_query + "," + filed[i];
		Str_query = Str_query + ") VALUES (\'" + value[0] + "\'";
		for (int i = 1; i < value.length; i++)
			Str_query = Str_query + (value[i].equals("NULL")? ", NULL " :",\'" + value[i] + "\'");
		Str_query = Str_query + ")";
		return Str_query;
	}

	//Methode que retourne la chaine de caractere pour delete
	public String Query_Delete(String table, String condition) {
		return "DELETE FROM " + table + " WHERE " + condition;
	}
}
