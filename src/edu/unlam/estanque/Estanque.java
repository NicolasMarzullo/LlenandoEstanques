package edu.unlam.estanque;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profundidadCañoIzq;
	int profundidadCañoDer;
	int volumenDisponible;

	public Estanque(int nroTanque, int superficie, int profundidad, int profundidadCañoIzq, int profundidadCañoDer) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCañoIzq = profundidadCañoIzq;
		this.profundidadCañoDer = profundidadCañoDer;
		this.volumenDisponible = superficie * profundidad;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profundidadCañoIzq + " "
				+ this.profundidadCañoDer;
	}

	public void llenar() {
		// Primero lleno el tanque vacio, pero esto depende de la posición de sus caños.
	}

}
