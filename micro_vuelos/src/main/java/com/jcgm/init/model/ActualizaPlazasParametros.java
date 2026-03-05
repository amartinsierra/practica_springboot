package com.jcgm.init.model;

public class ActualizaPlazasParametros {

	private int idVuelo;
	private int numPlazas;
	
	public ActualizaPlazasParametros(int idVuelo, int numPlazas) {
		this.idVuelo = idVuelo;
		this.numPlazas = numPlazas;
	}
	
	public int getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	
	public int getNumPlazas() {
		return numPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	
}
