package edu.unlam.estanque;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profunidadadCa�o;
	
	public Estanque(int nroTanque, int superficie, int profundidad, int profunidadadCa�o) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profunidadadCa�o = profunidadadCa�o;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profunidadadCa�o;
	}
	
	
	

}
