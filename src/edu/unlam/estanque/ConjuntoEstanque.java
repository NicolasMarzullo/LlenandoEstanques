package edu.unlam.estanque;

import java.util.ArrayList;

public class ConjuntoEstanque {
	private ArrayList<Estanque> estanques;
	private int cantidadDeEstanques;
	private int volumenDeAgua;
	
	public ConjuntoEstanque(ArrayList<Estanque> estanques, int cantidadDeEstanques, int volumenDeAgua) {
		this.estanques = estanques;
		this.cantidadDeEstanques = cantidadDeEstanques;
		this.volumenDeAgua = volumenDeAgua;
	}

	public ArrayList<Estanque> getEstanques() {
		return estanques;
	}
	
	public void resolver() {
		//primero calculo todo lo que puede almancenar el sistema de estanques.
		int volumenTotalSistema = 0 ;
		Estanque estanque;
		
		for(int i = 0; i<this.cantidadDeEstanques; i++) {
			estanque = this.estanques.get(i);
			volumenTotalSistema += estanque.superficie * estanque.profundidad;
		}
		
		if(volumenTotalSistema < this.volumenDeAgua)
			System.out.println("Hay desborde: " + (this.volumenDeAgua - volumenTotalSistema));
	}
	
	

	
	
	
	
	
	

}
