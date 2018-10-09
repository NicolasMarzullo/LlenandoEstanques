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
	double profundidadDisponible;

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
		
		if(this.profundidadDisponible<this.profundidadCa�oDer) {
			retorno = this.volumenCargado - (this.volumenTotal-this.superficie*this.profundidadCa�oDer);
			this.volumenCargado = this.volumenTotal - this.profundidadCa�oDer * this.superficie;
			this.alturaAguaCargada = this.profundidad - this.profundidadCa�oDer;
			this.profundidadDisponible = this.profundidadCa�oDer;
			
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
