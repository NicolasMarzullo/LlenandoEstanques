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
		int i=0, cantEstanquesUsados=0, profundidadAguaMedidaDesdeArriba=0;
		int aguaRestante = this.volumenDeAgua;
		Estanque estanqueAux = null;
		Estanque estanqueActual;
		
		while(estanqueAux.profundidadCañoDer>profundidadAguaMedidaDesdeArriba) {//veo si conectarle mas tanques cambiaria la situacion del agua o quedaría igual
			
			while(aguaRestante != 0) {
				estanqueAux = this.estanques.get(i);
				
				aguaRestante = estanqueAux.vertirAgua(aguaRestante);
			
				if(aguaRestante!=0) 
					aguaRestante += estanqueAux.sacarSobrante();
				i++;
				cantEstanquesUsados++;
			}
		
		profundidadAguaMedidaDesdeArriba = estanqueAux.profundidad - estanqueAux.alturaAguaCargada;
		
		}
		
		//ahora los nivelo (hacia la izquierda), solo si corresponde
		int j = estanqueAux.nroTanque-1;
		estanqueActual = this.estanques.get(j);
		
	
		
		if(profundidadAguaMedidaDesdeArriba < estanqueAux.profundidadCañoIzq) {//hay que nivelar
			
			//calculo el h de equilibrio (heq) = (S1*h1+S2*h2....+Sn*Hn)/(S1+S2+...+Sn)
			while(j>=0 && (estanqueActual.profundidadCañoIzq == 0 || estanqueActual.profundidadCañoIzq < profundidadAguaMedidaDesdeArriba)) {
				
			}
		}
		
		
		
		
	}
	
	
}
