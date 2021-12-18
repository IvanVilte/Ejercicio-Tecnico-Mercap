package com.tecnicomercap.llamada.llamadaexterna;

import java.time.LocalDateTime;

import com.tecnicomercap.dias.DiasHabiles;
import com.tecnicomercap.llamada.Llamada;

public class LlamadaNacional extends Llamada{
	public static double COSTO_X_LLAMADA_NACIONAL_HABIL_DENTRO_HORARIO = 0.30;
	public static double COSTO_X_LLAMADA_NACIONAL_HABIL_FUERA_HORARIO = 0.20;
	public static double COSTO_X_LLAMADA_NACIONAL_NOHABIL = 0.20;
	
	public LlamadaNacional(LocalDateTime fechaLlamada, String numeroMarcado, int duracionMin) {
		super(fechaLlamada, numeroMarcado, duracionMin);
	}
	@Override
	public double calcularCosto(int horaHabilInicio, int horaHabilfin) {
		double costoLlamada = 0;
		String dia = getFechaLlamada().getDayOfWeek().toString();
		int horaLlamada = getHora();
		
		if(DiasHabiles.esDiaHabil(dia)) {
			if(horaHabilInicio <= horaLlamada && horaLlamada <= horaHabilfin) {
				costoLlamada = getDuracion() * COSTO_X_LLAMADA_NACIONAL_HABIL_DENTRO_HORARIO;
			}
			else {
				costoLlamada = getDuracion() * COSTO_X_LLAMADA_NACIONAL_HABIL_FUERA_HORARIO;
			}
		}
		else {
			costoLlamada = getDuracion() * COSTO_X_LLAMADA_NACIONAL_NOHABIL;
		}
		
		return costoLlamada;
	}
	
	

}
