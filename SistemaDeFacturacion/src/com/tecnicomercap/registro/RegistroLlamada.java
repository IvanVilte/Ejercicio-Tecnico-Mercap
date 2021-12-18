package com.tecnicomercap.registro;

import com.tecnicomercap.llamada.Llamada;

public class RegistroLlamada {
	private Llamada llamada;
	private String codigoArea;
	
	public RegistroLlamada(Llamada llamada) {
		this.llamada = llamada;
		this.codigoArea = obtenerCodigoArea();
	}
	//Es este programa voy a considar que el codigo de área tiene 
	//3 digítos 
	public String obtenerCodigoArea() {
		String numeroReceptor = this.llamada.getNumeroMarcado();
		
		return numeroReceptor.substring(0,3);
	}
	public String mesLlamada() {
		return this.llamada.obtenerMesLlamada();
	}
	public String getCodigoArea() {
		return this.codigoArea;
	}
	
	public Llamada getLlamada() {
		return this.llamada;
	}
}
