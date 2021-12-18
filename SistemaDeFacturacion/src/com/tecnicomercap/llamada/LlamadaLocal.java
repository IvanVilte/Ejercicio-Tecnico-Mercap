package com.tecnicomercap.llamada;

import java.time.LocalDateTime;

import com.tecnicomercap.dias.DiasHabiles;

public class LlamadaLocal extends Llamada {

	public static double COSTO_X_MIN_DIA_HABIL_EN_HORARIO = 0.20;
	public static double COSTO_X_MIN_DIA_HABIL_FUERA_HORARIO = 0.10;
	public static double COSTO_X_MIN_DIA_NOHABIL = 0.10;
	
	public LlamadaLocal(LocalDateTime fechaLlamada, String numeroMarcado, int duracionMin) {
		super(fechaLlamada, numeroMarcado, duracionMin);
	}
	
	@Override
	public double calcularCosto(int horaHabilInicio, int horaHabilfin) {
		double costoLlamada = 0;
		String dia = getFechaLlamada().getDayOfWeek().toString();
		int horaLlamada = getHora();
		
		if(DiasHabiles.esDiaHabil(dia)) {
			if(horaHabilInicio <= horaLlamada && horaLlamada <= horaHabilfin) {
				costoLlamada = getDuracion() * COSTO_X_MIN_DIA_HABIL_EN_HORARIO;
			}
			else {
				costoLlamada = getDuracion() * COSTO_X_MIN_DIA_HABIL_FUERA_HORARIO;
			}
		}
		else {
			costoLlamada = getDuracion() * COSTO_X_MIN_DIA_NOHABIL;
		}
		
		return costoLlamada;
	}

}
