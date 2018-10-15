package edu.unlam.estanque;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profundidadCañoIzq;
	int profundidadCañoDer;
	double volumenCargado;
	double alturaAguaCargada;
	int volumenTotal;

	public Estanque(int nroTanque, int superficie, int profundidad, int profundidadCañoIzq, int profundidadCañoDer) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCañoIzq = profundidadCañoIzq;
		this.profundidadCañoDer = profundidadCañoDer;
		this.volumenTotal = superficie * profundidad;
		this.volumenCargado = 0;
		this.alturaAguaCargada = 0;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profundidadCañoIzq + " "
				+ this.profundidadCañoDer;
	}
	

	public double vertirAgua(double aguaRestante) {
		
		if(this.volumenCargado>0)
			return aguaRestante;
		
		int cantidadDeAguaDebajoDelCañoDerecho = this.volumenTotal -(this.profundidadCañoDer*this.superficie);
		int cantidadDeAguaDebajoDelCañoIzquierdo = this.volumenTotal -(this.profundidadCañoIzq*this.superficie);
		
		if(this.profundidadCañoDer>=this.profundidadCañoIzq) {
			if(aguaRestante>= cantidadDeAguaDebajoDelCañoDerecho) {
				aguaRestante-= cantidadDeAguaDebajoDelCañoDerecho;
				this.volumenCargado += cantidadDeAguaDebajoDelCañoDerecho;
				this.alturaAguaCargada += this.volumenCargado/this.superficie;
			}else {
				aguaRestante = 0;
				this.volumenCargado += aguaRestante;
				this.alturaAguaCargada += this.volumenCargado /this.superficie;
			}
		}else {
			if(aguaRestante>= cantidadDeAguaDebajoDelCañoIzquierdo) {
				aguaRestante-= cantidadDeAguaDebajoDelCañoIzquierdo;
				this.volumenCargado += cantidadDeAguaDebajoDelCañoIzquierdo;
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
