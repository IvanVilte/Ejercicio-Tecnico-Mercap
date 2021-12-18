package com.tecnicomercap.codigoarea;

public enum CodigoNacional {
	BUENOSAIRES(222), MENDOZA(263), SANJUAN(264);

	private int codigo;
	CodigoNacional(int i) {
		this.codigo = i;
	} 
	private int getCodigo() {
		return this.codigo;
	}
	
	public static boolean esNacional(int codigo) {
		return codigo == BUENOSAIRES.getCodigo() || 
				codigo == MENDOZA.getCodigo()||
				codigo == SANJUAN.getCodigo();
	}
}
