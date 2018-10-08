package edu.unlam.estanque;

import java.util.ArrayList;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profundidadCañoIzq;
	int profundidadCañoDer;
	int volumenCargado;
	int alturaAguaCargada;
	int volumenTotal;
	int profundidadDisponible;

	public Estanque(int nroTanque, int superficie, int profundidad, int profundidadCañoIzq, int profundidadCañoDer) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCañoIzq = profundidadCañoIzq;
		this.profundidadCañoDer = profundidadCañoDer;
		this.volumenTotal = superficie * profundidad;
		this.volumenCargado = 0;
		this.alturaAguaCargada = 0;
		this.profundidadDisponible = profundidad;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profundidadCañoIzq + " "
				+ this.profundidadCañoDer;
	}

	/*//devuelvo un 1 cuando tiene que iterar (llenar otro tanque porque ya llegó hasta el caño derecho) o un 0 si aún no tiene que iterar
	public int llenar(ArrayList<Estanque> estanques, int aguaAVertir) {
		int retorno = 0;
		int i =0;
		int volumenACargar=0;
		// Primero lleno el tanque vacio, pero esto depende de la posición de sus caños.
		if (this.volumenCargado == 0) {
			if (this.profundidadCañoIzq >= this.profundidadCañoDer) {
				this.volumenCargado += this.volumenTotal - this.superficie * this.profundidadCañoIzq;
				this.alturaAguaCargada += this.profundidad - this.profundidadCañoIzq;
			} else {
				this.volumenCargado += this.volumenTotal - this.superficie * this.profundidadCañoDer;
				this.alturaAguaCargada += this.profundidad - this.profundidadCañoDer;
				retorno = 1;
			}

		}

		// si ya tiene agua
		if (this.volumenCargado != 0) {
			// tanque con caño izquierdo mas profundo que el derecho
			if (this.profundidadCañoDer != 0 && this.profundidadCañoIzq != 0
					&& this.profundidadCañoIzq > this.profundidadCañoDer) {
				if (this.alturaAguaCargada == this.profundidad - this.profundidadCañoIzq) {
					
					volumenACargar =  this.volumenTotal - this.superficie * this.profundidadCañoDer;
					this.volumenCargado = volumenACargar;
					this.alturaAguaCargada = this.profundidad - this.profundidadCañoDer;
					retorno = 1;
					
					i = this.nroTanque-2;	//-1 porque es el anterior y -1 nuevamente porque cuenta desde el 0
					while(i >= 0 && estanques.get(i).profundidadCañoIzq > this.profundidadCañoDer) {
						estanques.get(i).volumenCargado
						estanques.get(i).alturaAguaCargada+=
					}
				} else if (this.alturaAguaCargada == this.profundidad - this.profundidadCañoDer) {
					this.volumenCargado = volumenTotal;
					this.alturaAguaCargada = profundidad;
				}
			}

			// tanque con caño derecho mas profundo que el izquierdo
			else if (this.profundidadCañoDer != 0 && this.profundidadCañoIzq != 0
					&& this.profundidadCañoDer > this.profundidadCañoIzq) {
				if (this.alturaAguaCargada == this.profundidad - this.profundidadCañoDer) {

					this.volumenCargado = this.volumenTotal - this.superficie * this.profundidadCañoIzq;
					this.alturaAguaCargada = this.profundidad - this.profundidadCañoIzq;

				} else if (this.alturaAguaCargada == this.profundidad - this.profundidadCañoIzq) {
					this.volumenCargado = volumenTotal;
					this.alturaAguaCargada = profundidad;
				}
			}

			// primer estanque, ultimo estanque o tanque con misma profundidad de caños
			else if ((this.profundidadCañoDer != 0 && this.profundidadCañoIzq == 0)
					|| (this.profundidadCañoDer == 0 && this.profundidadCañoIzq != 0)
					|| (this.profundidadCañoDer == this.profundidadCañoIzq)) {
				this.volumenCargado = volumenTotal;
				this.alturaAguaCargada = this.profundidad;
			}

		}
		
		return retorno;
	}*/
	
	

	public int vertirAgua(int aguaRestante) {
		
		if(aguaRestante>= this.volumenTotal) {
			this.volumenCargado += this.volumenTotal;
			this.alturaAguaCargada += profundidad;
			this.profundidadDisponible = 0;
		}else {
			this.volumenCargado += aguaRestante;
			this.alturaAguaCargada = this.volumenCargado/this.superficie;
			this.profundidadDisponible = this.profundidad- this.alturaAguaCargada;
		}
		aguaRestante -= this.volumenCargado;
		
		return aguaRestante;
		
	}

	public int sacarSobrante() {
		int retorno = this.volumenCargado - (this.volumenTotal-this.superficie*this.profundidadCañoDer);
		this.volumenCargado = this.volumenTotal - this.profundidadCañoDer * this.superficie;
		this.alturaAguaCargada = this.profundidad - this.profundidadCañoDer;
		this.profundidadDisponible = this.profundidadCañoDer;
		
		//debo retornar el volumen cargado menos lo que está debajo del caño derecho
		return retorno;
	}
	
	public void sumarAguaConAltura(double metrosAgua) {
		this.volumenCargado+= this.superficie*metrosAgua;
		this.alturaAguaCargada += metrosAgua;
		this.profundidadDisponible = this.volumenTotal- this.volumenCargado;
	}
}
