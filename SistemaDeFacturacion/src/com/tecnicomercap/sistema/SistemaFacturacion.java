package com.tecnicomercap.sistema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.tecnicomercap.usuario.Usuario;

public class SistemaFacturacion {
	
	public static int HORARIO_HABIL_INCIO = 8;
	public static int HORARIO_HABIL_FIN = 20;
	public List<Facturacion> listaFacturas;
	
	public SistemaFacturacion() {
		this.listaFacturas = new ArrayList<Facturacion>();
	}
	public void realizarSimulacion() {
		Usuario ivan = new Usuario("Ivan", "Vilte", "3874824577");
		Usuario tom = new Usuario("Tom", "Arebalos", "3874823231");
		Usuario ernesto = new Usuario("Ernesto", "Valverde", "387451566");
		Usuario mariano = new Usuario("Mariano", "Juicio", "3875676263");
		
		Facturacion facturacionIvan = new Facturacion(ivan, "MARCH", 150);
		ivan.realizarLlamada(LocalDateTime.parse("2018-02-27T18:14:01.184"), "3874823231", 15);
		ivan.realizarLlamada(LocalDateTime.parse("2018-03-20T18:14:01.184"), "3874567626", 10);
		ivan.realizarLlamada(LocalDateTime.parse("2018-03-20T18:14:01.184"), "5705676263", 10);
		ivan.realizarLlamada(LocalDateTime.parse("2018-03-20T18:14:01.184"), "5705676263", 10);
		ivan.realizarLlamada(LocalDateTime.parse("2018-03-20T18:14:01.184"), "5705676263", 10);
		
		Facturacion facturacionTom = new Facturacion(tom, "MARCH", 150);
		tom.realizarLlamada(LocalDateTime.parse("2018-03-27T18:14:01.184"), "263457415", 20);
		tom.realizarLlamada(LocalDateTime.parse("2018-03-27T18:14:01.184"), "263545785", 20);
		
		Facturacion facturacionErnesto = new Facturacion(ernesto, "JUNE", 150);
		ernesto.realizarLlamada(LocalDateTime.parse("2018-06-27T18:14:01.184"), "3874823231", 20);
		ernesto.realizarLlamada(LocalDateTime.parse("2018-06-27T18:14:01.184"), "3874823231", 20);
		
		Facturacion facturacionMariano = new Facturacion(mariano, "NOVEMBER", 150);
		mariano.realizarLlamada(LocalDateTime.parse("2018-11-27T18:14:01.184"), "3874823231", 20);
		mariano.realizarLlamada(LocalDateTime.parse("2018-11-27T18:14:01.184"), "3874823231", 20);
		mariano.realizarLlamada(LocalDateTime.parse("2018-11-27T18:14:01.184"), "3874823231", 10);
		
		System.out.println("FACTURA DEL USUARIO IVÁN EN EL MES MARZO");
		facturacionIvan.mostrarFactura();
		System.out.println("\n\n\n");
		System.out.println("FACTURA DEL USUARIO TOM EN EL MES MARZO");
		facturacionTom.mostrarFactura();
		System.out.println("\n\n\n");
		System.out.println("FACTURA DEL USUARIO ERNESTO EN EL MES JUNIO");
		facturacionErnesto.mostrarFactura();
		System.out.println("\n\n\n");
		System.out.println("FACTURA DEL USUARIO MARIANO EN EL MES NOVIEMBRE");
		facturacionMariano.mostrarFactura();
	}
//	public Usuario buscarUsuario(String numero) {
//	}
	
//	private double abonoMensual;
//	private double consumoLlamadasLocales;
//	private double consumoLlamadaIntern;
//	private double consumoLlamadaNacional;
	
	
//	public SistemaFacturacion(double abonoMensual) {
//		this.abonoMensual = abonoMensual; 
//	}
//	
//	public double getAbonoMensual() {
//		return this.abonoMensual;
//	}
	

}
