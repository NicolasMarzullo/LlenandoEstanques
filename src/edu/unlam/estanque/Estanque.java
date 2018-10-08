package edu.unlam.estanque;

import java.util.ArrayList;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profundidadCa�oIzq;
	int profundidadCa�oDer;
	int volumenCargado;
	int alturaAguaCargada;
	int volumenTotal;
	int profundidadDisponible;

	public Estanque(int nroTanque, int superficie, int profundidad, int profundidadCa�oIzq, int profundidadCa�oDer) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCa�oIzq = profundidadCa�oIzq;
		this.profundidadCa�oDer = profundidadCa�oDer;
		this.volumenTotal = superficie * profundidad;
		this.volumenCargado = 0;
		this.alturaAguaCargada = 0;
		this.profundidadDisponible = profundidad;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profundidadCa�oIzq + " "
				+ this.profundidadCa�oDer;
	}

	/*//devuelvo un 1 cuando tiene que iterar (llenar otro tanque porque ya lleg� hasta el ca�o derecho) o un 0 si a�n no tiene que iterar
	public int llenar(ArrayList<Estanque> estanques, int aguaAVertir) {
		int retorno = 0;
		int i =0;
		int volumenACargar=0;
		// Primero lleno el tanque vacio, pero esto depende de la posici�n de sus ca�os.
		if (this.volumenCargado == 0) {
			if (this.profundidadCa�oIzq >= this.profundidadCa�oDer) {
				this.volumenCargado += this.volumenTotal - this.superficie * this.profundidadCa�oIzq;
				this.alturaAguaCargada += this.profundidad - this.profundidadCa�oIzq;
			} else {
				this.volumenCargado += this.volumenTotal - this.superficie * this.profundidadCa�oDer;
				this.alturaAguaCargada += this.profundidad - this.profundidadCa�oDer;
				retorno = 1;
			}

		}

		// si ya tiene agua
		if (this.volumenCargado != 0) {
			// tanque con ca�o izquierdo mas profundo que el derecho
			if (this.profundidadCa�oDer != 0 && this.profundidadCa�oIzq != 0
					&& this.profundidadCa�oIzq > this.profundidadCa�oDer) {
				if (this.alturaAguaCargada == this.profundidad - this.profundidadCa�oIzq) {
					
					volumenACargar =  this.volumenTotal - this.superficie * this.profundidadCa�oDer;
					this.volumenCargado = volumenACargar;
					this.alturaAguaCargada = this.profundidad - this.profundidadCa�oDer;
					retorno = 1;
					
					i = this.nroTanque-2;	//-1 porque es el anterior y -1 nuevamente porque cuenta desde el 0
					while(i >= 0 && estanques.get(i).profundidadCa�oIzq > this.profundidadCa�oDer) {
						estanques.get(i).volumenCargado
						estanques.get(i).alturaAguaCargada+=
					}
				} else if (this.alturaAguaCargada == this.profundidad - this.profundidadCa�oDer) {
					this.volumenCargado = volumenTotal;
					this.alturaAguaCargada = profundidad;
				}
			}

			// tanque con ca�o derecho mas profundo que el izquierdo
			else if (this.profundidadCa�oDer != 0 && this.profundidadCa�oIzq != 0
					&& this.profundidadCa�oDer > this.profundidadCa�oIzq) {
				if (this.alturaAguaCargada == this.profundidad - this.profundidadCa�oDer) {

					this.volumenCargado = this.volumenTotal - this.superficie * this.profundidadCa�oIzq;
					this.alturaAguaCargada = this.profundidad - this.profundidadCa�oIzq;

				} else if (this.alturaAguaCargada == this.profundidad - this.profundidadCa�oIzq) {
					this.volumenCargado = volumenTotal;
					this.alturaAguaCargada = profundidad;
				}
			}

			// primer estanque, ultimo estanque o tanque con misma profundidad de ca�os
			else if ((this.profundidadCa�oDer != 0 && this.profundidadCa�oIzq == 0)
					|| (this.profundidadCa�oDer == 0 && this.profundidadCa�oIzq != 0)
					|| (this.profundidadCa�oDer == this.profundidadCa�oIzq)) {
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
		int retorno = this.volumenCargado - (this.volumenTotal-this.superficie*this.profundidadCa�oDer);
		this.volumenCargado = this.volumenTotal - this.profundidadCa�oDer * this.superficie;
		this.alturaAguaCargada = this.profundidad - this.profundidadCa�oDer;
		this.profundidadDisponible = this.profundidadCa�oDer;
		
		//debo retornar el volumen cargado menos lo que est� debajo del ca�o derecho
		return retorno;
	}
	
	public void sumarAguaConAltura(double metrosAgua) {
		this.volumenCargado+= this.superficie*metrosAgua;
		this.alturaAguaCargada += metrosAgua;
		this.profundidadDisponible = this.volumenTotal- this.volumenCargado;
	}
}
