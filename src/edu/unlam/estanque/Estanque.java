package edu.unlam.estanque;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profunidadadCaño;
	
	public Estanque(int nroTanque, int superficie, int profundidad, int profunidadadCaño) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profunidadadCaño = profunidadadCaño;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profunidadadCaño;
	}
	
	
	

}
