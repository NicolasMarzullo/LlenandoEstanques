package edu.unlam.estanque;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoEstanque {

	public static ConjuntoEstanque leer(String path) throws FileNotFoundException {
		ArrayList<Estanque> estanques = new ArrayList<>();
		Scanner lector = new Scanner(new File(path));
		int cantEstanques = lector.nextInt();
		int volumenDeAgua;
		int profundidadCa�oAnterior=0;

		estanques.add(new Estanque(1, lector.nextInt(), lector.nextInt(), profundidadCa�oAnterior,
				profundidadCa�oAnterior = lector.nextInt()));

		for (int i = 1; i < cantEstanques - 1; i++)
			estanques.add(new Estanque(i + 1, lector.nextInt(), lector.nextInt(), profundidadCa�oAnterior,
					profundidadCa�oAnterior = lector.nextInt()));

		// ultimo estanque sin ca�o dererecho
		estanques.add(new Estanque(cantEstanques, lector.nextInt(), lector.nextInt(), profundidadCa�oAnterior,0));
		volumenDeAgua = lector.nextInt();
		lector.close();

		return new ConjuntoEstanque(estanques, cantEstanques, volumenDeAgua);
	}

}
