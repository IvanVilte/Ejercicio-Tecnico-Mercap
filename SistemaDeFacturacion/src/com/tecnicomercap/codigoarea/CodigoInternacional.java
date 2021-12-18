package com.tecnicomercap.codigoarea;

public enum CodigoInternacional {
	ARGENTINA(549), BOLIVIA(591), PERU(510), COLOMBIA(570), MEXICO(520), ESPANIA(340), BRASIL(551), PORTUGAL(351);
	
	private int codigo;
	CodigoInternacional(int i) {
		this.codigo = i;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	public static boolean esInternacional(int codigo) {
		return codigo == ARGENTINA.getCodigo() ||
				codigo == BOLIVIA.getCodigo() ||
				codigo == PERU.getCodigo() ||
				codigo == COLOMBIA.getCodigo() ||
				codigo == MEXICO.getCodigo() ||
				codigo == ESPANIA.getCodigo() ||
				codigo == BRASIL.getCodigo() ||
				codigo == PORTUGAL.getCodigo();
	}
}
