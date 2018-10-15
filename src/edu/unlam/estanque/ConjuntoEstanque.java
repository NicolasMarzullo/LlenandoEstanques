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

	public Salida resolver() {
		int i = 0, cantEstanquesUsados=1, j, volumenTotalSistema=0;
		double aguaRestante = this.volumenDeAgua, alturaMax = 0, minProfundidad=0, minProfundidadAnterior=0, superficiesDeTanquesALlenar = 0;
		double volumenEntranteTotalEnCargaSimultanea, heq;
		Estanque estanqueAux, estanqueActual;

		for (i = 0; i < this.cantidadDeEstanques; i++) {
			estanqueAux = this.estanques.get(i);
			volumenTotalSistema += estanqueAux.superficie * estanqueAux.profundidad;
		}

		if (volumenTotalSistema < this.volumenDeAgua) 
			return new Salida(this.estanques,0, this.volumenDeAgua - volumenTotalSistema);

		
		i=0;
		estanqueAux = this.estanques.get(i);
		aguaRestante = estanqueAux.vertirAgua(aguaRestante);

		while (aguaRestante != 0) {

			estanqueAux = this.estanques.get(i);

			// si llegó al caño derecho, tengo que cargar otro estanque
			if (estanqueAux.alturaAguaCargada == (estanqueAux.profundidad - estanqueAux.profundidadCañoDer)) {
				i++;
				cantEstanquesUsados++;
				estanqueAux = this.estanques.get(i);
				aguaRestante = estanqueAux.vertirAgua(aguaRestante);
			}

			if (estanqueAux.profundidadCañoDer < estanqueAux.profundidadCañoIzq && aguaRestante != 0) {// nivelo
				// Ahora debo buscar las superficies de los tanques involucrados en el llenado
				estanqueActual = estanqueAux; // Uso otra referencia para no perder el ultimo tanque trabajado
												// (estanqueAux)
				
				j = estanqueAux.nroTanque - 1;
				
				minProfundidad = estanqueActual.profundidadCañoIzq;	
				minProfundidadAnterior = minProfundidad;
				while (estanqueActual.profundidadCañoDer < estanqueActual.profundidadCañoIzq 
						|| estanqueActual.alturaAguaCargada >= (estanqueActual.profundidad - estanqueActual.profundidadCañoIzq)) {
					
					if(estanqueActual.profundidadCañoIzq<minProfundidad) {
						minProfundidadAnterior = minProfundidad;
						minProfundidad = estanqueActual.profundidadCañoIzq;
					}
						
					
					superficiesDeTanquesALlenar += estanqueActual.superficie;
					j--;
					estanqueActual = this.estanques.get(j);
				}
				
				if(estanqueActual.profundidadCañoIzq<minProfundidad) {
					minProfundidadAnterior = minProfundidad;
					minProfundidad = estanqueActual.profundidadCañoIzq;
				}
				
				alturaMax = minProfundidadAnterior-minProfundidad;
				
				if(estanqueAux.profundidadCañoDer!=0) //si no es el ultimo estanque
					alturaMax = estanqueAux.profundidadCañoIzq - estanqueAux.profundidadCañoDer;

				superficiesDeTanquesALlenar += estanqueActual.superficie; /// El ultimo tanque a llenar
				
				

				volumenEntranteTotalEnCargaSimultanea = superficiesDeTanquesALlenar * alturaMax;
				/*
				 * si aguaRestante es > que todas las capacidades de los tanques anteriores que
				 * se van a llenar los cargo hasta la profundidad del estanqueaux.cañode y el
				 * algoritmo sigue iterando. Si eso no sucede quiere decir que tengo que cargar
				 * todos los tanques hasta un Heq (altura de equilibrio), la cual se calcula
				 * dividiendo el volumen de agua a cargar sobre la suma de todas las superficie.
				 * Una vez obtenido el Heq se lo paso al metodo correspondiente del tanque para
				 * que vierta el agua que le corresponda según la superficie de cada tanque. Lo
				 * importante esta parte es que aquí finalizará la carga de los tanques.
				 */

				if (aguaRestante >= volumenEntranteTotalEnCargaSimultanea) {
					while (j <= i) {
						estanqueActual = this.estanques.get(j);
						estanqueActual.sumarAguaConAltura(alturaMax);
						j++;
					}
					aguaRestante-= volumenEntranteTotalEnCargaSimultanea;	//le saco lo cargado
				}else {
					heq = aguaRestante / superficiesDeTanquesALlenar;
					while (j <= i) {
						estanqueActual = this.estanques.get(j);
						estanqueActual.sumarAguaConAltura(heq);
						j++;
					}
					aguaRestante = 0; //ya se terminó el agua
				}
					superficiesDeTanquesALlenar =0; //limpio la variable
					volumenEntranteTotalEnCargaSimultanea=0;
			}
			
		}
		return new Salida(this.estanques, cantEstanquesUsados,0);

	}
}
