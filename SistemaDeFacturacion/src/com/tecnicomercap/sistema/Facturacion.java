package com.tecnicomercap.sistema;

import java.util.List;

import com.tecnicomercap.registro.RegistroLlamada;
import com.tecnicomercap.usuario.Usuario;

public class Facturacion {

	private double abonoMensual;
	private double consumoLlamadasLocales;
	private double consumoLlamadaIntern;
	private double consumoLlamadaNacional;
	private Usuario usuario;
	private String mes;

	public Facturacion(Usuario usuario, String mes, int abonoMensual) {
		this.usuario = usuario;
		this.mes = mes;
		this.abonoMensual = abonoMensual;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public double getAbonoMensual() {
		return abonoMensual;
	}

	public double getConsumoLlamadasLocales() {
		return consumoLlamadasLocales;
	}

	public double getConsumoLlamadaIntern() {
		return consumoLlamadaIntern;
	}

	public double getConsumoLlamadaNacional() {
		return consumoLlamadaNacional;
	}

	public String getMes() {
		return mes;
	}

	public double calcularCostoTotal(int horaInicial, int horaFinal) {
		double facturacion = 0;

		List<RegistroLlamada> registrosDelMes = this.usuario.llamadasDelMes(this.mes);

		for (RegistroLlamada registro : registrosDelMes) {
			facturacion += registro.getLlamada().calcularCosto(horaInicial, horaFinal);
		}

		return facturacion;
	}

	public double calcularCostoInternacional(int horaInicial, int horaFinal) {
		double facturacion = 0;

		List<RegistroLlamada> registrosDelMes = this.usuario.llamadasInternacionales(this.mes);

		for (RegistroLlamada registro : registrosDelMes) {
			facturacion += registro.getLlamada().calcularCosto(horaInicial, horaFinal);
		}
		
		this.consumoLlamadaIntern = facturacion;
		return facturacion;
	}

	public double calcularCostoNacional(int horaInicial, int horaFinal) {
		double facturacion = 0;

		List<RegistroLlamada> registrosDelMes = this.usuario.llamadasNacionales(this.mes);

		for (RegistroLlamada registro : registrosDelMes) {
			facturacion += registro.getLlamada().calcularCosto(horaInicial, horaFinal);
		}
		
		this.consumoLlamadaNacional = facturacion;
		
		return facturacion;
	}

	public double calcularCostoLocal(int horaInicial, int horaFinal) {
		double facturacion = 0;

		List<RegistroLlamada> registrosDelMes = this.usuario.llamadasDelMes(this.mes);

		for (RegistroLlamada registro : registrosDelMes) {
			if(esLlamadaLocal(Integer.parseInt(registro.obtenerCodigoArea()))) {
				facturacion += registro.getLlamada().calcularCosto(horaInicial, horaFinal);
			}
		}
		
		this.consumoLlamadasLocales = facturacion;
		
		return facturacion;
	}
	
	public boolean esLlamadaLocal(int codigo) {
		return codigo == Integer.parseInt(this.usuario.codigoAreaUsuario());
	}

	public void mostrarFactura() {
		System.out.println(
                "\n" + """
                        
                [Nombre de la compañia]                                       FACTURA
                    
                    
                [Dirección de la calle]
                [Ciudad, Estado Código postal]
                Teléfono: (000) 000-0000                           FACTURA#                  MES
                """ +
                "DATOS DEL CLIENTE \t\t \n"+
                "Nombre: " + this.usuario.getNombre() + "\n"+
                "Apellido: " + this.usuario.getApellido() + "\n" +
                "Nro Teléfono: " + this.usuario.getNumero() + "\n"+
                "\n\n"+
                "DESCRIPCION" + "\t\t\t" + "CANTIDAD LLAMADAS" + "\t\t" + "MONTO\n"+
                "Abono Mensual" + "\t\t\t" + "\t\t\t    "+ this.abonoMensual + "\n" +
                "LLamadas Inter" + "\t\t\t" + "\t\t\t    " + this.calcularCostoInternacional(8, 20) + "\n" +
                "Llamadas Nacio" + "\t\t\t" + "\t\t\t    " + this.calcularCostoNacional(8, 20) + "\n" +
                "Llamadas Locales" + "\t\t\t" + "\t\t    " + this.calcularCostoLocal(8,20) + "\n" +
                "TOTAL" + "\t\t\t\t " + this.usuario.cantidadLlamadas(this.mes) + "\t\t\t    " + (calcularCostoTotal(8,20) + this.abonoMensual)
                );
		
	}
}
