package com.tecnicomercap.llamada;

import java.time.LocalDateTime;

public abstract class Llamada {
	
	public Llamada(LocalDateTime fechaLlamada, String numeroMarcado, int duracionMin) {
		this.fechaLlamada = fechaLlamada;
		this.numeroMarcado = numeroMarcado;
		this.duracionMin = duracionMin;
	}

	private LocalDateTime fechaLlamada;
	private String numeroMarcado;
	private int duracionMin;
	
	public String getNumeroMarcado() {
		return this.numeroMarcado;
	}
	public LocalDateTime getFechaLlamada() {
		return fechaLlamada;
	}
	public String obtenerMesLlamada() {
		return this.fechaLlamada.getMonth().toString();
	}
	public int getDuracion() {
		return duracionMin;
	}
	public int getHora() {
		return fechaLlamada.getHour();
	}
	
	public abstract double calcularCosto(int horaHabilInicio, int horaHabilfin);
	
	
	
}
