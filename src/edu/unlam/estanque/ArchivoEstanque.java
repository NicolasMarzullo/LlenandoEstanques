package edu.unlam.estanque;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoEstanque {
	
	public static ConjuntoEstanque leer(String path) throws FileNotFoundException{
		ArrayList<Estanque> estanques = new ArrayList<>();
		Scanner lector = new Scanner(new File(path));
		int cantEstanques = lector.nextInt();
		int volumenDeAgua;
		
		for(int i=0; i<cantEstanques-1;i++) 
			estanques.add(new Estanque(i+1,lector.nextInt(), lector.nextInt(), lector.nextInt()));
		
		estanques.add(new Estanque(cantEstanques, lector.nextInt(), lector.nextInt(), 0));	//ultimo estanque
		volumenDeAgua = lector.nextInt();
		lector.close();
		
		return new ConjuntoEstanque(estanques, cantEstanques, volumenDeAgua);
	}

}
