//Nome: Giovanni Siervo - RA: 2144255

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Scan{

	public String entDados(String info){

		System.out.println(info);
		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);
		String s ="";

		try{
			s = buff.readLine();
		}

		catch(IOException ioe){
			System.out.println("\nErro na entrada");
		}

		return s;

	}
}