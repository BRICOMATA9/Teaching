package Tp7;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Question1 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://api.sncf.com/v1/coverage/sncf");
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		Encoder base = Base64.getEncoder();
		String s=base.encodeToString("82ee4aa2-ecf2-4844-b9a1-0bcbff7a285e:".getBytes());
		connection.setRequestProperty("Authorisation","Basic "+s);
		System.out.println(connection.getResponseCode());
		
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(isr);
		System.out.println(element);
	}
	
	public static JsonElement get(String s){
		
		
		return null;
		
	}
}
