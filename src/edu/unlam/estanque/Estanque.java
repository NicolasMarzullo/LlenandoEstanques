package edu.unlam.estanque;

public class Estanque {
	int nroTanque;
	int superficie;
	int profundidad;
	int profundidadCa�oIzq;
	int profundidadCa�oDer;
	int volumenDisponible;

	public Estanque(int nroTanque, int superficie, int profundidad, int profundidadCa�oIzq, int profundidadCa�oDer) {
		this.nroTanque = nroTanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCa�oIzq = profundidadCa�oIzq;
		this.profundidadCa�oDer = profundidadCa�oDer;
		this.volumenDisponible = superficie * profundidad;
	}

	@Override
	public String toString() {
		return this.nroTanque + "  " + this.superficie + "  " + this.profundidad + "  " + this.profundidadCa�oIzq + " "
				+ this.profundidadCa�oDer;
	}

	public void llenar() {
		// Primero lleno el tanque vacio, pero esto depende de la posici�n de sus ca�os.
	}

}
