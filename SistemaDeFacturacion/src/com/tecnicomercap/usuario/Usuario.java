package com.tecnicomercap.usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tecnicomercap.codigoarea.CodigoInternacional;
import com.tecnicomercap.codigoarea.CodigoNacional;
import com.tecnicomercap.llamada.Llamada;
import com.tecnicomercap.llamada.LlamadaLocal;
import com.tecnicomercap.llamada.llamadaexterna.LlamadaInternacional;
import com.tecnicomercap.llamada.llamadaexterna.LlamadaNacional;
import com.tecnicomercap.registro.RegistroLlamada;

public class Usuario {

	private String nombre;
	private String apellido;
	private String numero;
	private String codigoUsuario;
	private List<RegistroLlamada> registroLlamadas;

	public Usuario(String nombre, String apellido, String numero) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero = numero;
		this.codigoUsuario = numero.substring(0, 3);
		this.registroLlamadas = new ArrayList<RegistroLlamada>();
	}
	public String getCodigoUsuario() {
		return this.codigoUsuario;
	}
	public void realizarLlamada(LocalDateTime fechaLlamada, String numeroMarcado, int duracionMin) {
		String codigo = numeroMarcado.substring(0, 3);
		Llamada llamada;
		 if (CodigoNacional.esNacional(Integer.parseInt(codigo))) {
			llamada = new LlamadaNacional(fechaLlamada, numeroMarcado, duracionMin);
		} else if (CodigoInternacional.esInternacional(Integer.parseInt(codigo))) {
			llamada = new LlamadaInternacional(fechaLlamada, numeroMarcado, duracionMin);
		} else {
			llamada = new LlamadaLocal(fechaLlamada, numeroMarcado, duracionMin);
		}
		registroLlamadas.add(new RegistroLlamada(llamada));
	}

	public String codigoAreaUsuario() {
		return this.numero.substring(0, 3);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public List<RegistroLlamada> llamadasNacionales(String mes) {
		List<RegistroLlamada> regLlamadas = new ArrayList<RegistroLlamada>();

		for (RegistroLlamada registro : this.registroLlamadas) {
			if (registro.mesLlamada().equals(mes) && CodigoNacional.esNacional(Integer.parseInt(registro.obtenerCodigoArea()))) {
				regLlamadas.add(registro);
			}
		}

		return regLlamadas;
	}
	
	public List<RegistroLlamada> llamadasInternacionales(String mes) {
		List<RegistroLlamada> regLlamadas = new ArrayList<RegistroLlamada>();

		for (RegistroLlamada registro : this.registroLlamadas) {
			if (registro.mesLlamada().equals(mes) && CodigoInternacional.esInternacional(Integer.parseInt(registro.obtenerCodigoArea()))) {
				regLlamadas.add(registro);
			}
		}

		return regLlamadas;
	}

	public List<RegistroLlamada> llamadasDelMes(String mes) {
		List<RegistroLlamada> regLlamadas = new ArrayList<RegistroLlamada>();

		for (RegistroLlamada registro : this.registroLlamadas) {
			if (registro.mesLlamada().equals(mes)) {
				regLlamadas.add(registro);
			}
		}

		return regLlamadas;
	}

	public int cantidadLlamadas(String mes) {
		return llamadasDelMes(mes).size();
	}

}
