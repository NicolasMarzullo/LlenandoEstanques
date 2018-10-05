package edu.unlam.estanque;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profunidadadCa�o;
	int volumenDisponible;
	
	public Estanque(int nroTanque, int superficie, int profundidad, int profunidadadCa�o) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profunidadadCa�o = profunidadadCa�o;
		this.volumenDisponible = superficie*profundidad;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profunidadadCa�o;
	}
	
	
	

}
