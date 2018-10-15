package edu.unlam.estanque;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profundidadCa�oIzq;
	int profundidadCa�oDer;
	double volumenCargado;
	double alturaAguaCargada;
	int volumenTotal;

	public Estanque(int nroTanque, int superficie, int profundidad, int profundidadCa�oIzq, int profundidadCa�oDer) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCa�oIzq = profundidadCa�oIzq;
		this.profundidadCa�oDer = profundidadCa�oDer;
		this.volumenTotal = superficie * profundidad;
		this.volumenCargado = 0;
		this.alturaAguaCargada = 0;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profundidadCa�oIzq + " "
				+ this.profundidadCa�oDer;
	}
	

	public double vertirAgua(double aguaRestante) {
		
		if(this.volumenCargado>0)
			return aguaRestante;
		
		int cantidadDeAguaDebajoDelCa�oDerecho = this.volumenTotal -(this.profundidadCa�oDer*this.superficie);
		int cantidadDeAguaDebajoDelCa�oIzquierdo = this.volumenTotal -(this.profundidadCa�oIzq*this.superficie);
		
		if(this.profundidadCa�oDer>=this.profundidadCa�oIzq) {
			if(aguaRestante>= cantidadDeAguaDebajoDelCa�oDerecho) {
				aguaRestante-= cantidadDeAguaDebajoDelCa�oDerecho;
				this.volumenCargado += cantidadDeAguaDebajoDelCa�oDerecho;
				this.alturaAguaCargada += this.volumenCargado/this.superficie;
			}else {
				aguaRestante = 0;
				this.volumenCargado += aguaRestante;
				this.alturaAguaCargada += this.volumenCargado /this.superficie;
			}
		}else {
			if(aguaRestante>= cantidadDeAguaDebajoDelCa�oIzquierdo) {
				aguaRestante-= cantidadDeAguaDebajoDelCa�oIzquierdo;
				this.volumenCargado += cantidadDeAguaDebajoDelCa�oIzquierdo;
				this.alturaAguaCargada += this.volumenCargado/this.superficie;
			}else {
				this.volumenCargado += aguaRestante;
				this.alturaAguaCargada += this.volumenCargado /this.superficie;
				aguaRestante = 0;
			}
		}
		
		return aguaRestante;
		
	}
	
	public void sumarAguaConAltura(double metrosAgua) {
		
		this.alturaAguaCargada += metrosAgua;
		this.volumenCargado += metrosAgua*this.superficie;
		
		
	}
}
