package edu.unlam.estanque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoEstanque {

	public static ConjuntoEstanque leer(String path) throws FileNotFoundException {
		ArrayList<Estanque> estanques = new ArrayList<>();
		Scanner lector = new Scanner(new File(path));
		int cantEstanques = lector.nextInt();
		int volumenDeAgua;
		int profundidadCañoAnterior = 0;

		estanques.add(new Estanque(1, lector.nextInt(), lector.nextInt(), profundidadCañoAnterior,
				profundidadCañoAnterior = lector.nextInt()));

		for (int i = 1; i < cantEstanques - 1; i++)
			estanques.add(new Estanque(i + 1, lector.nextInt(), lector.nextInt(), profundidadCañoAnterior,
					profundidadCañoAnterior = lector.nextInt()));

		// ultimo estanque sin caño dererecho
		estanques.add(new Estanque(cantEstanques, lector.nextInt(), lector.nextInt(), profundidadCañoAnterior, 0));
		volumenDeAgua = lector.nextInt();
		lector.close();

		return new ConjuntoEstanque(estanques, cantEstanques, volumenDeAgua);
	}

	public static void escribir(String path, Salida salida) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File(path));
		
		if(salida.litrosDesbordados ==0) {
			pw.println(salida.cantidadDeEstanques);

			for(int i=0; i<salida.cantidadDeEstanques;i++) 
				pw.println(i+1 + " " + salida.estanques.get(i).alturaAguaCargada);
		}else
			pw.println("Hay desborde: " + salida.litrosDesbordados);
		
		pw.close();
		
	}

}
