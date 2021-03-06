package mesadasV2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws FileNotFoundException
	{
		ArrayList<Mesada> pilas = new ArrayList<Mesada>();
		Mesada mesadas [] = leerArchivo("entrada.in");
		Arrays.sort(mesadas);
		for (int i, j =0; j < mesadas.length; j++ )
		{
			for ( i = 0 ; i<pilas.size() && !pilas.get(i).apilable(mesadas[j]) ; i++ );
			if(pilas.size() > i)
				pilas.set(i, mesadas[j]);
			else
				pilas.add(mesadas[j]);
		}
		imprimirResultado(pilas.size());
	}
	
	
	public static Mesada[] leerArchivo(final String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		int cant = sc.nextInt();
		Mesada[]  mesadas = new Mesada[cant];
		
		while(cant>0)
			mesadas[--cant] = new Mesada(sc.nextInt(),sc.nextInt());
		
		sc.close();
		return mesadas;
	}
	
	public static void imprimirResultado(final int resultado) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("salida.out"));
		pw.println(resultado);
		pw.close();
	}
	
}
