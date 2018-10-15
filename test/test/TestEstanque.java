package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import edu.unlam.estanque.ArchivoEstanque;
import edu.unlam.estanque.ConjuntoEstanque;
import edu.unlam.estanque.Estanque;

public class TestEstanque {
	
	@Test
	public void testCasoEnunciado01() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/01_CasoEnunciado.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		ArchivoEstanque.escribir("test/lotes/out/01_CasoEnunciado.out", conjEstanques.resolver());
	}
	
	@Test
	public void testCasoEnunciado02() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/02_CasoEnunciado.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		ArchivoEstanque.escribir("test/lotes/out/02_CasoEnunciado.out", conjEstanques.resolver());
	}
	

	@Test
	public void testCasoEnunciado03() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/03_CasoEnunciado.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		ArchivoEstanque.escribir("test/lotes/out/03_CasoEnunciado.out", conjEstanques.resolver());
	}
	
	@Test
	public void testCasoEnunciado04() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/04_CasoEnunciado.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		ArchivoEstanque.escribir("test/lotes/out/04_CasoEnunciado.out", conjEstanques.resolver());
	}
	
	@Test
	public void testCasoEnunciado05() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/05_CasoEnunciado.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		ArchivoEstanque.escribir("test/lotes/out/05_CasoEnunciado.out", conjEstanques.resolver());
	}
	
	@Test
	public void testMasDeUnaVuelta06() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/06_CasoMasDeUnaVuelta.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		ArchivoEstanque.escribir("test/lotes/out/06_CasoMasDeUnaVuelta.out", conjEstanques.resolver());
	}
	
	
	@Test
	public void testMasDeUnaVuelta07() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/07_CasoMasDeUnaVuelta.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		ArchivoEstanque.escribir("test/lotes/out/07_CasoMasDeUnaVuelta.out", conjEstanques.resolver());
	}
	
	@Test
	public void testMasDeUnaVuelta08() throws FileNotFoundException {
		ConjuntoEstanque conjEstanques = ArchivoEstanque.leer("test/lotes/in/08_CasoMasDeUnaVuelta.in");
		
		ArrayList<Estanque> estanques = conjEstanques.getEstanques();
		
		for(int i=0; i<estanques.size();i++) {
			System.out.println(estanques.get(i));
		}
		
		ArchivoEstanque.escribir("test/lotes/out/08_CasoMasDeUnaVuelta.out", conjEstanques.resolver());
	}





}
