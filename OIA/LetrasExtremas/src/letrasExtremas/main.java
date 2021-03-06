package letrasExtremas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class main {

	public static void main(final String[] args) throws IOException {
		
		Hashtable<Character, HashSet<String>> htLetrasExtremas = LeerArchivo();
		ArrayList<Character> letrasExtremasMaxima = new ArrayList<Character>();
		Enumeration<Character> letrasExtremas = htLetrasExtremas.keys();
		int cantMax = 0;
		
		while( letrasExtremas.hasMoreElements() )
        {
			int cant =0;
	        Character ltrExtrema = (Character) letrasExtremas.nextElement();
	        HashSet<String> palabrasConLtrExtrema = htLetrasExtremas.get(ltrExtrema);
	        for(String palabra:palabrasConLtrExtrema)
	        {
	        	if(palabra.charAt(0)==palabra.charAt(palabra.length()!=0?palabra.length()-1:0))
	        		cant+=2;
	        	else
	        		cant+=1;
	        }
	        if(cantMax==cant)
	        	letrasExtremasMaxima.add(ltrExtrema);
	        else if(cantMax < cant)
	        {
	        	cantMax = cant;
	        	letrasExtremasMaxima.clear();
	        	letrasExtremasMaxima.add(ltrExtrema);
	        }
        }
		PrintWriter salida = new PrintWriter(new FileWriter("salida.out")); 
		for(Character ltrExtrema : letrasExtremasMaxima)
			salida.println(ltrExtrema);
		for(Character ltrExtrema : letrasExtremasMaxima)
		{
			for(String palabra : htLetrasExtremas.get(ltrExtrema))
				salida.println(palabra);
		}
		salida.close();
		
	}
	/**
	 * Lee un archivo y retorna un hashTable que tiene como clave a las letras extremas y los valores son las palabras sin repetir que la contienen
	 */
	private static Hashtable<Character, HashSet<String>> LeerArchivo() throws FileNotFoundException {
		Hashtable<Character, HashSet<String>> htLetrasExtremas = new Hashtable<Character,HashSet<String>>();
		Scanner sc = new Scanner(new File("entrada.in"));
		for(int i =0,  cantValores = sc.nextInt() ; i< cantValores; i++)
		{
			String cadena = sc.next();
			HashSet<String> hs = htLetrasExtremas.get(cadena.charAt(0));
			if ( hs == null ){
				hs = new HashSet<String>();
				hs.add(cadena);
				htLetrasExtremas.put(cadena.charAt(0), hs );
			}
			hs.add(cadena);
			
			hs = htLetrasExtremas.get(cadena.charAt(cadena.length()!=0?cadena.length()-1:0));
			if ( hs == null ){
				hs = new HashSet<String>();
				hs.add(cadena);
				htLetrasExtremas.put(cadena.charAt(cadena.length()!=0?cadena.length()-1:0), hs );
			}
			hs.add(cadena);
			
		}
		sc.close();
		return htLetrasExtremas;
	}
}

