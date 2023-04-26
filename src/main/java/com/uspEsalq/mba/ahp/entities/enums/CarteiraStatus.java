package com.uspEsalq.mba.ahp.entities.enums;

public enum CarteiraStatus {
	CONSERVADOR(1),
	MODERADO(2),
	AGRESSIVO(3);
	
	private int enumCode;
	
	private CarteiraStatus(int code) {
		this.enumCode = code;
	}
	
	public int getCode() {
		return enumCode;
	}
	
	public static CarteiraStatus valueOf(int code) {
		for (CarteiraStatus value: CarteiraStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Perfil invalido");
	}
}


