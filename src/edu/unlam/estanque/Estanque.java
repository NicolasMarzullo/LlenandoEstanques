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
	double profundidadDisponible;

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

	public double sacarSobrante() {
		double retorno = 0;
		
		if(this.profundidadDisponible<this.profundidadCañoDer) {
			retorno = this.volumenCargado - (this.volumenTotal-this.superficie*this.profundidadCañoDer);
			this.volumenCargado = this.volumenTotal - this.profundidadCañoDer * this.superficie;
			this.alturaAguaCargada = this.profundidad - this.profundidadCañoDer;
			this.profundidadDisponible = this.profundidadCañoDer;
			
		}
	
		return retorno;
	}
	
	public void sumarAguaConAltura(double metrosAgua, int desde) {
		this.volumenCargado = this.volumenTotal - (this.superficie * desde);
		this.volumenCargado+= this.superficie* metrosAgua;
			
		this.alturaAguaCargada = this.volumenCargado/this.superficie;
		this.profundidadDisponible = (this.volumenTotal- this.volumenCargado)/this.superficie;
	}
}
