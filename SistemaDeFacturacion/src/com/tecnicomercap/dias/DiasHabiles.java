package com.tecnicomercap.dias;

public enum DiasHabiles {
	LUNES, MARTES, MIERCOLES, JUEVES, VIERNES;
	
	public static boolean esDiaHabil(String dia) {

		for(DiasHabiles diaHabil : DiasHabiles.values()) {
			if(diaHabil.toString().equals(dia)) {
				return true;
			}
		}
		return false;
	}
}
