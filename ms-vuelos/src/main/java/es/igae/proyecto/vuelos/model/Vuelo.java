package es.igae.proyecto.vuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="vuelos")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVuelo;
	private String company;
	private String fecha;
	private double precio;
	private Integer plazas;
	private String destino;
	
		public Vuelo(Integer idVuelo, String company, String fechaVuelo, double precio, Integer plazas, String destino) {
		super();
		this.idVuelo = idVuelo;
		this.company = company;
		this.fecha = fechaVuelo;
		this.precio = precio;
		this.plazas = plazas;
		this.destino = destino;
	}
		public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
		public Vuelo() {
		super();
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFechaVuelo() {
		return fecha;
	}
	public void setFechaVuelo(String fechaVuelo) {
		this.fecha = fechaVuelo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Integer getPlazas() {
		return plazas;
	}
	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}
	
	
}
