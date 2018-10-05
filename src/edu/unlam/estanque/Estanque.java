package edu.unlam.estanque;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profunidadadCaño;
	int volumenDisponible;
	
	public Estanque(int nroTanque, int superficie, int profundidad, int profunidadadCaño) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profunidadadCaño = profunidadadCaño;
		this.volumenDisponible = superficie*profundidad;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profunidadadCaño;
	}
	
	
	

}
