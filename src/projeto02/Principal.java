package projeto02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Principal {

	
	public static void main(String[] args) {
	try {
		
	Scanner in = new Scanner(System.in);
	String cep = in.nextLine();
	
	String url = "https://viacep.com.br/ws/" + cep + "/json";
	
	HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
	conn.setRequestMethod("GET");
	conn.setRequestProperty("Accept" , "application/json");
	if(conn.getResponseCode() != 200)	{
		System.out.println("Erro" + conn.getResponseCode() + " ao obter dados da URL " + url);
	}
	BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

	String output = "";
	String line;
	
	while ((line = br.readLine()) != null) {
	output += line;
	}
	conn.disconnect();
	
	System.out.println(new String(output.getBytes()));
	
	} catch (IOException ex) {
		
	}

}
}
