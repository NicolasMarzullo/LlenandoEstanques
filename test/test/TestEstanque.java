package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import edu.unlam.estanque.ArchivoEstanque;
import edu.unlam.estanque.ConjuntoEstanque;
import edu.unlam.estanque.Estanque;

public class TestEstanque {
	
	@Test
	public void pruebaCargaEstanques() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/01_CasoEnunciado.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		System.out.println("-----------SALIDA--------------");
		conjEstanques.resolver();
	}

}
