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
		
		int i=0,j=0, cantEstanquesUsados=0, profundidadAguaMedidaDesdeArriba=0;
		int aguaRestante = this.volumenDeAgua;
		int superficiesDeTanquesParaNivelar = 0, volumenANivelar=0;
		int volumenTotalSistema=0;
		double heq;
		Estanque estanqueAux = null;
		Estanque estanqueActual;

		for (i = 0; i < this.cantidadDeEstanques; i++) {
			estanqueAux = this.estanques.get(i);
			volumenTotalSistema += estanqueAux.superficie * estanqueAux.profundidad;
		}

		if (volumenTotalSistema < this.volumenDeAgua) {

			System.out.println("Hay desborde: " + (this.volumenDeAgua - volumenTotalSistema));
			return;
		}
			
		i=0;
		while (aguaRestante != 0) {
			estanqueAux = this.estanques.get(i);
			
			aguaRestante = estanqueAux.vertirAgua(aguaRestante);
			
			//quedó por arriba del caño derecho?
			if(estanqueAux.profundidadDisponible<estanqueAux.profundidadCañoDer) {
				if(i==0)	//es el primer tanque?
					aguaRestante += estanqueAux.sacarSobrante();
				//no es el primer tanque
				else{
					//hay que nivelar
					if(estanqueAux.profundidadCañoIzq > estanqueAux.profundidadDisponible) {
						
						j=i;
						estanqueActual = estanqueAux;
						volumenANivelar = estanqueActual.volumenCargado - (estanqueActual.volumenTotal - estanqueActual.profundidadCañoIzq * estanqueActual.superficie);
						
						while(estanqueActual.profundidadCañoDer<estanqueActual.profundidadCañoIzq) {
							
							superficiesDeTanquesParaNivelar += estanqueActual.superficie;
							
							j--;
							estanqueActual = this.estanques.get(j);
						}
						
						//sumo la ultima 
						superficiesDeTanquesParaNivelar += estanqueActual.superficie;
						
						//este es el h que tiene que subir cada tanque, multiplicar por cada area 
						heq = volumenANivelar/superficiesDeTanquesParaNivelar;
						
						for(;j<=i;j++) 
							this.estanques.get(j).sumarAguaConAltura(heq);
					}
					
				}
			}
			
			i++;
			cantEstanquesUsados++;
		}
		
		
		
		
		
		
	}
	
	
}
