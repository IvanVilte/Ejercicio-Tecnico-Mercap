package com.tecnicomercap.llamada.llamadaexterna;

import java.time.LocalDateTime;

import com.tecnicomercap.dias.DiasHabiles;
import com.tecnicomercap.llamada.Llamada;

public class LlamadaInternacional extends Llamada{
	
	public static double COSTO_X_LLAMADA_INTERNACIONAL = 0.50;
	public static double COSTO_X_MIN_DIA_HABIL_EN_HORARIO = 0.30;
	public static double COSTO_X_MIN_DIA_HABIL_FUERA_HORARIO = 0.20;
	public static double COSTO_X_MIN_DIA_NOHABIL = 0.20;
	
	public LlamadaInternacional(LocalDateTime fechaLlamada, String numeroMarcado, int duracionMin) {
		super(fechaLlamada, numeroMarcado, duracionMin);
	}


	@Override
	public double calcularCosto(int horaHabilInicio, int horaHabilfin) {
		double costoLlamada = 0;
		String dia = getFechaLlamada().getDayOfWeek().toString();
		int horaLlamada = getHora();
		
		if(DiasHabiles.esDiaHabil(dia)) {
			if(horaHabilInicio <= horaLlamada && horaLlamada <= horaHabilfin) {
				costoLlamada = getDuracion() * COSTO_X_MIN_DIA_HABIL_EN_HORARIO + COSTO_X_LLAMADA_INTERNACIONAL;
			}
			else {
				costoLlamada = getDuracion() * COSTO_X_MIN_DIA_HABIL_FUERA_HORARIO + COSTO_X_LLAMADA_INTERNACIONAL;
			}
		}
		else {
			costoLlamada = getDuracion() * COSTO_X_MIN_DIA_NOHABIL + COSTO_X_LLAMADA_INTERNACIONAL;
		}
		
		return costoLlamada;
	}

}
