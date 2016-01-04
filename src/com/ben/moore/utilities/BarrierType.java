package com.ben.moore.utilities;

public enum BarrierType {
	ENTRY("Entry"), EXIT("Exit");

	private String barrierType;

	private BarrierType(String barrierType) {
		this.barrierType = barrierType;
	}

	public String getBarrierType() {
		return this.barrierType;
	}

	public String toString() {
		return this.barrierType;
	}

}
