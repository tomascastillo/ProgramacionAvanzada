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
		for ( Mesada m : mesadas )
		{
			boolean f = true;
			for ( int i = 0 ; i<pilas.size() && f ; i++ )
			{
				if(pilas.get(i).apilable(m)){
					pilas.set(i, m);
					f=false;
				}
			}
			if(f)
			{
				pilas.add(m);
			}
		}
		imprimirResultado(pilas.size());
		
	}
	
	/**
	 * RECUPERO LAS MESADAS DEL ARCHIVO, ROTANDOLAS PARA QUE QUEDEN ORDENADAS DEL LADO MAYOR AL MENOR
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Mesada[] leerArchivo(final String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		int cant = sc.nextInt();
		Mesada[]  mesadas = new Mesada[cant];
		
		//CON EL CONSTRUCTOR COMENTADO
		//while(cant>0)
		//	mesadas[--cant] = new Mesada(sc.nextInt(),sc.nextInt());
		
		while(cant>0){
			mesadas[--cant] = new Mesada(sc.nextInt(),sc.nextInt());
			if(mesadas[cant].getX()<mesadas[cant].getY())
				mesadas[cant].rotar();
		}
		
		sc.close();
		return mesadas;
	}
	
	public static void imprimirResultado(final int resultado) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("salida.out"));
		pw.println(resultado);
		pw.close();
	}
	
}