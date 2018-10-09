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
		
		int i=0,j=0, cantEstanquesUsados=0, aguaRestante = this.volumenDeAgua, desde = 0, volumenTotalSistema=0;
		double superficiesDeTanquesParaNivelar = 0, volumenANivelar=0, heq;
		Estanque estanqueActual, estanqueAux = null;

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
			
			if(i==0 || (i>0 && estanqueAux.profundidadCañoDer> estanqueAux.profundidadCañoIzq))
				aguaRestante += estanqueAux.sacarSobrante();
			
			//quedó por arriba del caño Izquierdo?
			if(estanqueAux.profundidadDisponible<estanqueAux.profundidadCañoIzq) {
				if(i==0)	//es el primer tanque?
					aguaRestante += estanqueAux.sacarSobrante();
				//no es el primer tanque
				else{
					//hay que nivelar
					
					j = i;
					estanqueActual = estanqueAux;
					desde = estanqueActual.profundidadCañoIzq;
					volumenANivelar = estanqueActual.volumenCargado - (estanqueActual.volumenTotal
							- estanqueActual.profundidadCañoIzq * estanqueActual.superficie);

					while (estanqueActual.profundidadCañoDer < estanqueActual.profundidadCañoIzq) {

						superficiesDeTanquesParaNivelar += estanqueActual.superficie;

						j--;
						estanqueActual = this.estanques.get(j);
					}

					// sumo la ultima
					superficiesDeTanquesParaNivelar += estanqueActual.superficie;

					// este es el h que tiene que subir cada tanque, multiplicar por cada area
					heq = volumenANivelar / superficiesDeTanquesParaNivelar;
					
					
					
					for(;j<=i;j++)
						this.estanques.get(j).sumarAguaConAltura(heq, desde);
					
				}
			}
			
			i++;
			cantEstanquesUsados++;
		}
								
		
	}
	
	
}
